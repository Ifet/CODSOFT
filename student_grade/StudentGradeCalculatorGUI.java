import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculatorGUI extends JFrame implements ActionListener {

    private JTextField[] markFields;
    private JButton calculateButton;
    private JLabel totalMarksLabel, averagePercentageLabel, gradeLabel;

    public StudentGradeCalculatorGUI() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10));
        setLocationRelativeTo(null);

        markFields = new JTextField[5]; // Assuming maximum 5 subjects
        for (int i = 0; i < markFields.length; i++) {
            markFields[i] = new JTextField();
            markFields[i].setHorizontalAlignment(JTextField.CENTER);
            add(new JLabel("Subject " + (i + 1) + " Marks:"));
            add(markFields[i]);
        }

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(new JLabel());
        add(calculateButton);

        totalMarksLabel = new JLabel("Total Marks: ");
        add(totalMarksLabel);
        add(new JLabel());

        averagePercentageLabel = new JLabel("Average Percentage: ");
        add(averagePercentageLabel);
        add(new JLabel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            int[] marks = new int[markFields.length];
            int totalMarks = 0;
            for (int i = 0; i < markFields.length; i++) {
                try {
                    marks[i] = Integer.parseInt(markFields[i].getText());
                    totalMarks += marks[i];
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values only.");
                    return;
                }
            }
            int averagePercentage = totalMarks / markFields.length;
            String grade = getGrade(averagePercentage);

            totalMarksLabel.setText("Total Marks: " + totalMarks);
            averagePercentageLabel.setText("Average Percentage: " + averagePercentage + "%");
            gradeLabel.setText("Grade: " + grade);
        }
    }

    private String getGrade(int averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentGradeCalculatorGUI calculatorGUI = new StudentGradeCalculatorGUI();
            calculatorGUI.setVisible(true);
        });
    }
}

