package CBT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateQuestion extends JFrame {
    private JPanel createQuestionPanel;
    private JTextField questionTextField;
    private JTextField optionATextField;
    private JTextField answerTextField;
    private JButton createButton;
    private JButton backButton;
    private JLabel questionLabel;
    private JLabel optionsLabel;
    private JTextField optionBTextField;
    private JTextField optionCTextField;
    private JTextField optionDTextField;
    private JLabel optionALabel;
    private JLabel optionBLabel;
    private JLabel optionCLabel;
    private JLabel optionDLabel;
    private JLabel CreateQuestionLabel;
    private JRadioButton optionARadioButton;
    private JRadioButton optionBRadioButton;
    private JRadioButton optionCRadioButton;
    private JRadioButton optionDRadioButton;
    private JLabel answerRBLabel;

    private CBTCommunicator communicator;
    private CBTController controller;
    ButtonGroup bg;

    private void groupButton( ) {

        bg = new ButtonGroup();

        bg.add(optionARadioButton);
        bg.add(optionBRadioButton);
        bg.add(optionCRadioButton);
        bg.add(optionDRadioButton);
    }

    void clearTextField(){
        questionTextField.setText("");
        optionATextField.setText("");
        optionBTextField.setText("");
        optionCTextField.setText("");
        optionDTextField.setText("");
    }

    public CreateQuestion(String title, CBTCommunicator communicator, CBTController controller){
        super(title);
        groupButton();

        // Instance
        this.communicator = communicator;
        this.controller = controller;

        // Default setting View
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(createQuestionPanel);
        this.pack();

        createButton.addActionListener(new ActionListener() {
            String question;
            String[] options = new String [4];
            int answerIndex;
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ambil nilai input user
                question = questionTextField.getText();
                options[0] = optionATextField.getText();
                options[1] = optionBTextField.getText();
                options[2] = optionCTextField.getText();
                options[3] = optionDTextField.getText();

                if (optionARadioButton.isSelected()){
                    answerIndex = 0;
                } else if (optionBRadioButton.isSelected()){
                    answerIndex = 1;
                } else if (optionCRadioButton.isSelected()){
                    answerIndex = 2;
                } else if (optionDRadioButton.isSelected()){
                    answerIndex = 3;
                }

                // Tambahkan data input ke database melalui controller
                if(controller.addQuestion(question, options[0], options[1], options[2], options[3], answerIndex)){
                    JOptionPane.showMessageDialog(null, "Question added!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to Add Question!");
                }

                bg.clearSelection();
                clearTextField();

                // Setelah menambahkan ke database, pindah View ke QuestionsView
//                CBTCommunicator commQuestionView = new CBTCommunicator();
//                commQuestionView.displayQuestionsView();
                communicator.displayQuestionsView();
                communicator.closeCreateQuestionView();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communicator.displayQuestionsView();
                communicator.closeCreateQuestionView();
            }
        });
    }
}
