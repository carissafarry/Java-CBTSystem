package CBT;

import Login.User;

import java.util.ArrayList;

public class UserController {
    UserDataBase dataBase;

    UserController(){
        // Instansiasi Single Ton pada database
        this.dataBase = UserDataBase.getInstance();
    }

    // === SINGLE USER LOGIN ===
    public UserData userLoginProcess(UserData user){
        return dataBase.loginProcess(user);
    }

    public UserData RegisterProcess(UserData user){
        return dataBase.registerProcess(user);
    }

    public ArrayList<UserData> getUserDataBase(){

        return dataBase.getUserData();
    }

//    public void countScore()

    public void setScore(float score){

        dataBase.setUserScore(score);
    }

    public Float getScore(){

        return dataBase.getUserScore();
    }


}
