package CBT;

public class QuestionsData {
    private String question;
    private String[] options = new String[4];
    private int answerIndex;
    private int userAnswer;

    public QuestionsData(String question, String a, String b, String c, String d, int answerIndex){
        this.question = question;
        this.options[0] = a;
        this.options[1] = b;
        this.options[2] = c;
        this.options[3] = d;
        this.answerIndex = answerIndex;
    }

    public void setQuestion(String question){

        this.question = question;
    }

    public String getQuestion(){

        return question;
    }

    public void setOptions(String[] options){

        this.options = options;
    }

    public String[] getOptions() {

        return options;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int getUserAnswer() {
        return userAnswer;
    }
}
