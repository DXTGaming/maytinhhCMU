import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class pheptoancoban extends JFrame {
    private JTextField txtEnterA, txtEnterB;
    private JTextArea resultArea;
    private JButton btnCộng, btnTrừ, btnNhân, btnchia, btnRollDice, btnExit;

    public pheptoancoban() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setTitle("Calculator With Dice");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        txtEnterA = new JTextField();
        txtEnterA.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtEnterA.setText("Enter A");
        txtEnterA.setBounds(12, 50, 120, 35);
        mainPanel.add(txtEnterA);

        txtEnterB = new JTextField();
        txtEnterB.setText("Enter B");
        txtEnterB.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtEnterB.setBounds(12, 100, 120, 35);
        mainPanel.add(txtEnterB);

        resultArea = new JTextArea();
        resultArea.setBounds(160, 50, 200, 100);
        mainPanel.add(resultArea);

        btnCộng = new JButton("Cộng");
        btnCộng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("Cộng");
            }
        });
        btnCộng.setBounds(122, 180, 80, 25);
        mainPanel.add(btnCộng);

        btnTrừ = new JButton("Trừ");
        btnTrừ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("Trừ");
            }
        });
        btnTrừ.setBounds(100, 180, 80, 25);
        mainPanel.add(btnTrừ);

        btnNhân = new JButton("Nhân");
        btnNhân.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("Nhân");
            }
        });
        btnNhân.setBounds(200, 183, 100, 25);
        mainPanel.add(btnNhân);

        btnchia = new JButton("chia");
        btnchia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performOperation("chia");
            }
        });
        btnchia = new JButton("Phép Chia");
btnchia.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        performOperation("chia");
    }
});
btnchia.setBounds(300, 180, 80, 25);  // Adjust the bounds as needed
mainPanel.add(btnchia);

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setBounds(308, 220, 80, 25);
        mainPanel.add(btnExit);

        getContentPane().add(mainPanel);
    }

    private void performOperation(String operation) {
        try {
            int a = Integer.parseInt(txtEnterA.getText());
            int b = Integer.parseInt(txtEnterB.getText());

            int result = 0;
            switch (operation) {
                case "Cộng":
                    result = a + b;
                    break;
                case "Trừ":
                    result = a - b;
                    break;
                case "Nhân":
                    result = a * b;
                    break;
                case "chia":
                    if(b == 0){
                        resultArea.setText("Answer: Vô nghiệm ");
                        return;
                    }else{
                        result = a / b;
                    } 
                    break;
                   
            }

            resultArea.setText("Answer: " + result);
        } catch (NumberFormatException ex) {
            resultArea.setText("Error");
        }
    }

    private void rollDice() {
        Random random = new Random();
        int randomNumber = random.nextInt(6) + 1; 

       
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            updateDiceLabel(random.nextInt(6) + 1);
        }

        
        updateDiceLabel(randomNumber);
    }

    private void updateDiceLabel(int number) {
        resultArea.setText("Dice: " + number);
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
