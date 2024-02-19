import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pheptinhsophuc extends JFrame {
    private JTextField txtReal1;
    private JTextField txtImaginary1;
    private JTextField txtReal2;
    private JTextField txtImaginary2;
    private JTextArea resultArea;

    public pheptinhsophuc() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator - Phép tính số phức");
        setSize(400, 300);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 2, 5, 5));

        JLabel lblReal1 = new JLabel("Phần thực số phức 1 (a):");
        mainPanel.add(lblReal1);
        txtReal1 = new JTextField();
        mainPanel.add(txtReal1);

        JLabel lblImaginary1 = new JLabel("Phần ảo số phức 1 (b):");
        mainPanel.add(lblImaginary1);
        txtImaginary1 = new JTextField();
        mainPanel.add(txtImaginary1);

        JLabel lblReal2 = new JLabel("Phần thực số phức 2 (c):");
        mainPanel.add(lblReal2);
        txtReal2 = new JTextField();
        mainPanel.add(txtReal2);

        JLabel lblImaginary2 = new JLabel("Phần ảo số phức 2 (d):");
        mainPanel.add(lblImaginary2);
        txtImaginary2 = new JTextField();
        mainPanel.add(txtImaginary2);

        JButton btnAdd = new JButton("Cộng");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performComplexNumberAddition();
            }
        });
        mainPanel.add(btnAdd);

        JButton btnSubtract = new JButton("Trừ");
        btnSubtract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performComplexNumberSubtraction();
            }
        });
        mainPanel.add(btnSubtract);

        JButton btnMultiply = new JButton("Nhân");
        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performComplexNumberMultiplication();
            }
        });
        mainPanel.add(btnMultiply);

        JButton btnDivide = new JButton("Chia");
        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performComplexNumberDivision();
            }
        });
        mainPanel.add(btnDivide);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        mainPanel.add(scrollPane);

        getContentPane().add(mainPanel);
    }

    // Phương thức thực hiện phép cộng số phức
    public void performComplexNumberAddition() {
        double real1 = Double.parseDouble(txtReal1.getText());
        double imaginary1 = Double.parseDouble(txtImaginary1.getText());
        double real2 = Double.parseDouble(txtReal2.getText());
        double imaginary2 = Double.parseDouble(txtImaginary2.getText());

        double sumReal = real1 + real2;
        double sumImaginary = imaginary1 + imaginary2;
        resultArea.setText("Tổng của hai số phức là: " + sumReal + " + " + sumImaginary + "i");
    }

    // Phương thức thực hiện phép trừ số phức
    public void performComplexNumberSubtraction() {
        double real1 = Double.parseDouble(txtReal1.getText());
        double imaginary1 = Double.parseDouble(txtImaginary1.getText());
        double real2 = Double.parseDouble(txtReal2.getText());
        double imaginary2 = Double.parseDouble(txtImaginary2.getText());

        double diffReal = real1 - real2;
        double diffImaginary = imaginary1 - imaginary2;
        resultArea.setText("Hiệu của hai số phức là: " + diffReal + " + " + diffImaginary + "i");
    }

    // Phương thức thực hiện phép nhân số phức
    public void performComplexNumberMultiplication() {
        double real1 = Double.parseDouble(txtReal1.getText());
        double imaginary1 = Double.parseDouble(txtImaginary1.getText());
        double real2 = Double.parseDouble(txtReal2.getText());
        double imaginary2 = Double.parseDouble(txtImaginary2.getText());

        double productReal = real1 * real2 - imaginary1 * imaginary2;
        double productImaginary = real1 * imaginary2 + real2 * imaginary1;
        resultArea.setText("Tích của hai số phức là: " + productReal + " + " + productImaginary + "i");
    }

    // Phương thức thực hiện phép chia số phức
    public void performComplexNumberDivision() {
        double real1 = Double.parseDouble(txtReal1.getText());
        double imaginary1 = Double.parseDouble(txtImaginary1.getText());
        double real2 = Double.parseDouble(txtReal2.getText());
        double imaginary2 = Double.parseDouble(txtImaginary2.getText());

        double denominator = real2 * real2 + imaginary2 * imaginary2;
        double divisionReal = (real1 * real2 + imaginary1 * imaginary2) / denominator;
        double divisionImaginary = (imaginary1 * real2 - real1 * imaginary2) / denominator;
        resultArea.setText("Thương của hai số phức là: " + divisionReal + " + " + divisionImaginary + "i");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new pheptinhsophuc().setVisible(true);
            }
        });
    }
}
