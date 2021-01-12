package ToDoList;

import java.util.ArrayList;

public class Controller {
    private Database database;

    public Controller(){
        // Membuat class database yang baru
        this.database = new Database();
    }

    public boolean addToDoList(String name, String description){
        // Menambahkan data ke database melalui method databasePush pada class Database
        return database.databasePush(name, description);
    }

    public boolean updateToDoList(int index, String name, String description){
        return database.databaseUpdate(index,name,description);
    }

    public boolean deleteToDoList(int index){

        return database.databaseDelete(index);
    }

    public ArrayList<DataToDoList> getDataToDoList(){

        return database.getData();
    }
}
