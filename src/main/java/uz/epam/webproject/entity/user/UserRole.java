package uz.epam.webproject.entity.user;

public enum UserRole {
    GUEST("guest"),
    CLIENT("client"),
    PHARMACIST("pharmacist"),
    DOCTOR("doctor");

    private final String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
