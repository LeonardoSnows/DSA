import java.util.Date;

public class Node {
    private String taskName;
    private String taskDescription;
    private String dueTo;
    public Node next;

    public Node(String taskName, String taskDescription, String dueTo) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.dueTo = dueTo;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDueTo() {
        return dueTo;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "{" +
                "Nome da task='" + taskName + '\'' +
                ", Descricao da task='" + taskDescription + '\'' +
                ", DeadLine='" + dueTo + '\'' +
                '}';
    }
}
