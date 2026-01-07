import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private String orderId;
    private Date date;
    private double totalAmount;
    private String status;
    private List<OrderItem> items;
    private Payment payment;
    private Restaurant restaurant;

    // Constructor 1: ปกติ (Main)
    public Order(String orderId, Restaurant restaurant) {
        this.orderId = orderId;
        this.restaurant = restaurant;
        this.date = new Date();
        this.status = "Pending";
        this.items = new ArrayList<>();
        this.totalAmount = 0;
    }

    // Constructor 2: สร้างออเดอร์เปล่าๆ ไว้ก่อน (ยังไม่เลือกร้าน)
    // หมายเหตุ: ต้องระวัง NullPointerException ถ้าไปเรียก printReceipt ก่อน setRestaurant
    public Order(String orderId) {
        this.orderId = orderId;
        this.date = new Date();
        this.status = "Draft (No Restaurant)";
        this.items = new ArrayList<>();
        this.totalAmount = 0;
        // restaurant เป็น null
    }
    
    // method setRestaurant เพิ่มเข้ามาเผื่อกรณีใช้ Constructor 2
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

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
        if(payment.processPayment()) {
            this.status = "Paid & Cooking";
        }
    }
    
    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("[Order Update] สถานะออเดอร์ " + orderId + " : " + status);
    }

    public String getOrderId() { return orderId; }
    public double getTotalAmount() { return totalAmount; }

    public void printReceipt() {
        System.out.println("\n----- ใบเสร็จ (Receipt) -----");
        System.out.println("Order ID: " + orderId);
        
        if (restaurant != null) {
            System.out.println("ร้าน: " + restaurant.getName());
        } else {
            System.out.println("ร้าน: -- ไม่ระบุ --");
        }
        
        System.out.println("รายการอาหาร:");
        for (OrderItem item : items) {
            System.out.println("  " + item.toString());
        }
        System.out.println("ยอดรวมสุทธิ: " + totalAmount + " บาท");
        System.out.println("สถานะ: " + status);
        System.out.println("-----------------------------");
    }
}ไ