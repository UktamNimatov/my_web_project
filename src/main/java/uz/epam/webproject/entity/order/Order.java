package uz.epam.webproject.entity.order;

import uz.epam.webproject.entity.AbstractEntity;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.StringJoiner;

public class Order implements AbstractEntity{

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;
    private long userId;
    private OrderStatus status;
    private Timestamp orderedTime;
    private Timestamp confirmedTime;
    private Timestamp completedTime;
    private Timestamp canceledTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Timestamp getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Timestamp orderedTime) {
        this.orderedTime = orderedTime;
    }

    public Timestamp getConfirmedTime() {
        return confirmedTime;
    }

    public void setConfirmedTime(Timestamp confirmedTime) {
        this.confirmedTime = confirmedTime;
    }

    public Timestamp getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(Timestamp completedTime) {
        this.completedTime = completedTime;
    }

    public Timestamp getCanceledTime() {
        return canceledTime;
    }

    public void setCanceledTime(Timestamp canceledTime) {
        this.canceledTime = canceledTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                userId == order.userId &&
                status == order.status &&
                Objects.equals(orderedTime, order.orderedTime) &&
                Objects.equals(confirmedTime, order.confirmedTime) &&
                Objects.equals(completedTime, order.completedTime) &&
                Objects.equals(canceledTime, order.canceledTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, status, orderedTime, confirmedTime, completedTime, canceledTime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userId=" + userId)
                .add("status=" + status)
                .add("orderedTime=" + orderedTime)
                .add("confirmedTime=" + confirmedTime)
                .add("completedTime=" + completedTime)
                .add("canceledTime=" + canceledTime)
                .toString();
    }
}
