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

    public Node removeTask(int index) {
        if (index < 0 || index >= this.length) return null;

        if (index == 0) return removeFirstTask();

        if (index == length - 1) return removeUltimo();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return prev;
    }

    public Node get(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    private Node removeUltimo() {
        if (length == 0) return null;

        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    private Node removeFirstTask() {
        if (length == 0)
            return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }
}
