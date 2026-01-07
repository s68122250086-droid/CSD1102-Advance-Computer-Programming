public class OrderItem {
    private MenuItem menuItem;
    private int quantity;
    private double subTotal;

    // Constructor 1: ระบุเมนูและจำนวน (Main)
    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        calculateSubTotal();
    }

    // Constructor 2: ระบุแค่เมนู (จำนวนเริ่มต้น = 1)
    public OrderItem(MenuItem menuItem) {
        this(menuItem, 1);
    }

    private void calculateSubTotal() {
        this.subTotal = this.menuItem.getPrice() * this.quantity;
    }

    public double getSubTotal() { return subTotal; }
    
    public String toString() {
        return menuItem.getName() + " x" + quantity + " (" + subTotal + " บาท)";
    }
}