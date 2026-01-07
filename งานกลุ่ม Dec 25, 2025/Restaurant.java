import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String restaurantId;
    private String name;
    private String location;
    private List<MenuItem> menuList;

    // Constructor 1: ระบุครบ (Main)
    public Restaurant(String id, String name, String location) {
        this.restaurantId = id;
        this.name = name;
        this.location = location;
        this.menuList = new ArrayList<>();
    }

    // Constructor 2: ไม่ระบุที่ตั้ง (ใส่ Default Location)
    public Restaurant(String id, String name) {
        this(id, name, "ไม่ระบุที่ตั้ง (Delivery Only)");
    }

    public void addMenuItem(MenuItem item) {
        menuList.add(item);
    }

    public String getName() {
        return name;
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