package CBT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionsView extends JFrame {
    private JButton editQuestionButton;
    private JButton newQuestionButton;
    private JPanel questionsPanel;
    private JList questionsList;
    private JLabel questionsLabel;
    private JScrollPane questionsScrollPane;
    private JButton testingCBTViewButton;
    private JButton logoutButton;

    CBTCommunicator communicator;
    CBTController controller;

    // Membuat model list untuk melakukan manipulasi
    final DefaultListModel questionsDataModel = new DefaultListModel();

    public QuestionsView(String title, CBTCommunicator communicator, CBTController controller){
        super(title);

        this.communicator = communicator;
        this.controller = controller;

        // Atur default setting pada JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(questionsPanel);
        this.pack();

        // == Atur fungsi Button ==

        // Tombol New
        newQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tampilkan GUI CreateQuestion dengan Communicator
                communicator.displayCreateQuestionView();

                // Tutup halaman ini
                communicator.closeQuestionsView();
            }
        });

        // Tombol Edit
        editQuestionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // === Ambil nilai index dari data yang dipilih pada JList Input ===
                int questionIndex = questionsList.getSelectedIndex();

                // Tampilkan GUI DetailQuestionView dengan data melalui indexnya
                communicator.displayDetailQuestionView(questionIndex);

                // Tutup halaman ini
                communicator.closeQuestionsView();
            }
        });

        testingCBTViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communicator.displayCBTTestingView();
                communicator.closeQuestionsView();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communicator.displayLoginView();
                communicator.closeQuestionsView();
            }
        });
    }

    // Ambil data dari database, tampilkan oada GUI QuestionsView
    // Fungsi dipanggil dari Communicator
    public void updateQuestions(){
        // Reset data question pada List Model
        questionsDataModel.clear();

        // Reset data pada Java List Input
        questionsList.removeAll();

        // Variabel array penampung index
        int questionsIndex = 0;

        // Ambil data pertanyaan dari Database melalui Controller dengan obyek bertipe
        // Class QuestionsData langsung
        for(QuestionsData question : controller.getQuestionsData()){
            questionsIndex++;
            String correct = "null";

            // Ubah indeks opsi jawaban ke dalam bentuk String untuk ditampilkan
            switch (question.getAnswerIndex()){
                case 0:
                    correct = "A";
                    break;
                case 1:
                    correct = "B";
                    break;
                case 2:
                    correct = "C";
                    break;
                case 3:
                    correct = "D";
                    break;
            }

            // Tampilkan string ke View JList dengan component List Model
            questionsDataModel.addElement("No: " + questionsIndex + "  |  Question : " + question.getQuestion() + " | Corresponding : " + correct);
        }

        // Set Model pada GUI JList
        questionsList.setModel(questionsDataModel);
    }
}
