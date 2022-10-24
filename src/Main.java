import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Пришло время практики!");
        StepTracker tracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите номер месяц (1 - Январь, 12 - Декабрь)");
            int month = scanner.nextInt();
            System.out.println("Введите порядковый номер дня (1-30)");
            int day = scanner.nextInt();


            printMenu();
            int command = scanner.nextInt();
            if(command == 1) {
                System.out.println("Введите кол-во шагов");
                int stepCount = scanner.nextInt();
               tracker.addDay(month, day, stepCount);
            }
            if(command == 2) {
                tracker.printMonthStat(month);
            }
            if (command == 3){
                System.out.println("Введите кол-во шагов");
                int goal = scanner.nextInt();
                tracker.setGoal(goal);
            }
            if (command == 4){
                break;
            }
        }
    }

    public static void printMenu(){
        System.out.println("Введите необходимый пункт из меню: ");
        System.out.println("1. Показать кол-во шагов за данный день.");
        System.out.println("2. Печать статистики");
        System.out.println("3. Изменить цель.");
        System.out.println("4. Выход");
    }

}
