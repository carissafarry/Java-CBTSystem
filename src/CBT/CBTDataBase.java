package CBT;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;

public class CBTDataBase {

    // ArrayList<UserData> userDataBase = new ArrayList<>();
    ArrayList<QuestionsData> questionDataBase = new ArrayList<>();

    private Integer[] sortedIndex;

    CBTDataBase(){
        questionDatabasePush("1 + 1", "2", "1", "0", "-1", 0);
        questionDatabasePush("2 x 2", "2", "4", "0", "1", 1);
        questionDatabasePush("4!", "4", "12", "24", "16", 2);
        questionDatabasePush("100 - 9", "81", "109", "99", "91", 3);
        questionDatabasePush("8 ^ 2", "64", "32", "16", "4", 0);
    }

    // ==== QUESTIONS DATABASE ====
    public boolean questionDatabasePush(String question, String a, String b, String c, String d, int answerIndex){
        // Buat data pertanyaan baru, masukkan ke array list questionDatabase / QuestionsData
        try{
            questionDataBase.add(new QuestionsData(question, a, b, c, d, answerIndex));

            // Membuat array list yang akan ditampilkan pada CBT, dan dapat dimodifikasi
            return true;
        } catch (Exception e){
            //
        }
        return false;
    }

    public boolean questionDatabaseUpdate(int index, String question, String a, String b, String c, String d, int answerIndex){
        // Setelah ambil nilai dari data yang ada, tambahkan nilai baru ke questionDatabase
        try{
            questionDataBase.set(index, new QuestionsData(question, a, b, c, d, answerIndex));
            return true;
        } catch (Exception e){
            //
        }
        return false;
    }

    public boolean questionDatabaseDelete(int index){
        // Hapus data pada index tertentu
        try{
            questionDataBase.remove(index);
            return true;
        } catch (Exception e){
            //
        }
        return false;
    }

    // Fungsi ambil semua data yang ada di questionDatabase
    public ArrayList<QuestionsData> getQuestions(){

        return questionDataBase;
    }

    public Integer[] generateIndex(){ // Method yang digenerate hanya 1 kali
        List<Integer> sortRandomIndex = new ArrayList();
        for (int i = 0; i < questionDataBase.size() ; i++){
            sortRandomIndex.add(i);
        }

        sortedIndex = new Integer[sortRandomIndex.size()];
        Collections.shuffle(sortRandomIndex);

        sortedIndex = sortRandomIndex.toArray(sortedIndex);
        final Integer[] sorted = sortedIndex;
        return sorted;
    }
}
