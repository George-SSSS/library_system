package cn.edu.whu.library.modules.enums;

public enum Role {
    STUDENT(0, "ROLE_STUDENT"),
    FACULTY(1, "ROLE_FACULTY"),
    STAFF(2, "ROLE_STAFF");

    private final int key;
    private final String roleName;

    private Role(int key, String roleName) {
        this.key = key;
        this.roleName = roleName;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public int getKey() {
        return this.key;
    }

}
