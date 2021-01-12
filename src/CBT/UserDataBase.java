package CBT;

import Login.User;

import java.util.ArrayList;

public class UserDataBase {
    public static UserDataBase instance;
    private UserData currentUser;

    ArrayList<UserData> userData = new ArrayList<>();

    // Singleton Instance
    public static UserDataBase getInstance(){
        if(instance == null){
            instance = new UserDataBase();
        }

        // Return nilai instance Singleton
        return instance;
    }

    // Method mendapatkan data dari database
    public ArrayList<UserData> getUserData(){

        return userData;
    }

    // Method untuk set Array list
    public void setUserData(ArrayList<UserData> userData){

        this.userData = userData;
    }

    public UserData loginProcess(UserData user){
        // Validasi login
        for(UserData dbUser : userData){
            if(dbUser.getUsername().equals(user.getUsername()) && dbUser.getPassword().equals(user.getPassword())){
                if ((dbUser.getStudent() == user.getStudent()) && (dbUser.getLecturer() == user.getLecturer())){
                    // Return data yang sesuai dengan database
                    currentUser = dbUser;
                    return dbUser;
                }
            }
        }
        return null;
    }

    public UserData registerProcess(UserData user){
        // Tambahkan data ke database
        userData.add(user);
        return null;
    }

    public void setUserScore(float score){
        currentUser.setScore(score);
    }

    public Float getUserScore(){

        return currentUser.getScore();
    }
}
