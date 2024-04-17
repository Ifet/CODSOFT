import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentCourseRegistrationGUI extends JFrame implements ActionListener {
    // GUI Components
    private JLabel courseLabel;
    private JList<String> courseList;
    private JButton registerButton;
    private JButton removeButton;
    private JTextArea studentInfoTextArea;

    // Constructor
    public StudentCourseRegistrationGUI() {
        // Initialize components
        courseLabel = new JLabel("Available Courses:");
        String[] courses = {"Course 1", "Course 2", "Course 3"}; // Sample course list
        courseList = new JList<>(courses);
        registerButton = new JButton("Register");
        removeButton = new JButton("Remove");
        studentInfoTextArea = new JTextArea(10, 30);

        // Set layout
        setLayout(new GridLayout(3, 1));

        // Add components to the frame
        add(courseLabel);
        add(new JScrollPane(courseList));
        add(registerButton);
        add(removeButton);
        add(studentInfoTextArea);

        // Add action listeners
        registerButton.addActionListener(this);
        removeButton.addActionListener(this);

        // Set frame properties
        setTitle("Student Course Registration System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Action performed method
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String selectedCourse = courseList.getSelectedValue();
            if (selectedCourse != null) {
                // Implement course registration logic
                studentInfoTextArea.append("Registered for: " + selectedCourse + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a course to register.");
            }
        } else if (e.getSource() == removeButton) {
            String studentCourses = studentInfoTextArea.getText();
            List<String> courseList = new ArrayList<>(Arrays.asList(studentCourses.split("\n")));
            String selectedCourse = JOptionPane.showInputDialog(this, "Enter the course to remove:");
            if (courseList.contains(selectedCourse)) {
                // Implement course removal logic
                courseList.remove(selectedCourse);
                studentInfoTextArea.setText(String.join("\n", courseList));
            } else {
                JOptionPane.showMessageDialog(this, "Course not found.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        new StudentCourseRegistrationGUI();
    }
}
