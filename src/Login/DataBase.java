package Login;

import java.util.ArrayList;

public class DataBase {
    // Instansiasi Singleton menggunakan keyword instance
    public static DataBase instance;

    // Membuat array list untuk menyimpan banyak data pada class DataBase
    // yang ditampung pada class User
    ArrayList<User> userData = new ArrayList<User>();

    // Main Singleton: method untuk menggantikan proses instansi pada DataBase
    public static DataBase getInstance(){
        if(instance == null){
            instance = new DataBase();
        }
        // Mereturn nilai instansi Singleton melalui keyword instance
        return instance;
    }

    // Membuat method get dengan nilai return berupa array list
    public ArrayList<User> getUserData(){

        return userData;
    }

    // Membuat method set array list
    public void setUserData(ArrayList<User> userData){

        this.userData = userData;
    }
}
