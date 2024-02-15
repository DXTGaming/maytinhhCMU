import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pheptoancoban2 extends JFrame {
    private JTextField txtEnterN, txtEnterMu;
    private JTextArea resultArea;
    private JButton btnTinhMu, btnRoot2, btnRoot3, btnTinhLogarit, btnExit;

    public pheptoancoban2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Calculator");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        txtEnterN = new JTextField();
        txtEnterN.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtEnterN.setText("Enter n");
        txtEnterN.setBounds(12, 50, 120, 35);
        mainPanel.add(txtEnterN);

        txtEnterMu = new JTextField();
        txtEnterMu.setText("Enter mu");
        txtEnterMu.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtEnterMu.setBounds(12, 100, 120, 35);
        mainPanel.add(txtEnterMu);

        resultArea = new JTextArea();
        resultArea.setBounds(160, 50, 200, 100);
        mainPanel.add(resultArea);

        btnTinhMu = new JButton("Tính Mũ");
        btnTinhMu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tinhMu();
            }
        });
        btnTinhMu.setBounds(121, 121, 111, 35);
        mainPanel.add(btnTinhMu);

        btnRoot2 = new JButton("Căn bậc 2");
        btnRoot2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                root2();
            }
        });
        btnRoot2.setBounds(132, 210, 102, 15);
        mainPanel.add(btnRoot2);

        btnRoot3 = new JButton("Căn bậc 3");
        btnRoot3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                root3();
            }
        });
        btnRoot3.setBounds(240, 180, 120, 25);
        mainPanel.add(btnRoot3);

        btnTinhLogarit = new JButton("Tính Logarit");
        btnTinhLogarit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tinhLogarit();
            }
        });
        btnTinhLogarit.setBounds(240, 220, 120, 25);
        mainPanel.add(btnTinhLogarit);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(308, 260, 80, 25);
        mainPanel.add(btnExit);

        getContentPane().add(mainPanel);
    }

    private void tinhMu() {
        try {
            int n = Integer.parseInt(txtEnterN.getText());
            int mu = Integer.parseInt(txtEnterMu.getText());

            double result = Math.pow(n, mu);
            resultArea.setText("Kết quả: " + result);
        } catch (NumberFormatException ex) {
            resultArea.setText("Lỗi: Nhập không hợp lệ");
        }
    }

    private void root2() {
        try {
            double n = Double.parseDouble(txtEnterN.getText());
            double result = Math.sqrt(n);
            resultArea.setText("Kết quả căn bậc 2: " + result);
        } catch (NumberFormatException ex) {
            resultArea.setText("Lỗi: Nhập không hợp lệ");
        }
    }

    private void root3() {
        try {
            double n = Double.parseDouble(txtEnterN.getText());
            double result = Math.cbrt(n);
            resultArea.setText("Kết quả căn bậc 3: " + result);
        } catch (NumberFormatException ex) {
            resultArea.setText("Lỗi: Nhập không hợp lệ");
        }
    }

    private void tinhLogarit() {
        try {
            double n = Double.parseDouble(txtEnterN.getText());
            double result = Math.log(n);
            resultArea.setText("Kết quả Logarit: " + result);
        } catch (NumberFormatException ex) {
            resultArea.setText("Lỗi: Nhập không hợp lệ");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new pheptoancoban().setVisible(true);
            }
        });
    }
}
