package cn.edu.whu.library.common.utils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;

public class MyBatisCodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/library?characterEncoding=UTF-8&useUnicode=true", "root", "ITK37412")
                // 全局配置
                .globalConfig(builder -> {
                    builder.author("George")    // 设置作者
                            .commentDate("yyyy-MM-dd")   //注释日期
                            .outputDir(System.getProperty("user.dir") + "/src/main/java") // 指定输出目录
                            .disableOpenDir()   //禁止打开输出目录，默认打开
                    ;
                })
                // 包配置
                .packageConfig(builder -> {
                    builder.parent("cn.edu.whu.library") // 设置父包名
                            .moduleName("modules")
                            .entity("pojo")
                            .controller("controller")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mappers")); // 设置mapper.Xml生成路径
                })
                // 策略配置
                .strategyConfig((scanner, builder) -> {
                    builder
                            .addInclude("document")                                       // 默认扫描所有表
                            /**
                            .addTablePrefix("sys_")                             // 过滤表前缀
                            .addTableSuffix("_bak")                             // 过滤表后缀
                            */
                            // Entity 策略配置
                            .entityBuilder()
                            .enableFileOverride()                               // 覆盖已生成文件
                            .enableLombok()                                     // 开启 Lombok
                            .naming(NamingStrategy.underline_to_camel)          // 数据库表映射到实体的命名策略：下划线转驼峰命
                            .columnNaming(NamingStrategy.underline_to_camel)    // 数据库表字段映射到实体的命名策略：下划线转驼峰命
                            .idType(IdType.AUTO)                                // 设置主键自增
                            .enableTableFieldAnnotation()                       // 开启生成实体时生成字段注解
                            // Controller 配置
                            .controllerBuilder()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .enableHyphenStyle()
                            // Mapper 策略配置
                            .mapperBuilder()
                            .enableFileOverride() // 覆盖已生成文件
                            .superClass(BaseMapper.class)
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .formatMapperFileName("%sMapper")
                            .formatXmlFileName("%sMapper")
                            // Service 策略配置
                            .serviceBuilder()
                            .formatServiceFileName("%sService") //格式化 service 接口文件名称，%s进行匹配表名，如 UserService
                            .formatServiceImplFileName("%sServiceImpl") //格式化 service 实现类文件名称，%s进行匹配表名，如 UserServiceImpl
                    ;
                }).templateEngine(new VelocityTemplateEngine())
                .execute();
    }
}
