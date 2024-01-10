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
            case 1 -> registerTask();

            case 2 -> modifyTask();

            case 3 -> tasks.printList();

            case 4 -> removeTask();
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

    private void removeTask() {
        Scanner sc = new Scanner(System.in);

        String taskName = "";
        tasks.printList();

        System.out.println("\nIndex da task:(Começando a partir de 0)");
        taskName = sc.nextLine();

        tasks.removeTask(Integer.parseInt(taskName));
    }

    public void modifyTask() {
        Scanner sc = new Scanner(System.in);

        String taskIndex = "";
        tasks.printList();

        System.out.println("\nIndex da task a ser modificado:(Começando a partir de 0)");
        taskIndex = sc.nextLine();

        validaQualModificacao(Integer.parseInt(taskIndex));
    }

    private void validaQualModificacao(int taskIndex) {
        Scanner sc = new Scanner(System.in);

        String choosed = "";
        String taskName = "";
        String taskDesc = "";
        String dueTo = "";

        System.out.println("\nDeseja modificar o nome da task (S ou N)? Nome atual da task: " + tasks.get(taskIndex).getTaskName());
        choosed = sc.nextLine();

        if (choosed.equalsIgnoreCase("S")) {
            System.out.println("Digite o novo nome da task: ");
            taskName = sc.nextLine();
            tasks.get(taskIndex).setTaskName(taskName);
        }

        System.out.println("Deseja modificar a descricao da task (S ou N)? descricao atual da task: " + tasks.get(taskIndex).getTaskDescription());
        choosed = sc.nextLine();

        if (choosed.equalsIgnoreCase("S")) {
            System.out.println("Digite a nova descricao da task: ");
            taskDesc = sc.nextLine();
            tasks.get(taskIndex).setTaskDescription(taskDesc);
        }

        System.out.println("Deseja modificar a deadline da task (S ou N)? deadline atual da task: " + tasks.get(taskIndex).getDueTo());
        choosed = sc.nextLine();

        if (choosed.equalsIgnoreCase("S")) {
            System.out.println("Digite a nova deadline da task: ");
            dueTo = sc.nextLine();
            tasks.get(taskIndex).setDueTo(dueTo);
        }
    }
}
