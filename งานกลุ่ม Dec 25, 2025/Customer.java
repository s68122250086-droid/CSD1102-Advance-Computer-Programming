public class Customer {
    private String customerId;
    private String name;
    private String phoneNumber;
    private String address;

    // Constructor 1: ส่งถึงบ้าน (Main)
    public Customer(String id, String name, String phone, String addr) {
        this.customerId = id;
        this.name = name;
        this.phoneNumber = phone;
        this.address = addr;
    }

    // Constructor 2: มารับเอง (Pick-up)
    public Customer(String id, String name, String phone) {
        this(id, name, phone, "รับเองที่ร้าน (Pick-up)");
    }

    public void placeOrder(Order order) {
        System.out.println("\nลูกค้า " + name + " (" + address + ") ยืนยันการสั่งซื้อ...");
        order.printReceipt();
    }
}