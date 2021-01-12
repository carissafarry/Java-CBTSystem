package CBT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinishView extends JFrame {
    private JTextArea finishTextArea;
    private JPanel finishPanel;
    private JButton logoutButton;

    private CBTCommunicator communicator;
    private CBTController controller;

    public FinishView(String title, CBTCommunicator communicator, CBTController controller){
        super(title);

        this.communicator = communicator;
        this.controller = controller;

        // Default Setting JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(finishPanel);
        this.pack();

        String finish = "Thank you!";
        finishTextArea.setText(finish);
        finishTextArea.setEditable(false);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communicator.displayLoginView();
                communicator.closeFinishView();
            }
        });
    }
}
