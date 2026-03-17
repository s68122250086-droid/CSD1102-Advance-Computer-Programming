import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaCalculator extends JFrame {
    private JComboBox<String> shapeCombo;
    private JTextField inputField1, inputField2;
    private JLabel label1, label2, resultLabel;
    private JButton calculateButton;

    public AreaCalculator() {
        // --- การตั้งค่าหน้าต่างโปรแกรม ---
        setTitle("Area Calculator");
        setSize(650, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        // --- ส่วนเลือกรูปทรง (JComboBox) ---
        String[] shapes = {"Circle", "Rectangle", "Triangle"};
        shapeCombo = new JComboBox<>(shapes);
        add(shapeCombo);

        // --- ช่องกรอกค่าที่ 1 (Radius หรือ Length) ---
        label1 = new JLabel("Enter radius (for Circle) or length (for Rectangle/Triangle):");
        add(label1);
        inputField1 = new JTextField(10);
        add(inputField1);

        // --- ช่องกรอกค่าที่ 2 (Height - เฉพาะรูปทรงที่ต้องใช้) ---
        label2 = new JLabel("Enter height (for Triangle):");
        add(label2);
        inputField2 = new JTextField(10);
        add(inputField2);

        // --- ปุ่มคำนวณและแสดงผล ---
        calculateButton = new JButton("Calculate");
        add(calculateButton);

        resultLabel = new JLabel("Area: ");
        resultLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(resultLabel);

        // --- Logic การคำนวณ ---
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selectedShape = (String) shapeCombo.getSelectedItem();
                    double val1 = Double.parseDouble(inputField1.getText());
                    double area = 0;

                    if (selectedShape.equals("Circle")) {
                        // สูตรวงกลม: π * r²
                        area = Math.PI * Math.pow(val1, 2);
                    } else if (selectedShape.equals("Rectangle")) {
                        // สูตรสี่เหลี่ยม: กว้าง * ยาว (ในที่นี้ใช้ค่าจากช่อง 2 เป็นกว้าง)
                        double val2 = Double.parseDouble(inputField2.getText());
                        area = val1 * val2;
                    } else if (selectedShape.equals("Triangle")) {
                        // สูตรสามเหลี่ยม: 0.5 * ฐาน * สูง
                        double val2 = Double.parseDouble(inputField2.getText());
                        area = 0.5 * val1 * val2;
                    }

                    resultLabel.setText("Area: " + area);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "กรุณากรอกตัวเลขให้ครบถ้วน!");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AreaCalculator().setVisible(true);
        });
    }
}