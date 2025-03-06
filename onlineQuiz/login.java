package onlineQuiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Reference --> https://www.geeksforgeeks.org/java-keylistener-in-awt/
public class login extends JPanel implements ActionListener {

    private JTextField nameField; // Text field for entering the name
    private JButton submitButton; // button to submit the name
    private JLabel messageLabel; // Label to display messages
    public boolean loggedIn;
    public String name = "";

    // --------WHY CREATED CONSTRUCTOR-------------
    /*
     * When new login() is called in main.java, the constructor automatically sets
     * up everything.
     * If we didn’t define a constructor, we would have to manually initialize all
     * components, making the code more complex.
     */

    public login() {
        setLayout(null); // Disables default layout and allows manual positioning
        setBackground(Color.pink); // Sets the background color of the panel

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 40)); // Sets font style and size
        titleLabel.setBounds(250, 50, 200, 50); // Sets position (x, y) and size (width, height)
        add(titleLabel); // Adds the label to the panel

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Serif", Font.BOLD, 15));
        nameLabel.setBounds(200, 150, 100, 30);
        add(nameLabel);

        nameField = new JTextField(); // Creates an input field
        nameField.setBounds(300, 150, 200, 30); // Positioned next to the "Name:" label
        add(nameField); // Adds the text field to the panel

        submitButton = new JButton("Enter"); // Creates a button with text "Enter"
        submitButton.setBounds(300, 200, 100, 30); // Positioned below the text field
        submitButton.addActionListener(this); // Adds an event listener for button clicks
        add(submitButton); // Adds the button to the panel

        messageLabel = new JLabel();
        messageLabel = new JLabel(); // Creates an empty label for messages
        messageLabel.setBounds(200, 250, 400, 30); // Positioned below the button
        messageLabel.setFont(new Font("Serif", Font.BOLD, 15)); // Sets font style
        add(messageLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) { // Checks if the Enter button was clicked
            name = nameField.getText().trim(); // Gets the name from the text field
            if (!name.isEmpty()) { // If the name is not empty
                messageLabel.setText("Welcome, " + name + "!"); // Display welcome message
                // Get parent JFrame and dispose of it
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                if (parentFrame != null) {
                    parentFrame.dispose();
                }

                // Open Questions Window
                new Questions(name);
                loggedIn = true;
            } else {
                messageLabel.setText("Please enter your name."); // Prompt user to enter a name
            }
        }
    }
}
