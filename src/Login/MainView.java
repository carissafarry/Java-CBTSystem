package Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    private JPanel MainView;
    private JTextField nameTextField;
    private JTextField phoneTextField;
    private JButton logoutButton;
    private JLabel nameLabel;
    private JLabel phoneLabel;
    private JTextField addressTextField;
    private JLabel addressLabel;

    User output;

    /// TODO: belum tau buat apa
    LoginView getUser = new LoginView("Carissa");

    public MainView(String title, User user){
        super(title);

        output = user;
        nameTextField.setText(output.getName());
        phoneTextField.setText(output.getPhone());
        addressTextField.setText(output.getAddress());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(MainView);
        this.pack();

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Anda telah Logout");

                // Buat halaman Login yang baru
                LoginView newLogin = new LoginView("New Login");

                // Matikan halaman Main View
                setVisible(false);

                // Hidupkan halaman Login yang baru
                newLogin.setVisible(true);
            }
        });
    }
}












