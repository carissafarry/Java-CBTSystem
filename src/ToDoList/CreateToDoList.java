package ToDoList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateToDoList extends JFrame {
    private JPanel createToDoListPanel;
    private JTextField nameTextField;
    private JTextField descriptionTextField;
    private JButton createButton;
    private JButton backButton;
    private JLabel nameLabel;
    private JLabel descriptionLabel;

    Communicator communicator;
    Controller controller;

    public CreateToDoList(String title, Communicator communicator, Controller controller){
        super();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(createToDoListPanel);
        this.setPreferredSize(new Dimension(250,200));
        this.pack();

        createButton.addActionListener(new ActionListener() {
            String name;
            String description;
            @Override
            public void actionPerformed(ActionEvent e) {
                name = nameTextField.getText();
                description = nameTextField.getText();

                if(controller.addToDoList(name, description)){
                    JOptionPane.showMessageDialog(null,"List Created!");
                } else {
                    JOptionPane.showMessageDialog(null,"Failed to create list!");
                }

                communicator.displayToDoListView();
                communicator.closeCreateToDoList();
            }
        });
    }

}
