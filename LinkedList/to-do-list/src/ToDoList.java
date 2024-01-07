import java.util.Scanner;

public class ToDoList {
    private ListaLincada tasks = new ListaLincada();

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.mainMenu();
    }

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        do {
            showMenu();
            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine();
                chosed(escolha);
            }

        } while (escolha != 99);


        scanner.close();
    }

    private void showMenu() {
        System.out.println("-------------");
        System.out.println("1 - Cadastrar tarefa");
        System.out.println("2 - Modificar tarefa");
        System.out.println("3 - Mostrar tarefas");
        System.out.println("4 - Remover tarefa");
        System.out.println("99 - Sair");
        System.out.println("-------------");

        System.out.print("Digite sua escolha: ");
    }

    private void chosed(int escolha) {
        switch (escolha) {
            case 1:
                registerTask();
                break;
            case 2:
                System.out.println("ola");
                break;
            case 3:
                tasks.printList();
                break;
        }
    }

    private void registerTask() {
        Scanner sc = new Scanner(System.in);

        String taskName = "";
        String taskDesc = "";
        String outTo = "";

        System.out.println("Nome da Tarefa: ");
        taskName = sc.nextLine();

        System.out.println("Descricao da tarefa");
        taskDesc = sc.nextLine();

        System.out.println("Deadline da tarefa");
        outTo = sc.nextLine();

        tasks.appendTask(taskName, taskDesc, outTo);
    }
}
