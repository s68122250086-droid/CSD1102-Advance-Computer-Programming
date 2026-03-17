import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JFrame {
    private JLabel timeLabel, staticLabel;
    private JButton startStopButton, resetButton, exitButton;

    private Timer timer;
    private int elapsedTime = 0; // เก็บเวลาเป็นมิลลิวินาที
    private boolean running = false;

    public Stopwatch() {
        // --- การตั้งค่าหน้าต่าง ---
        setTitle("Stopwatch");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10)); // แบ่งช่องตามรูป (3 แถว 2 คอลัมน์)

        // --- ส่วนแสดงตัวเลขเวลา ---
        // ตัวเลขสีน้ำเงิน (เวลาที่กำลังเดิน)
        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        timeLabel.setForeground(Color.BLUE);
        add(timeLabel);

        // ตัวเลขสีแดง (มักใช้แสดงเวลาหยุด หรือเวลาเริ่มต้น)
        staticLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        staticLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        staticLabel.setForeground(Color.RED);
        add(staticLabel);

        // --- ส่วนปุ่มควบคุม ---
        startStopButton = new JButton("Start");
        startStopButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(startStopButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(resetButton);

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(exitButton);

        // เติมช่องว่างให้ครบ Grid (ช่องที่ 6)
        add(new JLabel(""));

        // --- การทำงานของ Timer (อัปเดตทุก 1 วินาที) ---
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime += 1000;
                updateTimeDisplay();
            }
        });

        // --- Event Listeners ---

        // ปุ่ม Start / Stop
        startStopButton.addActionListener(e -> {
            if (!running) {
                timer.start();
                running = true;
                startStopButton.setText("Stop");
            } else {
                timer.stop();
                running = false;
                startStopButton.setText("Start");
            }
        });

        // ปุ่ม Reset
        resetButton.addActionListener(e -> {
            timer.stop();
            running = false;
            elapsedTime = 0;
            startStopButton.setText("Start");
            updateTimeDisplay();
        });

        // ปุ่ม Exit
        exitButton.addActionListener(e -> System.exit(0));
    }

    // ฟังก์ชันคำนวณมิลลิวินาทีให้เป็นรูปแบบ HH:mm:ss
    private void updateTimeDisplay() {
        int hours = (elapsedTime / 3600000);
        int minutes = (elapsedTime / 60000) % 60;
        int seconds = (elapsedTime / 1000) % 60;

        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(timeString);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Stopwatch().setVisible(true));
    }
}