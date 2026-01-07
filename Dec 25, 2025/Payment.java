public class Payment {
    private String paymentId;
    private double amount;
    private String paymentMethod;
    private boolean isPaid;

    // Constructor 1: ระบุครบทุกอย่าง (Main)
    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.isPaid = false;
    }

    // Constructor 2: ระบุแค่ยอดเงิน (วิธีชำระเป็น Cash)
    public Payment(String paymentId, double amount) {
        this(paymentId, amount, "Cash (เงินสด)");
    }

    public boolean processPayment() {
        System.out.println("... กำลังตัดเงิน " + amount + " บาท ผ่านช่องทาง " + paymentMethod);
        this.isPaid = true;
        System.out.println("!! ชำระเงินสำเร็จ !!");
        return true;
    }
}