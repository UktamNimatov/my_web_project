package uz.epam.webproject.dao.mapper;

public enum ColumnName {
    ;
    /*
     * user
     * */
    public static final String ID = "id";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";
    public static final String ROLE = "role";

    /*
     * medicine
     * */
    public static final String TITLE = "title";
    public static final String PRICE = "price";
    public static final String DESCRIPTION = "description";
    public static final String WITH_PRESCRIPTION = "with_prescription";


    /*
     * order
     * */
    public static final String USER_ID = "user_id";
    public static final String STATUS = "status";
    public static final String ORDERED_TIME = "ordered_time";
    public static final String CONFIRMED_TIME = "confirmed_time";
    public static final String COMPLETED_TIME = "completed_time";
    public static final String CANCELED_TIME = "canceled_time";

}
