import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    // --- 1. Public Static Variable (ส่วนที่เพิ่มเข้ามา) ---
    public static int totalRestaurants = 0; // ตัวแปรกลาง ไว้นับจำนวนร้านค้าทั้งหมด

    // --- Private Instance Variables ---
    private String restaurantId;
    private String name;
    private String location;
    private List<MenuItem> menuList;

    // --- Constructors ---
    // Constructor 1: ระบุที่ตั้ง (Full Option)
    public Restaurant(String id, String name, String location) {
        this.restaurantId = id;
        this.name = name;
        this.location = location;
        this.menuList = new ArrayList<>();
        totalRestaurants++; // เพิ่มจำนวนร้านค้าทันทีเมื่อสร้าง Object
    }

    // Constructor 2: ไม่ระบุที่ตั้ง (Delivery Only)
    public Restaurant(String id, String name) {
        // เรียกใช้ Constructor 1 ดังนั้น totalRestaurants จะถูกบวกในนั้น
        this(id, name, "ไม่ระบุที่ตั้ง (Delivery Only)");
    }

    // --- Getters & Setters ---
    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    // Methods
    public void addMenuItem(MenuItem item) {
        menuList.add(item);
    }

    public void showMenu() {
        System.out.println("=== เมนูร้าน " + name + " ===");
        if (menuList.isEmpty()) {
            System.out.println("(ยังไม่มีเมนู)");
        } else {
            for (MenuItem item : menuList) {
                System.out.println("- " + item.getDetails());
            }
        }
        System.out.println("==========================");
    }
}