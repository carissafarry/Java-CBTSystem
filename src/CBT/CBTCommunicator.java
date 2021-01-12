package CBT;

import javax.swing.*;

public class CBTCommunicator {
    private CBTController controller;
    private QuestionsView questionsView;
    private DetailQuestionView detailQuestionView;
    private CreateQuestion createQuestion;
    private UserController userController;
    private LoginView loginView;
    private RegisterView registerView;
    private CBTTestingView cbtTestingView;
    private TestPrepareView testPrepareView;
    private FinishView finishView;
    private ScoreView scoreView;

    public CBTCommunicator(){
        // Deklarasi pemanggilan pertama ketika program dijalankan
        this.controller = new CBTController();
        this.questionsView = new QuestionsView("Questions", this, controller);
        this.detailQuestionView =  new DetailQuestionView("Question Detail", this, controller);
        this.createQuestion = new CreateQuestion("Create New Question", this, controller);
        this.userController = new UserController();
        this.loginView = new LoginView("Login", this, userController);
        this.registerView = new RegisterView("Register", this, userController);
        this.testPrepareView = new TestPrepareView("Prepare for Your Test", this, controller);
        this.finishView = new FinishView("FINISHED!", this, controller);
        this.scoreView = new ScoreView("SCORE", this, userController);
        this.cbtTestingView = new CBTTestingView("CBT TESTING", this, controller, userController);
    }

    // Open Display View

    // GUI pertama yang dijalankan
    public void displayQuestionsView(){

        // Ambil data dari database
        questionsView.updateQuestions();
        questionsView.setVisible(true);

    }

    public void displayDetailQuestionView(int index){
        // Menampilkan detail dari question dengan index tertentu
        // detailQuestionView.

        // Set index dari data yang akan ditampilkan
        detailQuestionView.setIndexQuestion(index);

        // Ambil data dengan index yang telah diset dari database
        detailQuestionView.handlingDetailQuestion();
        detailQuestionView.setVisible(true);
    }

    // == Dijalankan pada class QuestionsView ==
    public void displayCreateQuestionView(){

        createQuestion.setVisible(true);
    }

    public void displayLoginView(){

        loginView.clearSelected();
        loginView.setVisible(true);
    }

    public void displayRegisterView(){

        registerView.setVisible(true);
    }

    public void displayCBTTestingView(){
        cbtTestingView.randomingIndex();
        cbtTestingView.setContent();
        cbtTestingView.handlingQuestionContent();
        cbtTestingView.setUneditable();
        cbtTestingView.setVisible(true);
    }

    public void displayTestPrepareView(){

        testPrepareView.setVisible(true);
    }

    public void displayFinishView(){
        finishView.setVisible(true);
    }

    public void displayScoreView(){
        scoreView.getUserScore();
        scoreView.setVisible(true);
    }




    // Close / Exit Display View
    public void closeQuestionsView(){

        questionsView.setVisible(false);
    }

    public void closeCreateQuestionView(){

        createQuestion.setVisible(false);
    }

    public void closeDetailQuestionView(){

        detailQuestionView.setVisible(false);
    }

    public void closeLoginView(){

        loginView.setVisible(false);
    }

    public void closeRegisterView(){

        registerView.setVisible(false);
    }

    public void closeTestPrepareView(){

        testPrepareView.setVisible(false);
    }

    public void closeFinishView(){

        finishView.setVisible(false);
    }

    public void closeScoreView(){
        scoreView.setVisible(false);
    }

    public void closeCBTTestingView(){
        cbtTestingView.setVisible(false);
    }
}
