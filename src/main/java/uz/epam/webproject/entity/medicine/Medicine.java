package uz.epam.webproject.entity.medicine;

import uz.epam.webproject.entity.AbstractEntity;

import java.io.Serial;
import java.util.Objects;
import java.util.StringJoiner;

public class Medicine implements AbstractEntity{

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private double price;
    private String description;
    private boolean withPrescription;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isWithPrescription() {
        return withPrescription;
    }

    public void setWithPrescription(boolean withPrescription) {
        this.withPrescription = withPrescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return id == medicine.id &&
                Double.compare(medicine.price, price) == 0 &&
                withPrescription == medicine.withPrescription &&
                Objects.equals(title, medicine.title) &&
                Objects.equals(description, medicine.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description, withPrescription);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Medicine.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("price=" + price)
                .add("description='" + description + "'")
                .add("withPrescription=" + withPrescription)
                .toString();
    }
}
