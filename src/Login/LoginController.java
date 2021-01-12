package Login;

import java.util.ArrayList;

public class LoginController {
    DataBase dataBase;

    LoginController(){
        // Melakukan instansiasi dari DataBase dengan cara SingleTon
        this.dataBase = DataBase.getInstance();
    }

    public User loginProcess(User user){
        // Ambil seluruh baris data dari DataBase, simpan ke array list userData
        ArrayList<User> userData = dataBase.getUserData();

        // Seperti foreach, lakukan pengecekan pada tiap baris tabel data array
        // list userData, dengan menyimpan nilai dari tiap baris pengecekan
        // pada variabel dbUser yang bertipe User
        for( User dbUser : userData){

            // Bila nilai username dari tiap pengecekan array list sama dengan
            // username milik User, maka:
            if (dbUser.getUsername().equals(user.getUsername()) && dbUser.getPassword().equals(user.getPassword())){

                // return data user yang sesuai dengan database
                return dbUser;
            }
        }
        return null;
    }


}
