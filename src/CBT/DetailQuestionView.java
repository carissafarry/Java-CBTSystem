package CBT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailQuestionView extends JFrame {
    private JTextField questionTextField;
    private JTextField optionATextField;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton backButton;
    private JLabel questionLabel;
    private JLabel optionsLabel;
    private JPanel detailQuestionPanel;
    private JTextField optionBTextField;
    private JTextField optionCTextField;
    private JTextField optionDTextField;
    private JLabel optionALabel;
    private JLabel optionBLabel;
    private JLabel optionCLabel;
    private JLabel optionDLabel;
    private JLabel detailQuestionLabel;
    private JRadioButton optionARadioButton;
    private JRadioButton optionBRadioButton;
    private JRadioButton optionCRadioButton;
    private JRadioButton optionDRadioButton;
    private JLabel answerRBLabel;

    private CBTCommunicator communicator;
    private CBTController controller;
    int indexQuestion;

    private void groupButton( ) {

        ButtonGroup bg = new ButtonGroup( );

        bg.add(optionARadioButton);
        bg.add(optionBRadioButton);
        bg.add(optionCRadioButton);
        bg.add(optionDRadioButton);

    }
    
    public DetailQuestionView(String title, CBTCommunicator communicator, CBTController controller){
        super(title);
        groupButton();
        
        // Instansiasi
        this.communicator = communicator;
        this.controller = controller;

        // Default Setting JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(detailQuestionPanel);
        this.pack();

        // == Atur fungsi Button pada Constructor ==

        // Bila tombol Save diklik
        saveButton.addActionListener(new ActionListener() {
            String inputQuestion;
            String[] options = new String[4];
            int answerIndex;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Simpan nilai data input
                inputQuestion = questionTextField.getText();
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

                // Update data pertanyaan pada index tertentu melalui Controller,
                // beri notifikasi
                if(controller.updateQuestion(indexQuestion, inputQuestion, options[0], options[1], options[2], options[3],  answerIndex)){
                    JOptionPane.showMessageDialog(null, "Question Updated!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to Update Question!");
                }

                communicator.displayQuestionsView();
                communicator.closeDetailQuestionView();
            }
        });

        // Bila tombol Delete diklik
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hapus question pada index tertentu
                if(controller.deleteQuestion(indexQuestion)){
                    JOptionPane.showMessageDialog(null, "Question Deleted!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to Delete Question!");
                }

                // Setelah menghapus pertanyaan, kembali ke halaman utama / Questions View
                setVisible(false);
                communicator.displayQuestionsView();
                communicator.closeDetailQuestionView();
            }
        });

        // Bila tombol Back diketik
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communicator.displayQuestionsView();
                communicator.closeDetailQuestionView();
            }
        });
    }

    // Fungsi mengatur nilai variabel index, dipanggil pada class Communicator untuk
    // menampilkan DetailQuestionView
    void setIndexQuestion(int index){

        this.indexQuestion = index;
    }

    // Fungsi untuk menampilkan data pada GUI DetailQuestionView ini berdasarkan index
    void handlingDetailQuestion(){
        String question;
        String[] options;
        String answer;
        int answerIndex;

        // Ambil data dari Database
        question = controller.getQuestionsData().get(indexQuestion).getQuestion();
        options = controller.getQuestionsData().get(indexQuestion).getOptions();
        answerIndex = controller.getQuestionsData().get(indexQuestion).getAnswerIndex();

        // Tampilkan sebagai nilai dari input text field ketika GUI DetailQuestionView dibuka
        questionTextField.setText(question);
        optionATextField.setText(options[0]);
        optionBTextField.setText(options[1]);
        optionCTextField.setText(options[2]);
        optionDTextField.setText(options[3]);

        // Tampilkan nilai dari indeks jawaban ke selected radio button
        switch (answerIndex){
            case 0:
                optionARadioButton.setSelected(true);
                break;
            case 1:
                optionBRadioButton.setSelected(true);
                break;
            case 2:
                optionCRadioButton.setSelected(true);
                break;
            case 3:
                optionDRadioButton.setSelected(true);
                break;
        }

    }
}
