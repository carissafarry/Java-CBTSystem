package ToDoList;

public class Execute {
    public static void main(String[] args) {

        // Class Communicator menghubungkan antar class View
        // Sedangkan Controller berperan dalam manipulasi, yaitu menghubungkan database dengan class Communicator atau Class view
        // sehingga Class Communicator / Class View tidak berhubungan langsung dengan database
        // ====

        // Membuat Communicator yang baru
        Communicator communicator = new Communicator();

        // Menampilkan halaman pertama ketika User membuka program
        communicator.displayToDoListView();
    }
}
