package uz.epam.webproject.entity.receipt;

import uz.epam.webproject.entity.AbstractEntity;
import uz.epam.webproject.entity.medicine.Medicine;

import java.io.Serial;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.StringJoiner;

public class Receipt implements AbstractEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private long fromUserId;
    private long toUserId;
    private LinkedHashMap<Medicine, Integer> medicineList;
    private Timestamp assignedTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public LinkedHashMap<Medicine, Integer> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(LinkedHashMap<Medicine, Integer> medicineList) {
        this.medicineList = medicineList;
    }

    public Timestamp getAssignedTime() {
        return assignedTime;
    }

    public void setAssignedTime(Timestamp assignedTime) {
        this.assignedTime = assignedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receipt receipt = (Receipt) o;
        return id == receipt.id &&
                fromUserId == receipt.fromUserId &&
                toUserId == receipt.toUserId &&
                Objects.equals(medicineList, receipt.medicineList) &&
                Objects.equals(assignedTime, receipt.assignedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromUserId, toUserId, medicineList, assignedTime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Receipt.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("fromUserId=" + fromUserId)
                .add("toUserId=" + toUserId)
                .add("medicineList=" + medicineList)
                .add("assignedTime=" + assignedTime)
                .toString();
    }
}
