package CBT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {
    private JTextField nameTextField;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField subjectTextField;
    private JTextField addressTextField;
    private JTextField phoneTextField;
    private JButton registerButton;
    private JPanel registerPanel;
    private JLabel nameLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel subjectLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JButton backButton;
    private JRadioButton studentRadioButton;
    private JRadioButton lecturerRadioButton;
    private JLabel userTypeLabel;
    private JLabel RegisterViewLabel;

    private CBTCommunicator communicator;
    private UserController controller;

    private void groupButton( ) {

        ButtonGroup bg = new ButtonGroup( );

        bg.add(studentRadioButton);
        bg.add(lecturerRadioButton);

    }

    public RegisterView(String title, CBTCommunicator communicator, UserController controller){
        super(title);
        groupButton();

        // Instansiasi
        this.communicator = communicator;
        this.controller = controller;

        // Default Setting JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(registerPanel);
        this.pack();

        registerButton.addActionListener(new ActionListener() {
            UserData registerUser;
            UserController tryRegister;

            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                String username;
                String password;
                String subject;
                String address;
                String phone;
                boolean student;
                boolean lecturer;

                name = nameTextField.getText().trim();
                username = usernameTextField.getText().trim();
                password = passwordTextField.getText().trim();
                subject = subjectTextField.getText().trim();
                address = addressTextField.getText().trim();
                phone = phoneTextField.getText().trim();
                student = studentRadioButton.isSelected();
                lecturer = lecturerRadioButton.isSelected();

                // Buat instans baru ketika register
                this.registerUser = new UserData(username, password, student, lecturer);

                // Tambahkan data input pada Class CBT User
                registerUser.setName(name);
                registerUser.setSubject(subject);
                registerUser.setAddress(address);
                registerUser.setPhone(phone);

                // Buat instans Register Controller yang baru dari User baru
                this.tryRegister = new UserController();

                // Masukkan data ke array list pada database
                tryRegister.RegisterProcess(registerUser);

                // Bila berhasil, matikan view Register, pindah ke Login View yang baru
                CBTCommunicator communicatorRegistered = new CBTCommunicator();
                communicatorRegistered.displayLoginView();
//                communicator.displayLoginView();
                communicator.closeRegisterView();

//                LoginView registered = new LoginView("Login Page");
                // setVisible(false);
                // registered.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communicator.displayLoginView();
                communicator.closeRegisterView();
            }
        });

    }

}
