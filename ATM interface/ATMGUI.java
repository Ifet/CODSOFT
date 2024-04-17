import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMGUI extends JFrame implements ActionListener {
    private BankAccount account;
    private JTextField depositField;
    private JTextField withdrawField;
    private JLabel balanceLabel;

    public ATMGUI(BankAccount account) {
        this.account = account;
        setTitle("ATM Machine");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel depositLabel = new JLabel("Deposit:");
        depositField = new JTextField();
        JLabel withdrawLabel = new JLabel("Withdraw:");
        withdrawField = new JTextField();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        balanceLabel = new JLabel("Balance: $" + account.checkBalance());

        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);

        panel.add(depositLabel);
        panel.add(depositField);
        panel.add(withdrawLabel);
        panel.add(withdrawField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(balanceLabel);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Deposit")) {
            double amount = Double.parseDouble(depositField.getText());
            if (account.deposit(amount)) {
                balanceLabel.setText("Balance: $" + account.checkBalance());
            }
        } else if (e.getActionCommand().equals("Withdraw")) {
            double amount = Double.parseDouble(withdrawField.getText());
            if (account.withdraw(amount)) {
                balanceLabel.setText("Balance: $" + account.checkBalance());
            }
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);  // Starting balance of 1000
        new ATMGUI(account);
    }
}

