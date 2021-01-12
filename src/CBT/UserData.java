package CBT;

public class UserData {
    private String username;
    private String password;
    private String name;
    private String subject;
    private String address;
    private String phone;
    private boolean lecturer;
    private boolean student;
    private float score;

    public UserData(String username, String password, boolean student, boolean lecturer){
        this.username = username;
        this.password = password;
        this.student = student;
        this.lecturer = lecturer;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setLecturer(boolean lecturer) {
        this.lecturer = lecturer;
    }

    public boolean getLecturer(){
        return lecturer;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public boolean getStudent(){

        return student;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Float getScore() {
        return score;
    }
}
