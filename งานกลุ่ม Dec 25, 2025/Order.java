import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    // --- 1. Public Static Variable (ส่วนที่เพิ่มเข้ามา) ---
    public static int totalOrders = 0; // ตัวแปรกลาง ไว้นับจำนวนออเดอร์ทั้งหมดในระบบ

    // --- Private Instance Variables ---
    private String orderId;
    private Date date;
    private double totalAmount;
    private String status;
    private List<OrderItem> items;
    private Payment payment;
    private Restaurant restaurant;

    // --- Constructors ---
    // Constructor 1: ระบุร้านค้าเลย (Standard)
    public Order(String orderId, Restaurant restaurant) {
        this.orderId = orderId;
        this.restaurant = restaurant;
        this.date = new Date();
        this.status = "Pending";
        this.items = new ArrayList<>();
        this.totalAmount = 0;
        totalOrders++; // เพิ่มจำนวนออเดอร์ทันทีเมื่อมีการสร้าง
    }

    // Constructor 2: สร้างใบเปล่าก่อน (Draft)
    public Order(String orderId) {
        this.orderId = orderId;
        this.date = new Date();
        this.status = "Draft (No Restaurant)";
        this.items = new ArrayList<>();
        this.totalAmount = 0;
        totalOrders++; // เพิ่มจำนวนออเดอร์ทันที
    }

    // --- Getters & Setters ---
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
        calculateTotal();
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPaymentObj(Payment payment) {
        this.payment = payment;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // --- Methods ---
    public void addOrderItem(OrderItem item) {
        items.add(item);
        calculateTotal();
    }

    public void calculateTotal() {
        this.totalAmount = 0;
        for (OrderItem item : items) {
            this.totalAmount += item.getSubTotal();
        }
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
        if (payment.processPayment()) {
            this.status = "Paid & Cooking";
        }
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("[Order Update] สถานะออเดอร์ " + orderId + " : " + status);
    }

    public void printReceipt() {
        System.out.println("\n----- ใบเสร็จ (Receipt) -----");
        System.out.println("Order ID: " + orderId);
        if (restaurant != null)
            System.out.println("ร้าน: " + restaurant.getName());
        System.out.println("รายการอาหาร:");
        for (OrderItem item : items) {
            System.out.println("  " + item.toString());
        }
        System.out.println("ยอดรวมสุทธิ: " + totalAmount + " บาท");
        System.out.println("สถานะ: " + status);
        System.out.println("-----------------------------");
    }
}