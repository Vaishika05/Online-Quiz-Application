package onlineQuiz;

import javax.swing.JFrame;

public class main {
    public static void main(String[] args) {
        JFrame obJFrame = new JFrame();

        obJFrame.setBounds(10, 10, 700, 700);
        obJFrame.setTitle("LoginPage");
        obJFrame.setVisible(true);
        obJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obJFrame.setResizable(false);

        login log = new login();

        obJFrame.add(log);
    }
}
