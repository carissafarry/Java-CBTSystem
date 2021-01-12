package CBT;

import java.util.ArrayList;

public class CBTController {
    private CBTDataBase dataBase;

    public CBTController(){
        // Buat objek database baru
        this.dataBase = new CBTDataBase();
    }

    public boolean addQuestion(String questions, String a, String b, String c, String d, int answerIndex){
        // Jalankan fungsi push pada class CBTDatabase / Tambahkan pertanyaan ke database
        return dataBase.questionDatabasePush(questions, a, b, c, d, answerIndex);
    }

    public boolean updateQuestion(int index, String questions, String a, String b, String c, String d, int answerIndex){
        // Jalankan fungsi update pada class CBTDatabase
        return dataBase.questionDatabaseUpdate(index, questions, a, b, c, d, answerIndex);
    }

    public boolean deleteQuestion(int index){
        // Jalankan fungsi delete pada class CBTDatabase
        return dataBase.questionDatabaseDelete(index);
    }

    // Fungsi untuk mendapatkan data dari database
    public ArrayList<QuestionsData> getQuestionsData(){
        // Jalankan fungsi get data dari database pada class CBTDatabase
        return dataBase.getQuestions();
    }

    public Integer[] getRandomIndex(){
        return dataBase.generateIndex();
    }

}
