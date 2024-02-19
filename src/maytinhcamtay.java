import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class maytinhcamtay extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    maytinhcamtay frame = new maytinhcamtay();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public maytinhcamtay() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 768, 508);
        contentPane = new JPanel();
        contentPane.setForeground(Color.RED);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("phép tính nâng cao");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pheptoancoban2 calculator2 = new pheptoancoban2();
                calculator2.setVisible(true);
            }
        });
        btnNewButton.setBounds(65, 196, 195, 57);
        contentPane.add(btnNewButton);

        JButton btnNewButton_2_1 = new JButton("phép tính cơ bản");
        btnNewButton_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pheptoancoban calculator = new pheptoancoban();
                calculator.setVisible(true);
            }
        });
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnNewButton_2_1.setBounds(49, 111, 195, 57);
        contentPane.add(btnNewButton_2_1);

        JButton btnNewButton_2_1_1_1 = new JButton("hàm luonggiac");
        btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                luonggiac calculator = new luonggiac();
                calculator.setVisible(true);
            }
        });
        btnNewButton_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_2_1_1_1.setBounds(315, 268, 207, 57);
        contentPane.add(btnNewButton_2_1_1_1);

        JButton btnNewButton_2_1_1_1_1 = new JButton("Số phức");
        btnNewButton_2_1_1_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pheptinhsophuc calculator = new pheptinhsophuc();
                calculator.setVisible(true);
            }
        });
        btnNewButton_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnNewButton_2_1_1_1_1.setBounds(523, 195, 141, 57);
        contentPane.add(btnNewButton_2_1_1_1_1);

        JLabel lblNewLabel = new JLabel("MÁY TÍNH ĐỜI MỚI TINH");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel.setForeground(Color.BLUE); // Set the text color
        lblNewLabel.setBounds(220, 33, 289, 40);
        contentPane.add(lblNewLabel);
    }
}
