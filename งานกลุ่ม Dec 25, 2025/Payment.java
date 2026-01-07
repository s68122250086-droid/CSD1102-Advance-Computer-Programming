public class Payment {
    // --- 1. Public Static Variable (ส่วนที่เพิ่มเข้ามา) ---
    public static int totalPayments = 0; // ตัวแปรกลาง ไว้นับจำนวนธุรกรรมการเงินที่เกิดขึ้น

    // --- Private Instance Variables ---
    private String paymentId;
    private double amount;
    private String paymentMethod;
    private boolean isPaid;

    // --- Constructors ---
    // Constructor 1: ระบุวิธีชำระเงิน
    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.isPaid = false;
        totalPayments++; // เพิ่มจำนวนธุรกรรมทันทีเมื่อสร้าง Object
    }

    // Constructor 2: ไม่ระบุวิธีชำระ (Default = Cash)
    public Payment(String paymentId, double amount) {
        // เรียกใช้ Constructor 1 ดังนั้น totalPayments จะถูกบวกในนั้น
        this(paymentId, amount, "Cash (เงินสด)");
    }

    // --- Getters & Setters ---
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    // Logic Method
    public boolean processPayment() {
        System.out.println("... กำลังตัดเงิน " + amount + " บาท ผ่านช่องทาง " + paymentMethod);
        this.isPaid = true;
        System.out.println("!! ชำระเงินสำเร็จ !!");
        return true;
    }
}