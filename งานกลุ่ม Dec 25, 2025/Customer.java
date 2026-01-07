public class Customer {
    // --- 1. Public Static Variable (ส่วนที่เพิ่มเข้ามา) ---
    public static int totalCustomers = 0; // ตัวแปรกลาง ไว้นับจำนวนลูกค้าทั้งหมด

    // --- Private Instance Variables ---
    private String customerId;
    private String name;
    private String phoneNumber;
    private String address;

    // --- Constructors ---
    // Constructor 1: แบบระบุที่อยู่ (Full Option)
    public Customer(String id, String name, String phone, String addr) {
        this.customerId = id;
        this.name = name;
        this.phoneNumber = phone;
        this.address = addr;
        totalCustomers++; // เพิ่มจำนวนลูกค้าทันทีที่สร้าง Object นี้
    }

    // Constructor 2: แบบไม่ระบุที่อยู่ (Pick-up)
    public Customer(String id, String name, String phone) {
        // เรียกใช้ Constructor 1 ดังนั้น totalCustomers จะถูกบวกใน Constructor 1 เอง
        this(id, name, phone, "รับเองที่ร้าน (Pick-up)");
    }

    // --- Getters & Setters ---
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Method
    public void placeOrder(Order order) {
        System.out.println("\nลูกค้า " + name + " (" + address + ") ยืนยันการสั่งซื้อ...");
        order.printReceipt();
    }
}