package Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private JTextField nameTextField;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField phoneTextField;
    private JTextField addressTextField;
    private JButton registerButton;
    private JPanel registerPanel;
    private JLabel nameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel phoneLabel;
    private JLabel addressLabel;

    public RegisterView(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(registerPanel);
        this.pack();

        registerButton.addActionListener(new ActionListener() {
            User registerUser;
            RegisterController tryRegister;

            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                String username;
                String password;
                String phone;
                String address;

                name = nameTextField.getText().trim();
                username = usernameTextField.getText().trim();
                password = passwordTextField.getText().trim();
                phone = phoneTextField.getText().trim();
                address = addressTextField.getText().trim();

                // Buat instans User yang baru ketika register
                this.registerUser = new User(username, password);

                // Tambahkan data input pada class User secara langsung
                registerUser.setName(name);
                registerUser.setPhone(phone);
                registerUser.setAddress(address);

                // Buat instans Register Controller yang baru dari User baru
                this.tryRegister = new RegisterController();

                // Masukkan data ke array list dengan DataBase
                tryRegister.RegisterProcess(registerUser);

                // Setelah berhasil memasukkan data baru ke DataBase, matikan Register View
                setVisible(false);

                // Buat halaman Login yang baru, dan nyalakan
                LoginView registered = new LoginView("Login Page");
                registered.setVisible(true);


            }
        });
    }


}























