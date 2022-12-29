package cn.edu.whu.library.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.*;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

@Component
public class RSAUtil {
    private static final Logger log = LoggerFactory.getLogger(RSAUtil.class);
    // 指定加密算法为RSA
    private static final String ALGORITHM = "RSA";

    private static final String PUBLIC_KEY_FILE = "rsa/id_rsa.pub";
    private static final String PRIVATE_KEY_FILE = "rsa/id_rsa";

    public static void main(String[] args) throws Exception {
        // 生成 RSA 密钥对
//        genKeyPair();
        // RSA 加解密
        String plain = "nihao";
        String encryptedStr = encrypt(plain, new File(PUBLIC_KEY_FILE));
        System.out.println(encryptedStr);
        String decryptedStr = decrypt(encryptedStr, new File(PRIVATE_KEY_FILE));
        System.out.println(decryptedStr);
    }

    /**
     * 加密方法
     * @param plainText 源数据
     * @return
     * @throws Exception
     */
    public static String encrypt(String plainText, File keyFile) {
        String encryptedStr = null;

        try {
            Key key = getKey(keyFile);

            // 获取 Cipher 对象来实现对源数据的 RSA 加密
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);

            // 执行加密操作
            byte[] bytes = cipher.doFinal(plainText.getBytes("UTF-8"));
            encryptedStr = Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return encryptedStr;
    }

    /**
     * 解密算法
     * @param pwdText    密文
     * @return
     * @throws Exception
     */
    public static String decrypt(String pwdText, File keyFile) {
        String decryptedStr = null;
        try {
            Key key = getKey(keyFile);
            // 得到 Cipher 对象对已用公钥加密的数据进行 RSA 解密
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);

            // 執行解密操作
            byte[] bytes = Base64.getDecoder().decode(pwdText);

            decryptedStr = new String(cipher.doFinal(bytes));
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return decryptedStr;
    }

    /**
     * 从文件中读取秘钥信息
     * @param keyFile
     * @return
     * @throws Exception
     * @throws IOException
     */
    private static Key getKey(File keyFile) throws Exception, IOException {
        Key key;
        ObjectInputStream ois = null;
        try {
            // 将文件中的秘钥读出
            ois = new ObjectInputStream(new FileInputStream(keyFile));
            key = (Key) ois.readObject();
        } catch (Exception e) {
            throw e;
        } finally {
            if(ois != null){
                ois.close();
            }
        }
        return key;
    }

    private static final int KEY_SIZE = 2048;

    /**
     * 生成 RSA 密钥对
     * @return 在 Project 基目录生成名称为 [PUBLIC_KEY_FILE] 和 [PUBLIC_KEY_FILE] 的一对秘钥
     */
    public static String genKeyPair() {
        StringBuilder sb = new StringBuilder();

        // KeyPairGenerator 类用于生成公钥和私钥对，基于 RSA 算法生成对象
        String publicKeyString = null;
        String privateKeyString = null;
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM);
            // 初始化密钥对生成器
            keyPairGen.initialize(KEY_SIZE, new SecureRandom());
            // 生成一个密钥对，保存在keyPair中
            KeyPair keyPair = keyPairGen.generateKeyPair();
            // 获取密钥对
            Key privateKey = keyPair.getPrivate();
            Key publicKey = keyPair.getPublic();
            // 获取秘钥字符串
            publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());

            System.out.println("generate publicKey: " + publicKeyString);
            System.out.println("generate privateKey: " + privateKeyString);

            // 存储秘钥信息
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
            oos.writeObject(publicKey);
            oos.flush();
            oos.close();

            ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));
            oos2.writeObject(privateKey);
            oos2.flush();
            oos2.close();

            sb.append("publicKeyString: " + publicKeyString + "\nprivateKeyString: " + privateKeyString);
        } catch (Exception e) {
            sb.append("Error: " + e.getMessage());
        }

        return sb.toString();
    }
}
