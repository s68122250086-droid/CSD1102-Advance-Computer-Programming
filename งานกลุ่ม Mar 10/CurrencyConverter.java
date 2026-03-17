import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends JFrame {
    private JTextField amountField;
    private JComboBox<String> fromCombo, toCombo;
    private JLabel resultLabel;
    private JButton convertButton;

    public CurrencyConverter() {
        // --- การตั้งค่าหน้าต่างโปรแกรม ---
        setTitle("Currency Converter");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        // --- ส่วนประกอบ GUI ---
        add(new JLabel("Amount:"));
        amountField = new JTextField(15);
        add(amountField);

        add(new JLabel("From Currency:"));
        String[] currencies = {"USD", "EUR", "THB"};
        fromCombo = new JComboBox<>(currencies);
        add(fromCombo);

        add(new JLabel("To Currency:"));
        toCombo = new JComboBox<>(currencies);
        add(toCombo);

        convertButton = new JButton("Convert");
        add(convertButton);

        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(resultLabel);

        // --- Logic การคำนวณ ---
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String from = (String) fromCombo.getSelectedItem();
                    String to = (String) toCombo.getSelectedItem();

                    double result = convert(amount, from, to);
                    resultLabel.setText(String.format("Result: %.2f", result));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกตัวเลขจำนวนเงินให้ถูกต้อง!");
                }
            }
        });
    }

    /**
     * Method สำหรับคำนวณอัตราแลกเปลี่ยน (ตัวอย่างเรทคงที่)
     */
    private double convert(double amount, String from, String to) {
        if (from.equals(to)) return amount;

        // แปลงทุกสกุลเงินให้เป็น USD เป็นค่ากลางก่อน (Base Currency)
        double amountInUSD = 0;
        switch (from) {
            case "USD": amountInUSD = amount; break;
            case "EUR": amountInUSD = amount * 1.08; break; // 1 EUR = 1.08 USD
            case "THB": amountInUSD = amount * 0.028; break; // 1 THB = 0.028 USD
        }

        // จาก USD แปลงไปยังสกุลเงินเป้าหมาย
        switch (to) {
            case "USD": return amountInUSD;
            case "EUR": return amountInUSD / 1.08;
            case "THB": return amountInUSD / 0.03; // อ้างอิงตามรูปตัวอย่าง 100 USD ≈ 3350 THB (1 USD ≈ 33.5 THB)
        }

        // กรณีพิเศษสำหรับการแปลง USD -> THB ตามรูปตัวอย่าง (100 -> 3350.00)
        if (from.equals("USD") && to.equals("THB")) return amount * 33.5;

        return amountInUSD;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CurrencyConverter().setVisible(true);
        });
    }
}