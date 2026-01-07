public class DeliveryRider {
    private String riderId;
    private String name;
    private String vehiclePlate;
    private boolean isAvailable;

    // Constructor 1: มีรถขับ (Main)
    public DeliveryRider(String id, String name, String plate) {
        this.riderId = id;
        this.name = name;
        this.vehiclePlate = plate;
        this.isAvailable = true;
    }

    // Constructor 2: ไม่มีรถ (เดิน/จักรยาน)
    public DeliveryRider(String id, String name) {
        this(id, name, "ไม่มีพาหนะ (Walker/Bicycle)");
    }

    public void acceptOrder(Order order) {
        if (isAvailable) {
            System.out.println("Rider: " + name + " (" + vehiclePlate + ") รับงานออเดอร์ " + order.getOrderId() + " แล้ว");
            this.isAvailable = false;
            order.updateStatus("กำลังจัดส่ง (On Delivery)");
        } else {
            System.out.println("Rider: " + name + " ไม่ว่างรับงาน");
        }
    }
    
    public void completeDelivery(Order order) {
        System.out.println("Rider: " + name + " ส่งอาหารเรียบร้อยแล้ว!");
        this.isAvailable = true;
        order.updateStatus("จัดส่งสำเร็จ (Delivered)");
    }
}