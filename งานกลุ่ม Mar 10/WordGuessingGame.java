import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordGuessingGame extends JFrame {
    private String targetWord = "PROGRAMMING"; // คำศัพท์เป้าหมาย
    private StringBuilder currentDisplay;      // เก็บสถานะการทาย เช่น P_O_______
    private int attemptsLeft = 5;              // จำนวนครั้งที่ทายได้

    private JLabel wordLabel, attemptsLabel, lengthLabel;
    private JTextField guessField;
    private JButton guessButton;
    private Font thaiFont = new Font("Tahoma", Font.BOLD, 14);

    public WordGuessingGame() {
        // --- การตั้งค่าหน้าต่าง ---
        setTitle("Word Guessing Game");
        setSize(550, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10)); // ใช้ Grid เพื่อให้แบ่งซ้ายขวาเหมือนรูป

        // เตรียมตัวแปรเริ่มเกม (สร้างขีดล่าง _ ตามจำนวนตัวอักษร)
        currentDisplay = new StringBuilder();
        for (int i = 0; i < targetWord.length(); i++) {
            currentDisplay.append("_");
        }

        // --- แถวที่ 1 ---
        add(new JLabel("Enter your guess:"));
        lengthLabel = new JLabel("Word length: " + targetWord.length() + " characters");
        add(lengthLabel);

        // --- แถวที่ 2 ---
        wordLabel = new JLabel("Word: " + formatDisplay(currentDisplay.toString()));
        wordLabel.setFont(new Font("Monospaced", Font.BOLD, 18)); // ใช้ Monospaced เพื่อให้ตัวอักษรห่างเท่ากัน
        add(wordLabel);

        guessField = new JTextField();
        add(guessField);

        // --- แถวที่ 3 ---
        guessButton = new JButton("Guess");
        add(guessButton);

        attemptsLabel = new JLabel("Attempts left: " + attemptsLeft);
        add(attemptsLabel);

        // --- Logic การทายคำ ---
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = guessField.getText().toUpperCase();
                guessField.setText(""); // ล้างช่องกรอก

                if (input.length() != 1) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกตัวอักษรทีละ 1 ตัว!");
                    return;
                }

                char guessChar = input.charAt(0);
                boolean found = false;

                // ตรวจเช็คว่าตัวอักษรที่ทาย มีอยู่ในคำไหม
                for (int i = 0; i < targetWord.length(); i++) {
                    if (targetWord.charAt(i) == guessChar) {
                        currentDisplay.setCharAt(i, guessChar);
                        found = true;
                    }
                }

                if (!found) {
                    attemptsLeft--; // ถ้าทายผิด ลดจำนวนครั้ง
                }

                updateUI(); // อัปเดตหน้าจอ
                checkGameState(); // เช็คว่าแพ้หรือชนะ
            }
        });
    }

    // ฟังก์ชันช่วยจัดรูปแบบตัวอักษรให้มีช่องว่าง เช่น P _ O _
    private String formatDisplay(String s) {
        return s.replace("", " ").trim();
    }

    private void updateUI() {
        wordLabel.setText("Word: " + formatDisplay(currentDisplay.toString()));
        attemptsLabel.setText("Attempts left: " + attemptsLeft);
    }

    private void checkGameState() {
        if (currentDisplay.toString().equals(targetWord)) {
            JOptionPane.showMessageDialog(this, "ยินดีด้วย! คุณชนะแล้ว คำนั้นคือ: " + targetWord);
            System.exit(0);
        } else if (attemptsLeft <= 0) {
            JOptionPane.showMessageDialog(this, "เสียใจด้วย! คุณแพ้แล้ว คำที่ถูกต้องคือ: " + targetWord);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordGuessingGame().setVisible(true));
    }
}