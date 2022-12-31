package cn.edu.whu.library.modules.enums;


public enum DocumentType {
    BOOK(0, "BOOK"),
    JOURNAL(1, "JOURNAL"),
    CONFERENCE_PROCEEDINGS(2, "CONFERENCE PROCEEDINGS");

    private final int key;
    private final String name;

    private DocumentType(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getKey() {
        return this.key;
    }

    public static DocumentType getTypeByKey(Integer key) {
        DocumentType documentType = null;
        switch (key) {
            case 0:
                documentType = DocumentType.BOOK;
                break;
            case 1:
                documentType = DocumentType.JOURNAL;
                break;
            case 2:
                documentType = DocumentType.CONFERENCE_PROCEEDINGS;
                break;
        }
        return documentType;
    }
}
