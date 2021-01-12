package ToDoList;

import java.util.ArrayList;

public class Database {

    // Membuat array list untuk menyimpan banyak data pada class DataBase
    // yang ditampung pada class DataToDoList
    ArrayList<DataToDoList> dataBase = new ArrayList<>();

    // Bila menambahkan data ke dataBase
    public boolean databasePush(String name, String description){
        // Memasukkan data pada class DataToDoList yang baru, kemudian
        // ditambahkan ke dataBase / array list DataToDoList
        try{
            dataBase.add(new DataToDoList(name, description));
            return true;
        } catch (Exception e){

        }
        return false;
    }

    public boolean databaseUpdate(int index, String name, String description){
        // 1. Buat data baru dari data yang lama menggunakan class DataToDoList,
        // 2. Tambahkan data tsb ke database / array list DataToDoList
        try{
            dataBase.set(index, new DataToDoList(name, description));
            return true;
        } catch (Exception e){

        }
        return false;
    }

    public boolean databaseDelete(int index){
        // Hapus data dengan index tertentu pada array list di class DataToDoList
        try {
            dataBase.remove(index);
            return true;
        } catch (Exception e){

        }
        return false;
    }

    // Fungsi untuk mengambil data pada array list database
    public ArrayList<DataToDoList> getData(){
        return dataBase;
    }
}












