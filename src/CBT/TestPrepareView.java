package CBT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TestPrepareView extends JFrame {
    private JPanel testPreparePanel;
    private JTextArea welcomingTextArea;
    private JButton startTestButton;
    private JButton logoutButton;

    private CBTCommunicator communicator;
    private CBTController controller;

    private ArrayList<QuestionsData> questions = new ArrayList<>();

    public TestPrepareView(String title, CBTCommunicator communicator, CBTController controller){
        super(title);

        this.communicator = communicator;
        this.controller = controller;

        // Default Setting JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(testPreparePanel);
        this.pack();

        String welcome = "Welcome! Let's get started your test!\nGood Luck!";
        welcomingTextArea.setText(welcome);
        welcomingTextArea.setEditable(false);

        questions = controller.getQuestionsData();

        startTestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (questions.size() >0 ){
                    communicator.displayCBTTestingView();
                    communicator.closeTestPrepareView();
                } else {
                    JOptionPane.showMessageDialog(null,"Mohon ditunggu! Belum ada pertanyaan yang tersedia.");
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communicator.displayLoginView();
                communicator.closeTestPrepareView();
            }
        });
    }
}
