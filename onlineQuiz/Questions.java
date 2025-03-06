package onlineQuiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Questions extends JFrame implements ActionListener {
    // Array of questions
    String questions[][] = {
            { "What is Java?", "A programming language", "A coffee", "An island", "None of the above" },
            { "Who invented Java?", "James Gosling", "Dennis Ritchie", "Guido van Rossum", "Bjarne Stroustrup" },
            { "Which company owns Java?", "Oracle", "Microsoft", "Google", "Apple" },
            { "Which keyword is used to create objects in Java?", "new", "class", "object", "instance" },
            { "Which data type is used to store decimal numbers?", "float", "int", "boolean", "char" }
    };

    // array of correct answers
    String answers[] = { "A programming language", "James Gosling", "Oracle", "new", "float" };

    JLabel q_no, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupOptions;
    JButton next, submit;
    String name;
    int currentQuestion = 0;
    public int userScore = 0;

    Questions(String name) {
        this.name = name;
        setTitle("Quiz for " + name);
        setBounds(50, 0, 800, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        q_no = new JLabel();
        q_no.setBounds(50, 50, 50, 30);
        add(q_no);

        question = new JLabel();
        question.setBounds(100, 50, 600, 30);
        add(question);

        opt1 = new JRadioButton();
        opt1.setBounds(100, 100, 400, 30);
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(100, 150, 400, 30);
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(100, 200, 400, 30);
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(100, 250, 400, 30);
        add(opt4);

        // Grouping radio buttons so only one option can be selected
        groupOptions = new ButtonGroup();
        groupOptions.add(opt1);
        groupOptions.add(opt2);
        groupOptions.add(opt3);
        groupOptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(200, 350, 100, 30);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(350, 350, 100, 30);
        submit.addActionListener(this);
        submit.setEnabled(false); // Initially disabled
        add(submit);

        loadQuestion();
        setVisible(true);
    }

    // method to load questions
    public void loadQuestion() {
        if (currentQuestion < questions.length) {
            q_no.setText((currentQuestion + 1) + ".");
            question.setText(questions[currentQuestion][0]);
            opt1.setText(questions[currentQuestion][1]);
            opt2.setText(questions[currentQuestion][2]);
            opt3.setText(questions[currentQuestion][3]);
            opt4.setText(questions[currentQuestion][4]);
            groupOptions.clearSelection();
        }
    }

    // Method to check if the selected answer is correct
    public void checkAnswer() {
        String selectedAnswer = null;
        if (opt1.isSelected())
            selectedAnswer = opt1.getText();
        if (opt2.isSelected())
            selectedAnswer = opt2.getText();
        if (opt3.isSelected())
            selectedAnswer = opt3.getText();
        if (opt4.isSelected())
            selectedAnswer = opt4.getText();

        if (selectedAnswer != null && selectedAnswer.equals(answers[currentQuestion])) {
            userScore++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            checkAnswer();
            currentQuestion++;
            if (currentQuestion == questions.length - 1) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            loadQuestion();
        }

        if (e.getSource() == submit) {
            checkAnswer(); // for the last question
            JOptionPane.showMessageDialog(this, name + ", your score is: " + userScore + "/" + questions.length);

        }
    }
}
