import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGameUI extends JFrame {
    private int randomNumber;
    private int attempts;
    private int maxAttempts;
    private int score;

    private JLabel guessLabel;
    private JTextField guessField;
    private JButton guessButton;
    private JLabel resultLabel;
    private JButton playAgainButton;

    public NumberGameUI() {
        setTitle("Number Guessing Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        guessLabel = new JLabel("Enter your guess:");
        guessLabel.setBounds(20, 20, 120, 20);
        add(guessLabel);

        guessField = new JTextField();
        guessField.setBounds(150, 20, 100, 20);
        add(guessField);

        guessButton = new JButton("Guess");
        guessButton.setBounds(100, 50, 100, 30);
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        add(guessButton);

        resultLabel = new JLabel();
        resultLabel.setBounds(20, 90, 250, 20);
        add(resultLabel);

        playAgainButton = new JButton("Play Again");
        playAgainButton.setBounds(100, 120, 100, 30);
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });
        playAgainButton.setEnabled(true); // Initially disabled
        add(playAgainButton);

        startNewGame();
    }

    private void startNewGame() {
        randomNumber = (int) (Math.random() * 100) + 1;
        maxAttempts = 5;
        attempts = 0;
        score = 0;
        resultLabel.setText("");
        guessButton.setEnabled(true);
        guessField.setEnabled(true);
        playAgainButton.setEnabled(true);
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(guessField.getText());
            attempts++;

            if (guess == randomNumber) {
                resultLabel.setText("Congratulations! You guessed the number!");
                score += maxAttempts - attempts + 1;
                guessButton.setEnabled(false);
                guessField.setEnabled(false);
                playAgainButton.setEnabled(true);
            } else if (guess < randomNumber) {
                resultLabel.setText("Too low! Try again.");
            } else {
                resultLabel.setText("Too high! Try again.");
            }

            if (attempts >= maxAttempts) {
                resultLabel.setText("Sorry! You ran out of attempts. The number was: " + randomNumber);
                guessButton.setEnabled(false);
                guessField.setEnabled(false);
                playAgainButton.setEnabled(true);
            }
        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NumberGameUI().setVisible(true);
            }
        });
    }
}

