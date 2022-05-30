package uz.epam.webproject.entity.order;

public enum OrderStatus {
    NEW(/*"new"*/),
    CONFIRMED(/*"confirmed"*/),
    COMPLETED(/*"completed"*/),
    CANCELED(/*"canceled"*/);

    public String getOrderName(){
        return this.name().toUpperCase();
    }

//    private final String value;
//
//    OrderStatus(String value) {
//        this.value = value;
//    }
//
//    public String getValue() {
//        return value;
//    }
}
