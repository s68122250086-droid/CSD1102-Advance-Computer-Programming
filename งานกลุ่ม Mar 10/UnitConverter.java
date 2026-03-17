import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitConverter extends JFrame {
    private JTextField inputField, resultField;
    private JComboBox<String> fromCombo, toCombo;
    private JButton convertButton;

    // กำหนด Font ที่รองรับภาษาไทย (Tahoma มีใน Windows ทุกเครื่อง)
    private Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);

    public UnitConverter() {
        setTitle("โปรแกรมแปลงหน่วยอุณหภูมิ");
        setSize(600, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 15, 20));

        // --- สร้าง Component และตั้งค่า Font ภาษาไทย ---
        JLabel label1 = new JLabel("ใส่ค่าตัวเลข:");
        label1.setFont(thaiFont);
        add(label1);

        inputField = new JTextField(10);
        add(inputField);

        JLabel label2 = new JLabel("จาก:");
        label2.setFont(thaiFont);
        add(label2);

        String[] units = {"Celsius", "Fahrenheit"};
        fromCombo = new JComboBox<>(units);
        fromCombo.setFont(thaiFont);
        add(fromCombo);

        JLabel label3 = new JLabel("ไปเป็น:");
        label3.setFont(thaiFont);
        add(label3);

        toCombo = new JComboBox<>(units);
        toCombo.setFont(thaiFont);
        add(toCombo);

        convertButton = new JButton("คำนวณ");
        convertButton.setFont(thaiFont); // ตั้งค่า Font ที่ปุ่มกด
        add(convertButton);

        JLabel label4 = new JLabel("ผลลัพธ์:");
        label4.setFont(thaiFont);
        add(label4);

        resultField = new JTextField(10);
        resultField.setEditable(false);
        add(resultField);

        // --- Logic การคำนวณ ---
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double input = Double.parseDouble(inputField.getText());
                    String from = (String) fromCombo.getSelectedItem();
                    String to = (String) toCombo.getSelectedItem();
                    double result = calculate(input, from, to);
                    resultField.setText(String.format("%.2f", result));
                } catch (NumberFormatException ex) {
                    // ปรับ Font ใน Pop-up ด้วย
                    UIManager.put("OptionPane.messageFont", thaiFont);
                    JOptionPane.showMessageDialog(null, "กรุณากรอกตัวเลขให้ถูกต้อง!");
                }
            }
        });
    }

    private double calculate(double val, String from, String to) {
        if (from.equals(to)) return val;
        if (from.equals("Celsius") && to.equals("Fahrenheit")) {
            return (val * 9 / 5) + 32;
        } else {
            return (val - 32) * 5 / 9;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UnitConverter().setVisible(true);
        });
    }
}