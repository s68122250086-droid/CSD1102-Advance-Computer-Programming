public class MenuItem {
    // --- 1. Public Static Variable (ส่วนที่เพิ่มเข้ามา) ---
    public static int totalMenuItems = 0; // ตัวแปรกลาง ไว้นับจำนวนเมนูที่ถูกสร้างขึ้น

    // --- Private Instance Variables ---
    private String menuId;
    private String name;
    private double price;
    private String description;

    // --- Constructors ---
    // Constructor 1: แบบระบุรายละเอียดครบ
    public MenuItem(String menuId, String name, double price, String description) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.description = description;
        totalMenuItems++; // เพิ่มจำนวนเมนูทันทีเมื่อมีการสร้างใหม่
    }

    // Constructor 2: แบบไม่ระบุคำอธิบาย (ใช้ Default)
    public MenuItem(String menuId, String name, double price) {
        // เรียกใช้ Constructor 1 ดังนั้น totalMenuItems จะถูกบวกในนั้น
        this(menuId, name, price, "ไม่มีคำอธิบายสินค้า");
    }

    // --- Getters & Setters ---
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Helper Method
    public String getDetails() {
        return name + " (" + price + " บาท) - " + description;
    }
}