import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClock extends JFrame {
    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;

    public DigitalClock() {
        // --- การตั้งค่าหน้าต่างโปรแกรม ---
        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // ใช้ BorderLayout เพื่อให้เวลาอยู่กลางหน้าจอ

        // --- ตั้งค่ารูปแบบเวลา (ชั่วโมง:นาที:วินาที) ---
        timeFormat = new SimpleDateFormat("HH:mm:ss");

        // --- สร้าง Label แสดงเวลา และปรับแต่ง Font ให้ใหญ่เหมือนในรูป ---
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 60)); // ปรับขนาด Font เป็น 60
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER); // จัดข้อความให้อยู่กึ่งกลาง
        add(timeLabel, BorderLayout.CENTER);

        // --- ส่วนการอัปเดตเวลา (Timer) ---
        // 1000 คือ 1000 มิลลิวินาที = 1 วินาที
        Timer timer = new Timer(1000, e -> updateTime());
        timer.start(); // เริ่มทำงานทันที

        updateTime(); // เรียกครั้งแรกเพื่อให้เวลาแสดงทันทีที่เปิดโปรแกรม
    }

    // Method สำหรับดึงเวลาปัจจุบันมาแสดงผล
    private void updateTime() {
        // ดึงเวลาปัจจุบันจากระบบ
        String currentTime = timeFormat.format(Calendar.getInstance().getTime());
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        // รันโปรแกรมใน Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new DigitalClock().setVisible(true);
        });
    }
}