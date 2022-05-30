package uz.epam.webproject.entity.user;

public enum UserRole {
    GUEST(/*"guest"*/),
    CLIENT(/*"client"*/),
    PHARMACIST(/*"pharmacist"*/),
    DOCTOR(/*"doctor"*/);

    //enum has method ordinal()


    public String getRoleName(){
        return this.name().toUpperCase();
//       return this.toString().toUpperCase();
    }

//    private final String roleName;
//
//    UserRole(String roleName) {
//        this.roleName = roleName;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
}
