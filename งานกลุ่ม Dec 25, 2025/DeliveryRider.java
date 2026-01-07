public class DeliveryRider {
    // --- 1. Public Static Variable (ส่วนที่เพิ่มเข้ามา) ---
    public static int totalRiders = 0; // ตัวแปรกลาง ไว้นับจำนวนไรเดอร์ทั้งหมด

    // --- Private Instance Variables ---
    private String riderId;
    private String name;
    private String vehiclePlate;
    private boolean isAvailable;

    // --- Constructors ---
    // Constructor 1: แบบระบุทะเบียนรถ
    public DeliveryRider(String id, String name, String plate) {
        this.riderId = id;
        this.name = name;
        this.vehiclePlate = plate;
        this.isAvailable = true;
        totalRiders++; // เพิ่มจำนวนไรเดอร์ทุกครั้งที่มีการสร้าง Object
    }

    // Constructor 2: แบบไม่ระบุทะเบียน (Overloading)
    public DeliveryRider(String id, String name) {
        this(id, name, "ไม่มีพาหนะ (Walker/Bicycle)");
        // ไม่ต้อง totalRiders++ ตรงนี้ เพราะมันเรียก this(...) ไปทำในตัวบนแล้ว
    }

    // --- Getters & Setters ---
    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // --- Methods ---
    public void acceptOrder(Order order) {
        if (isAvailable) {
            System.out.println(
                    "Rider: " + name + " (" + vehiclePlate + ") รับงานออเดอร์ " + order.getOrderId() + " แล้ว");
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