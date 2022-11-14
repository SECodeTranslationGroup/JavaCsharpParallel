package parallel.linq101.datasource;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {

    private Integer orderId;
    private LocalDate orderDate;
    private Double total;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Order(Integer orderId, LocalDate orderDate, Double total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.total = total;
    }

    @Override
    public String toString() {
        return "(Order " +
                "id=" + orderId +
                ", total=" + total +
                ')';
    }
}