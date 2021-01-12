package Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private JPanel loginPanel;
    private JTextField usernameTextField;
    private JLabel usernameLabel;
    private JTextField passwordTextField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel passwordLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public LoginView(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane((loginPanel));
        this.pack();

        loginButton.addActionListener(new ActionListener() {
            User loginUser;
            LoginController tryLogin;
            @Override
            public void actionPerformed(ActionEvent e) {
                String username;
                String password;

                username = usernameTextField.getText().trim();  // hilangkan spasi
                password = passwordTextField.getText().trim();

                // Cari apakah data yang diinput user telah ada pada database
                // melalui class LoginController
                // Isi tryUser disini adalah nilai yang telah diinputkan user
                this.loginUser = tryLogin.loginProcess(this.loginUser);

                // Jika data user ada di database dan berhasil login
                if(loginUser != null){

                    // Akhiri view Login
                    setVisible(false);

                }
            }
        });
    }

    // Fungsi untuk mencari user dengan index tertentu
    // Index diambil dari array list pada DataBase melalui Login Controller
    public User getData(int index){
        LoginController getUserIndex = new LoginController();

        // Dapatkan index dengan fungsi get()
        return getUserIndex.dataBase.getUserData().get(index);
    }

    public static void main(String[] args) {
        // Buat halaman login yang baru ketika program dijalankan
        JFrame frame = new LoginView("Login Page");
        frame.setVisible(true);
    }
}



















