public class FoodDelivery {
    public static void main(String[] args) {
        System.out.println("=== เริ่มต้นระบบ Food Delivery (New Constructors) ===");

        // [ใช้ Constructor 2] ร้านค้าแบบไม่ระบุที่ตั้ง
        Restaurant burgerKing = new Restaurant("R02", "Burger King Cloud"); 
        
        // [ใช้ Constructor 2] เมนูแบบไม่ใส่คำอธิบาย
        MenuItem m1 = new MenuItem("B01", "Whopper Jr.", 129.0); 
        MenuItem m2 = new MenuItem("B02", "Cheesy Fries", 89.0);
        
        burgerKing.addMenuItem(m1);
        burgerKing.addMenuItem(m2);

        // [ใช้ Constructor 2] ลูกค้าแบบรับเอง (Pick-up) ไม่ต้องใส่ที่อยู่
        Customer user = new Customer("C99", "สมชาย ใจดี", "081-111-2222");
        
        burgerKing.showMenu();

        // สร้าง Order
        Order myOrder = new Order("ORD-NEW-001", burgerKing);
        
        // [ใช้ Constructor 2] สั่งสินค้า 1 ชิ้น ไม่ต้องใส่เลขจำนวน
        myOrder.addOrderItem(new OrderItem(m1)); 
        // [ใช้ Constructor 1] สั่งสินค้า 2 ชิ้น (ต้องระบุเลข)
        myOrder.addOrderItem(new OrderItem(m2, 2)); 

        user.placeOrder(myOrder);

        // [ใช้ Constructor 2] ชำระเงินสด (ไม่ต้องระบุ Method)
        System.out.println("\n>>> ขั้นตอนการชำระเงิน <<<");
        Payment pay = new Payment("P-NEW", myOrder.getTotalAmount());
        myOrder.setPayment(pay);

        // [ใช้ Constructor 2] ไรเดอร์แบบเดินส่ง (ไม่ต้องระบุทะเบียน)
        System.out.println("\n>>> ค้นหาไรเดอร์ <<<");
        DeliveryRider walker = new DeliveryRider("D-01", "ป้าสมศรี Walker");
        walker.acceptOrder(myOrder);

        System.out.println("\n>>> ระหว่างขนส่ง <<<");
        walker.completeDelivery(myOrder);
        
        System.out.println("\n=== จบกระบวนการ ===");
    }
}