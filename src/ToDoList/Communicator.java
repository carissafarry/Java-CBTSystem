package ToDoList;

public class Communicator {
    private Controller controller;
    private ToDoListView toDoListView;
    private DetailTaskView detailTaskView;
    private CreateToDoList createToDoList;

    public Communicator(){
        // Controller digunakan agar semua Class menggunakan deklarasi /
        // objek Controller yang sama, yaitu yang dideklarasikan pada Class Communicator

        this.controller = new Controller();
        this.toDoListView = new ToDoListView("Create To Do List", this, controller);
        this.detailTaskView = new DetailTaskView("Detail To Do List", this, controller);
        this.createToDoList = new CreateToDoList("Create To Do List", this, controller);
    }

    // Open Display
    public void displayToDoListView(){
        // Mengambil data dari database
        toDoListView.updateToDoList();
        toDoListView.setVisible(true);

    }

    public void displayDetailTaskView(int index){
        // Fungsi ini dipanggil dari class ToDoListView untuk menampilkan GUI DetailTaskView
        // untuk mengedit list sesuai dengan index tertentu

        // Mengatur nilai index pada class DetailTaskView
        detailTaskView.setIndexToDoList(index);

        // Menampilkan detail data dari database di kolom input sesuai dengan
        // index yang telah di-set
        detailTaskView.handlingDetailTaskData();
        detailTaskView.setVisible(true);
    }

    public void displayCreateToDoList(){

        createToDoList.setVisible(true);
    }

    // Close Display
    public void closeToDoListView() {

        toDoListView.setVisible(false);
    }

    public void closeDetailTaskView() {
        detailTaskView.setVisible(false);
    }

    public void closeCreateToDoList(){
        createToDoList.setVisible(false);
    }

}
