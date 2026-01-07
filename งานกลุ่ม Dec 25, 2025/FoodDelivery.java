public class FoodDelivery {
    public static void main(String[] args) {
        System.out.println("=== เริ่มต้นระบบ Food Delivery (Testing All Features) ===\n");

        // ---------------------------------------------------------
        // 1. ทดสอบ Class Restaurant (Static: totalRestaurants)

        System.out.println(">> 1. สร้างร้านค้า (Restaurants)");
        
        // [Constructor 1] ระบุที่ตั้งชัดเจน

        
        // [Constructor 2] ไม่ระบุที่ตั้ง (Delivery Only)
        Restaurant burgerKing = new Restaurant("R02", "Burger King Cloud");

        System.out.println("   -> จำนวนร้านค้าทั้งหมดตอนนี้: " + Restauran

        
        // ---------------------------------------------------------
        // 2. ทดสอบ Class MenuItem (Static: totalMenuItems)
        // --------------------------------------------------

        
        // [Constructor 1] ระบุคำอธิบายครบ
        MenuItem m1 = new MenuItem("M01", "ไก่ทอด", 45.0, "ไก่ทอดสูตรต้นตำรับ กรอบนอกนุ่มใน");
        

        MenuItem m2 = new MenuItem("B01", "Double Cheeseburger", 159.0);
        MenuItem m3 = new MenuItem("B02", "French Fries", 69.0);

        // เพิ่มเมนูเข้าร้าน
        kfc.addMenuItem(m1);
        burgerKing.addMenuItem(m2);
        burgerKing.addMenuItem(m3);

        System.out.println("   -> จำนวนเมนูทั้งหมดที่ถูกสร้าง: " + MenuItem.totalMenuItems); // ควรได้ 3


        // ---------------------------------------------------------
        // 3. ทดสอบ Class Customer (Static: totalCustomers)
        // ------------------------------

        
        // [Constructor 1] ระบุที่อยู่จัดส่ง
        Customer user1 = new Customer("C01", "คุณสมชาย", "081-111-2222", "คอนโด A ชั้น 5");

        // [Constructor 2] ไม่ระบุที่อยู่ (Pick-up)
        Customer user2 = new Customer("C02", "น้องพลอย", "099-888-7777");

        System.out.println("   -> จำนวนลูกค้าทั้งหมด: " + Customer.totalCustomers); // ควรได้ 2


        // ---------------------------------------------------------
        // 4. ทดสอบ Class Order & OrderItem (Static: totalOrders, totalItemsCreated)
        // ---------------------------------------------------------
        System.out.println("\n>> 4. สร้างออเดอร์ (Orders)");

        // --- Order ใบที่ 1 (ของสมชาย) ---
        // [Order Constructor 1] สร้างโดยระบุร้านค้าเลย
        Order order1 = new Order("ORD-001", burgerKing);
        
        // [OrderItem Constructor 1] ระบุจำนวนสินค้า (2 ชิ้น)
        OrderItem item1 = new OrderItem(m2, 2); 
        order1.addOrderItem(item1);

        // --- Order ใบที่ 2 (ของน้องพลอย) ---
        // [Order Constructor 2] สร้างใบเปล่าก่อน (Draft)
        Order order2 = new Order("ORD-002");
        order2.setRestaurant(kfc); // มา set ร้านทีหลัง
        
        // [OrderItem Constructor 2] ไม่ระบุจำนวน (Default = 1 ชิ้น)
        OrderItem item2 = new OrderItem(m1);
        order2.addOrderItem(item2);

        System.out.println("   -> จำนวนออเดอร์ทั้งหมด: " + Order.totalOrders); // ควรได้ 2
        System.out.println("   -> จำนวนรายการสินค้า (Items) ทั้งหมด: " + OrderItem.totalItemsCreated); // ควรได้ 2

        // ลูกค้ายืนยันออเดอร์
        user1.placeOrder(order1);
        user2.placeOrder(order2);


        // ---------------------------------------------------------
        // 5. ทดสอบ Class Payment (Static: totalPayments)
        // ---------------------------------------------------------
        System.out.println("\n>> 5. ชำระเงิน (Payments)");

        // [Constructor 1] ระบุวิธีชำระ (Credit Card)
        Payment pay1 = new Payment("P01", order1.getTotalAmount(), "Credit Card");
        order1.setPayment(pay1);

        // [Constructor 2] ไม่ระบุวิธี (Default = Cash)
        Payment pay2 = new Payment("P02", order2.getTotalAmount());
        order2.setPayment(pay2);

        System.out.println("   -> จำนวนธุรกรรมการเงินทั้งหมด: " + Payment.totalPayments); // ควรได้ 2


        // ---------------------------------------------------------
        // 6. ทดสอบ Class DeliveryRider (Static: totalRiders)
        // ---------------------------------------------------------
        System.out.println("\n>> 6. จัดส่ง (Delivery)");

        // [Constructor 1] มีรถขับ (ระบุทะเบียน)
        DeliveryRider rider1 = new DeliveryRider("D01", "พี่แกร็บ (วิน)", "1กข-9999");
        
        // [Constructor 2] ไม่มีรถ (Walker)
        DeliveryRider rider2 = new DeliveryRider("D02", "ป้าสมศรี Walker");

        System.out.println("   -> จำนวนไรเดอร์ในระบบ: " + DeliveryRider.totalRiders); // ควรได้ 2

        // เริ่มงานส่งของ
        rider1.acceptOrder(order1);
        rider1.completeDelivery(order1);

        System.out.println("--------------------------------");

        rider2.acceptOrder(order2);
        rider2.completeDelivery(order2);

        System.out.println("\n=== จบการทำงานของระบบ ===");
    }
}