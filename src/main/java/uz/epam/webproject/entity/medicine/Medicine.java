package uz.epam.webproject.entity.medicine;

import uz.epam.webproject.entity.AbstractEntity;

import java.io.Serial;
import java.util.Objects;
import java.util.StringJoiner;

public class Medicine extends AbstractEntity{

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private double price;
    private String description;
    private boolean withPrescription;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                Objects.equals(name, medicine.name) &&
                Objects.equals(description, medicine.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, withPrescription);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Medicine.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("price=" + price)
                .add("description='" + description + "'")
                .add("withPrescription=" + withPrescription)
                .toString();
    }
}
