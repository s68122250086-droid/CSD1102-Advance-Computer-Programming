import javax.swing.*;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator extends JFrame {
    private JTextField emailField;
    private JLabel resultLabel;
    private JButton validateButton;
    private Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);

    public EmailValidator() {
        // --- การตั้งค่าหน้าต่างโปรแกรม ---
        setTitle("Email Validator");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // --- ส่วนประกอบ GUI ---
        add(new JLabel("Email:"));

        emailField = new JTextField(30); // ช่องกรอกอีเมล
        add(emailField);

        validateButton = new JButton("Validate");
        add(validateButton);

        resultLabel = new JLabel(""); // เลเบลสำหรับแสดงผล "Valid" หรือ "Invalid"
        resultLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(resultLabel);

        // --- Logic การตรวจสอบ ---
        validateButton.addActionListener(e -> {
            String email = emailField.getText();
            if (isValidEmail(email)) {
                resultLabel.setText("Valid email address.");
                resultLabel.setForeground(new Color(0, 200, 0)); // สีเขียวตามรูป
            } else {
                resultLabel.setText("Invalid email address.");
                resultLabel.setForeground(Color.RED); // สีแดงถ้าผิด
            }
        });
    }

    /**
     * Method ตรวจสอบอีเมลด้วย Regular Expression
     */
    private boolean isValidEmail(String email) {
        // รูปแบบ Regex สำหรับตรวจสอบโครงสร้างอีเมลพื้นฐาน
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmailValidator().setVisible(true);
        });
    }
}