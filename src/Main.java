import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StepTracker tracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            printMenu();
            int command = scanner.nextInt();
            if(!List.of(0, 1, 2, 3, 4).contains(command)) {
                System.out.println("Команда не существует, введите еще раз!");
                continue;
            }
            System.out.println("Введите номер месяц (1 - Январь, 12 - Декабрь)");
            int month = scanner.nextInt()-1;
            System.out.println("Введите порядковый номер дня (1-30)");
            int day = scanner.nextInt()-1;

            if(month >= 0 && month < 12){
                if(day >= 0 && day < 12) {} else { continue; }
                }
            else {
                System.out.println("Пожалуйста, проверьте введенный порядковый номер месяца и дня");
                continue;
            }


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
            if (command == 0){
                break;
            }
        }
    }

    public static void printMenu(){
        System.out.println("Введите необходимый пункт из меню: ");
        System.out.println("1. Записать кол-во шагов за данный день.");
        System.out.println("2. Печать статистики");
        System.out.println("3. Изменить цель.");
        System.out.println("0. Выход");
    }

}
