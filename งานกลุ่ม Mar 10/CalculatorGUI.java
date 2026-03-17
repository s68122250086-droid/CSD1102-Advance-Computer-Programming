import javax.swing.*; //extends JFrame: บอกว่าคลาสนี้คือ "หน้าต่างโปรแกรม"
import java.awt.*; // BorderLayout
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //implements ActionListener: บอกว่าคลาสนี้ "ดักจับการคลิกปุ่ม" ได้

//  1. การประกาศ Class และตัวแปร
public class CalculatorGUI extends  JFrame  implements ActionListener {
    private JTextField display; // ช่องแสดงตัวเลข
    private double num1 = 0 ,num2 = 0 , result = 0; //  ตัวแปรเก็บตัวเลขที่จะคำนวณ
    private char operator; // ตัวแปรเก็บเครื่องหมาย พวก + - * /

    public static void main(String[] args) {
        // คำสั่งสร้างออบเจกต์หน้าจอเครื่องคิดเลขและสั่งให้แสดงผล
        SwingUtilities.invokeLater(() -> {
            new CalculatorGUI().setVisible(true);
        });
    }

//  2. การสร้างหน้าจอ (Constructor)
    public CalculatorGUI(){
        setTitle("เครื่องคิดเลข"); // ตั้งชื่อ
        setSize(300,400); // กำหนดขนาด (กว้าง x สูง)
        setLayout(new BorderLayout()); // ใช้การจัดวางแบบแบ่งโซน (บน, กลาง, ล่าง)


        display = new JTextField(); // // สร้างช่องกรอกข้อความ
        display.setHorizontalAlignment(JTextField.RIGHT); // ให้ตัวเลขอยู่ชิดขวา
        add(display, BorderLayout.NORTH); // เอาช่องแสดงผลไปวางไว้ "ด้านบน"

//  3. การสร้างปุ่มด้วย GridLayout
    JPanel panel = new JPanel(); // สร้างแผงสำหรับวางปุ่ม
    panel.setLayout(new GridLayout(4,4)); // จัดปุ่มเป็นตาราง 4 แถว 4 คอลัมน์

    String[] buttons = {"7","8","9","/", "4","5","6","*", "1","2","3","-", "0",".","=","+"};
    for (String text: buttons) {
        JButton btn = new JButton(text); // สร้างปุ่มตามข้อความใน Array
        btn.addActionListener(this); // บอกปุ่มว่า "ถ้าโดนคลิก ให้มาเรียกใช้โค้ดในคลาสนี้"
        panel.add(btn); // เพิ่มปุ่มลงในแผง
    }
    add(panel, BorderLayout.CENTER); // เอาแผงปุ่มทั้งหมดไปวางไว้ "ตรงกลาง"

    }
    // 4. ส่วนการคำนวณ (Logic) ส่วนนี้จะทำงานเมื่อมีการกดปุ่ม (actionPerformed)
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand(); // ดูว่าปุ่มที่กดคือข้อความอะไร

        if ((cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') || cmd.equals(".")) {
            display.setText(display.getText() + cmd);
        }
        else if (cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/")) {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText()); // เก็บเลขตัวแรก (ต้องเป็น Double)
                operator = cmd.charAt(0); // เก็บเครื่องหมาย
                display.setText(""); // *** สำคัญ: ต้องล้างจอเพื่อรอรับเลขตัวที่สอง ***
            }
        }
        else if (cmd.equals("=")) {
            if (!display.getText().isEmpty()) {
                num2 = Double.parseDouble(display.getText()); // เก็บเลขตัวที่สอง

                // ใช้ switch-case ตรวจสอบเครื่องหมาย
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/':
                        if (num2 != 0) result = num1 / num2;
                        else { display.setText("Error"); return; } // กันการหารด้วยศูนย์
                        break;
                }
                display.setText(String.valueOf(result)); // แสดงผลลัพธ์
                num1 = result; // เก็บผลลัพธ์ไว้เผื่อคำนวณต่อ
            }
        }
    }
    }
