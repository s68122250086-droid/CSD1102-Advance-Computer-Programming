import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class TimeGreeting extends JFrame {
    private JLabel greetingLabel;

    public TimeGreeting() {
        // --- การตั้งค่าหน้าต่างโปรแกรม ---
        setTitle("Current Time Greeting");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- สร้างส่วนแสดงข้อความ ---
        greetingLabel = new JLabel("", SwingConstants.CENTER);
        greetingLabel.setFont(new Font("Arial", Font.PLAIN, 50)); // ปรับขนาดตัวอักษรให้ใหญ่ตามรูป
        add(greetingLabel, BorderLayout.CENTER);

        // --- ส่วนการประมวลผลเวลา ---
        updateGreeting();
    }

    private void updateGreeting() {
        // ดึงชั่วโมงปัจจุบัน (0-23)
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        String message;

        // ตรวจสอบช่วงเวลาเพื่อกำหนดข้อความ
        if (hour >= 5 && hour < 12) {
            message = "Good Morning";
        } else if (hour >= 12 && hour < 17) {
            message = "Good Afternoon";
        } else if (hour >= 17 && hour < 21) {
            message = "Good Evening";
        } else {
            message = "Good Night";
        }

        greetingLabel.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TimeGreeting().setVisible(true);
        });
    }
}