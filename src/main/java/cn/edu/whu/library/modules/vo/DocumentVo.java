package cn.edu.whu.library.modules.vo;

import cn.edu.whu.library.modules.enums.DocumentType;
import lombok.Data;

import java.math.BigInteger;

@Data
public class DocumentVo {
    private Integer documentId;

    private String title;

    private String publisherName;

    private String publisherDate;

    private Integer documentType;


    private String documentTypeName;

    public String getDocumentTypeName() {
        for(DocumentType documentType: DocumentType.values()) {
            if(this.documentType == documentType.getKey()) {
                return documentType.getName();
            }
        }
        return null;
    }

    /****************** Book ******************/
    private BigInteger isbn;

    private String author;

    /***************** Document_Copy ******************/
    private String libName;
}
