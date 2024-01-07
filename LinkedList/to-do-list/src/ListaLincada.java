public class ListaLincada {
    private Node head;
    private Node tail;
    private int length;

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.print("null");
    }

    public void appendTask(String taskName, String taskDesc, String dueTO) {
        Node newTask = new Node(taskName, taskDesc, dueTO);
        if (length == 0) {
            head = newTask;
            tail = newTask;
        } else {
            tail.next = newTask;
            tail = newTask;
        }
        length++;
    }
}
