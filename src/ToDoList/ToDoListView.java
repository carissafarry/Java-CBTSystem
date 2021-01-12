package ToDoList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListView extends JFrame {
    private JPanel toDoListPanel;
    private JList dataList;
    private JButton editListButton;
    private JButton newListButton;
    private JLabel toDoListLabel;
    private JScrollPane listScrollPane;

    Communicator communicator;
    Controller controller;

    // Membuat implementasi dari List Model agar dapat melakukan operasi manipulasi pada data yang ada pada obyek/input JList
    final DefaultListModel listData = new DefaultListModel();

    public ToDoListView(String title, Communicator communicator, Controller controller){
        super(title);

        this.communicator = communicator;
        this.controller = controller;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(toDoListPanel);
        this.pack();

        // Set fungsi Button pada Constructor

        // Ketika tombol New diklik
        newListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tampilkan halaman GUI CreateToDoList
                communicator.displayCreateToDoList();

                // Tutup halaman ini
                communicator.closeToDoListView();
            }
        });

        // Bila klik tombol Edit, buka halaman Detail Task
        editListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Pilih indeks dari data yang dipilih
                int indexList = dataList.getSelectedIndex();

                // Tampilkan halaman Detail melalui class Communicator
                communicator.displayDetailTaskView(indexList);

                // Tutup halaman ToDoListView
                communicator.closeToDoListView();

            }
        });
    }

    // Fungsi ini digunakan untuk menampilkan data pada ToDoListView
    // Dipanggil pada Class Communicator
    public void updateToDoList(){
        // ListData adalah keyword untuk Default List Model
        // Sebelum mengupdate list, reset jumlah list
        listData.clear();

        // Reset data pada Java List
        dataList.removeAll();

        // Membuat variabel array sebagai penomoran data list
        int listIndex = 0;

        // Mengambil List dari DataBase melalui Controller
        for(DataToDoList toDoList : controller.getDataToDoList()){
            listIndex++;

            // Menampilkan teks ke View dengan menambah elemen String pada
            // posisi akhir tiap list (fungsi addElement() / appending)
            listData.addElement("No : " + listIndex + " Title : " + toDoList.getName() + " | Description : " + toDoList.getDescription());
        }

        // Membuat model dalam list, yaitu model yang dibuat dari DefaultListModel
        // yang telah memiliki operasi manpulasi pada data yang ada pada list
        dataList.setModel(listData);
    }
}
















