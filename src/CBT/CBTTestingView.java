package CBT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CBTTestingView extends JFrame {
    private JTextPane CBTTextPane;
    private JRadioButton optionA;
    private JRadioButton optionB;
    private JRadioButton optionC;
    private JRadioButton optionD;
    private JPanel CBTTestingViewPanel;
    private JButton doneButton;
    private JButton nextButton;
    private JButton previousButton;

    private CBTCommunicator communicator;
    private CBTController controller;
    private UserController userController;
    ButtonGroup bg;

    private Integer[] randomIndex = new Integer[]{};
    int iteratorIndex = 0;
    private int num = 0;
    private String question;
    private String[] options;
    private int correctAnswerIndex = -1;
    private int questionTotal;
    private Integer[] correctAnswerArray = new Integer[questionTotal];
    private Integer[] indexRandPublic = new Integer[4];
    private Integer[] userAnswers;
    private float score;

    private void groupButton(){
        bg = new ButtonGroup();

        bg.add(optionA);
        bg.add(optionB);
        bg.add(optionC);
        bg.add(optionD);
    }

    public CBTTestingView(String title, CBTCommunicator communicator, CBTController controller, UserController userController){
        super(title);
        groupButton();

        // Instance
        this.communicator = communicator;
        this.controller = controller;
        this.userController = userController;

        // Default setting
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(CBTTestingViewPanel);
        this.pack();

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simpan jawaban user
                saveAnswer();

                // Ganti index pertanyaan selanjutnya
                iteratorIndex++;
                int currentAnswer = -1;

                // Bila telah mencapai pertanyaan yang terakhir
                if (iteratorIndex == (randomIndex.length)){
                    userController.setScore(countScore());
                    communicator.displayScoreView();
                    communicator.closeCBTTestingView();
                } else {
                    bg.clearSelection();
                    setContent();
                    handlingQuestionContent();

                    // Bila ada data jawaban yang telah disimpan, set ke radio button
                    if (userAnswers[iteratorIndex] != null){
                        currentAnswer = userAnswers[iteratorIndex];

                        if (currentAnswer == indexRandPublic[0]){
                            optionA.setSelected(true);
                        } else if (currentAnswer == indexRandPublic[1]){
                            optionB.setSelected(true);
                        } else if (currentAnswer == indexRandPublic[2]){
                            optionC.setSelected(true);
                        } else if (currentAnswer == indexRandPublic[3]){
                            optionD.setSelected(true);
                        }
                    }

                    setUneditable();
                }
            }
        });

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iteratorIndex--;
                // Ambil jawaban user pada soal sebelumnya
                if (iteratorIndex >= 0){
                    int previousAnswer = userAnswers[iteratorIndex];
                    setContent();
                    handlingQuestionContent();

                    // Bila ada data jawaban yang telah disimpan, set ke radio button
                    if (previousAnswer == indexRandPublic[0]){
                        optionA.setSelected(true);
                    } else if (previousAnswer == indexRandPublic[1]){
                        optionB.setSelected(true);
                    } else if (previousAnswer == indexRandPublic[2]){
                        optionC.setSelected(true);
                    } else if (previousAnswer == indexRandPublic[3]){
                        optionD.setSelected(true);
                    }

                    setUneditable();

                } else {
                    JOptionPane.showMessageDialog(null,"Ini adalah pertanyaan paling awal!");
                }
            }
        });

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Simpan pertanyaan dulu
                saveAnswer();
                userController.setScore(countScore());
                communicator.displayScoreView();
                communicator.closeCBTTestingView();
            }
        });

    }

    // Method yang hanya dipanggil satu kali melalui communicator untuk men-generate random index dari database
    void randomingIndex(){
        List<Integer> correctAnswersData = new ArrayList<>();
        int index = -1;

        // Ambil array index yang telah dirandom dari database
        randomIndex = controller.getRandomIndex();

        // Banyak question = banyak index dari database
        questionTotal = randomIndex.length;
        userAnswers = new Integer[questionTotal];

        if (randomIndex == null){
            JOptionPane.showMessageDialog(null,"array random index ga ada isinya");
        }

        // Menyimpan jawaban yang benar dari database ke variabel List
        for (int i = 0; i < questionTotal; i++){
            index = randomIndex[i];
            correctAnswersData.add(controller.getQuestionsData().get(index).getAnswerIndex());
        }

        // Ubah List jawaban yang benar dari database ke variabel array
        correctAnswerArray = correctAnswersData.toArray(correctAnswerArray);
    }

    void setContent(){
        // Set nilai ke variabel setelah mengambil nilai random index
        if (randomIndex != null){
            question = controller.getQuestionsData().get(randomIndex[iteratorIndex]).getQuestion();
            options = controller.getQuestionsData().get(randomIndex[iteratorIndex]).getOptions();
            correctAnswerIndex = controller.getQuestionsData().get(randomIndex[iteratorIndex]).getAnswerIndex();

        } else {
            JOptionPane.showMessageDialog(null,"array random index ga ada isinya");
        }
    }

    void handlingQuestionContent(){
        String displayedText;
        try{
            // Membuat variabel perandom index opsi jawaban
            Integer[] indexRand = new Integer[]{0, 1, 2, 3};

            // Mengacak urutan index opsi jawaban
            List randomOption = Arrays.asList(indexRand);
            Collections.shuffle(randomOption);
            randomOption.toArray(indexRand);

            indexRandPublic = indexRand;
            num = iteratorIndex + 1;

            displayedText = num + ".  " + question + "\n\n" +
                    "A. " + options[indexRand[0]] + "\n" +
//                    "   |  Index opsi : " + indexRand[0] + "\n" +
                    "B. " + options[indexRand[1]] + "\n" +
//                    "   |  Index opsi : " + indexRand[1] + "\n" +
                    "C. " + options[indexRand[2]] + "\n" +
//                    "   |  Index opsi : " + indexRand[2] + "\n" +
                    "D. " + options[indexRand[3]]
//                    + "   |  Index opsi : " + indexRand[3] + "\n\n"
//                    + "Index opsi yang benar :  " + correctAnswerIndex + "\n"
            ;

            CBTTextPane.setText(displayedText);
        } catch (Exception e){
            //
        }
    }

    void saveAnswer(){
        int userIndexOption;

        // Mengambil jawaban user
        if (optionA.isSelected()){
            userIndexOption = indexRandPublic[0];
        } else if (optionB.isSelected()){
            userIndexOption = indexRandPublic[1];
        } else if (optionC.isSelected()){
            userIndexOption = indexRandPublic[2];
        } else if (optionD.isSelected()){
            userIndexOption = indexRandPublic[3];
        } else {
            userIndexOption = -1;
        }

        if (correctAnswerIndex > -1) {
            // Simpan kumpulan jawaban user ke array userAnswers
            userAnswers[iteratorIndex] = userIndexOption;
        }
    }

    void setUneditable(){
        CBTTextPane.setEditable(false);
    }

    float countScore(){

        int userCorrectAnswer = 0;

        // Hitung jawaban benar dengan pengecekan array jawaban user dan array jawaban dari database
        for (int j = 0; j < questionTotal; j++){
            if (userAnswers[j] == correctAnswerArray[j]){
                userCorrectAnswer++;
            }
        }

        // Hitung Score
        score = (float) userCorrectAnswer / questionTotal * 100;
        return score;
    }

}
