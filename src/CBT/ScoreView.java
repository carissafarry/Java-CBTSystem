package CBT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreView extends JFrame {
    private JTextArea scoreTextArea;
    private JPanel scoreViewPanel;
    private JLabel congratsLabel;
    private JButton logoutButton;

    private CBTCommunicator communicator;
    private UserController userController;

    public ScoreView(String title, CBTCommunicator communicator, UserController userController){
        super(title);

        //Instance
        this.communicator = communicator;
        this.userController = userController;

        // Default setting
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(scoreViewPanel);
        this.pack();

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communicator.closeScoreView();
                communicator.displayLoginView();
            }
        });
    }

    void getUserScore(){
        Float score;

        score = userController.getScore();

        scoreTextArea.setText("Your score is : " + score);
        scoreTextArea.setEditable(false);
    }

}
