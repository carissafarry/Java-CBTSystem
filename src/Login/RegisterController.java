package Login;

import java.util.ArrayList;

public class RegisterController {
    DataBase dataBase;

    RegisterController(){
        this.dataBase = DataBase.getInstance();
    }

    public User RegisterProcess(User user){
        // Tambahkan data ke database
        // Dapatkan semua data dari database dulu, baru tambahkan data user
        // pada array list User dengan fungsi .add()

        dataBase.getUserData().add(user);
        return null;
    }
}
