package ToDoList;

public class DataToDoList {
    private String name;
    private String description;

    public DataToDoList(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
