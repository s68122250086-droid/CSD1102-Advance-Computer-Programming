public class MenuItem {
    private String menuId;
    private String name;
    private double price;
    private String description;

    // Constructor 1: รับข้อมูลครบทุกอย่าง (Main)
    public MenuItem(String menuId, String name, double price, String description) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Constructor 2: รับแค่ชื่อกับราคา (คำอธิบายเป็นค่าว่าง)
    public MenuItem(String menuId, String name, double price) {
        this(menuId, name, price, "ไม่มีคำอธิบายสินค้า");
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return name + " (" + price + " บาท) - " + description;
    }
}