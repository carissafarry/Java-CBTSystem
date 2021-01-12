package CBT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {
    private JPanel loginPanel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton registerButton;
    private JButton loginButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JRadioButton studentRadioButton;
    private JRadioButton lecturerRadioButton;
    private JButton testButton;
    private JLabel userTypeLabel;
    private JLabel loginViewLabel;
    private JButton closeButton;

    private CBTCommunicator communicator;
    private UserController controller;

    private ButtonGroup bg;

    private void groupButton( ) {

        bg = new ButtonGroup( );

        bg.add(studentRadioButton);
        bg.add(lecturerRadioButton);

    }

    public LoginView(String title, CBTCommunicator communicator, UserController controller){
        super(title);
        groupButton();

        // Instansiasi
        this.communicator = communicator;
        this.controller = controller;

        // Default Setting View
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(loginPanel);
        this.pack();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username;
                String password;
                boolean student;
                boolean lecturer;

                username = usernameTextField.getText().trim();
                password = passwordTextField.getText().trim();
                student = studentRadioButton.isSelected();
                lecturer = lecturerRadioButton.isSelected();

                // Membuat objek data user yang baru dari nilai input user
                UserData loginUser = new UserData(username, password, student, lecturer);
//                UserController tryLogin = new UserController();

                // Cek apakah data user telah ada pada database
//                loginUser = tryLogin.userLoginProcess(loginUser);
                loginUser = controller.userLoginProcess(loginUser);

                // Jika data user ada di database, dan berhasil login
                if (loginUser!=null){
                    if (student == true && lecturer == false){
                        // Tutup halaman login dan pindah ke halaman QuestionsView
                        communicator.displayTestPrepareView();
                        communicator.closeLoginView();
                    } else if (student == false && lecturer == true){
                        communicator.displayQuestionsView();
                        communicator.closeLoginView();
                    }

                    // setVisible(false);
                    // QuestionsView logged = new QuestionsView("Questions Page");
                    // logged.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Username / Password salah!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                CBTCommunicator newRegisterPage = new CBTCommunicator();
//                newRegisterPage.displayRegisterView();
                communicator.displayRegisterView();
                communicator.closeLoginView();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communicator.closeLoginView();
            }
        });

    }

    void clearSelected(){
        usernameTextField.setText("");
        passwordTextField.setText("");
        bg.clearSelection();
    }
}
