public class OrderItem {
    // --- 1. Public Static Variable (ส่วนที่เพิ่มเข้ามา) ---
    public static int totalItemsCreated = 0; // นับจำนวนรายการ OrderItem ที่ถูกสร้างทั้งหมด

    // --- Private Instance Variables ---
    private MenuItem menuItem;
    private int quantity;
    private double subTotal;

    // --- Constructors ---
    // Constructor 1: ระบุจำนวนสินค้า
    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        calculateSubTotal();
        totalItemsCreated++; // เพิ่มจำนวนทันทีเมื่อสร้างรายการ
    }

    // Constructor 2: ไม่ระบุจำนวน (Default = 1)
    public OrderItem(MenuItem menuItem) {
        // เรียกใช้ Constructor 1 ดังนั้น totalItemsCreated จะถูกบวกในนั้น
        this(menuItem, 1);
    }

    // --- Getters & Setters ---
    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
        calculateSubTotal();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        calculateSubTotal();
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    // Helper Method
    private void calculateSubTotal() {
        if (this.menuItem != null) {
            this.subTotal = this.menuItem.getPrice() * this.quantity;
        }
    }

    public String toString() {
        return menuItem.getName() + " x" + quantity + " (" + subTotal + " บาท)";
    }
}