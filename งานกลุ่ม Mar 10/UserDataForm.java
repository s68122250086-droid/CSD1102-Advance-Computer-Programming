import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDataForm extends JFrame {
    private JTextField nameField, addressField, phoneField;
    private JTextArea displayArea;
    private JButton submitButton;
    private Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);

    public UserDataForm() {
        // --- การตั้งค่าหน้าต่างโปรแกรม ---
        setTitle("User Data Form");
        setSize(850, 250); // ปรับขนาดให้กว้างตามรูปตัวอย่าง
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        // --- ส่วนกรอกชื่อ (Name) ---
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(thaiFont);
        add(nameLabel);
        nameField = new JTextField(15);
        add(nameField);

        // --- ส่วนกรอกที่อยู่ (Address) ---
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(thaiFont);
        add(addressLabel);
        addressField = new JTextField(20);
        add(addressField);

        // --- ส่วนกรอกเบอร์โทรศัพท์ (Phone Number) ---
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneLabel.setFont(thaiFont);
        add(phoneLabel);
        phoneField = new JTextField(15);
        add(phoneField);

        // --- ปุ่ม Submit ---
        submitButton = new JButton("Submit");
        submitButton.setFont(thaiFont);
        add(submitButton);

        // --- ส่วนแสดงผลลัพธ์ (User Data Display) ---
        JLabel dataLabel = new JLabel("User Data:");
        dataLabel.setFont(thaiFont);
        add(dataLabel);

        // JTextArea สำหรับแสดงข้อมูลหลายบรรทัด
        displayArea = new JTextArea(5, 25);
        displayArea.setFont(thaiFont);
        displayArea.setEditable(false); // อ่านได้อย่างเดียว
        displayArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // เพิ่มเส้นขอบ
        add(displayArea);

        // --- Logic เมื่อกดปุ่ม Submit ---
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ดึงข้อมูลจากช่องกรอก
                String name = nameField.getText();
                String address = addressField.getText();
                String phone = phoneField.getText();

                // นำมาต่อกันเพื่อแสดงผลใน JTextArea (\n คือการขึ้นบรรทัดใหม่)
                String result = "Name: " + name + "\n" +
                        "Address: " + address + "\n" +
                        "Phone: " + phone;

                displayArea.setText(result);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UserDataForm().setVisible(true);
        });
    }
}