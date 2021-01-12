package ToDoList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailTaskView extends JFrame {
    private JPanel detailTaskPanel;
    private JTextField nameTextField;
    private JTextField descriptionTextField;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton backButton;
    private JLabel nameLabel;
    private JLabel descriptionLabel;

    private Communicator communicator;
    private Controller controller;
    int indexToDoList;

    public DetailTaskView(String title, Communicator communicator, Controller controller){
        super(title);

        // Instansiasi
        this.communicator = communicator;
        this.controller = controller;

        // Atur default Setting GUI Form
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(detailTaskPanel);
        this.pack();

        // === ATUR FUNGSI BUTTON PADA CONSTRUCTOR ===
        // Bila user mengedit dan tombol Save diketik, update data melalui Class Controller
        saveButton.addActionListener(new ActionListener() {
            String inputName;
            String inputDescription;
            @Override
            public void actionPerformed(ActionEvent e) {
                inputName = nameTextField.getText();
                inputDescription = descriptionTextField.getText();

                // Update data dengan Controller dan beri notifikasi
                if (controller.updateToDoList(indexToDoList, inputName, inputDescription)){
                    JOptionPane.showMessageDialog(null, "List Updated!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed updating list!");
                }
            }
        });

        // Bila klik tombol Delete, delete list pada index tertentu
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(controller.deleteToDoList(indexToDoList)){
                    JOptionPane.showMessageDialog(null, "List Deleted!");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete the list!");
                }

                // Setelah data dihapus, kembali ke halaman ToDoListView dan tutup halaman ini
                setVisible(false);
                communicator.displayToDoListView();
                communicator.closeDetailTaskView();
            }
        });

        // Bila tombol Back diketik, pindahkan ke halaman utama ToDoListView, dan tutup halaman ini
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                communicator.displayToDoListView();
                communicator.closeDetailTaskView();
            }
        });

    }

    // Mengatur index dari array data yang akan ditampilkan
    void setIndexToDoList(int index){
        this.indexToDoList = index;
    }

    // Mengambil data dari DataBase dengan index tertentu melalui class Controller
    // Kemudian ditampilkan sebagai nilai dari kolom input ketika user membuka halaman
    // ======
    // Fungsi ini dipanggil dari class Communicator untuk menampilkan data pada DetailTaskView
    // sesuai dengan index yang telah di-set
    void handlingDetailTaskData(){
        String name;
        String description;

        // Mengambil data dari DataBase
        name = controller.getDataToDoList().get(indexToDoList).getName();
        description = controller.getDataToDoList().get(indexToDoList).getDescription();

        // Tampilkan ke dalam kolom input DetailTaskView ketika user membuka halaman ini
        nameTextField.setText(name);
        descriptionTextField.setText(description);
    }
}
