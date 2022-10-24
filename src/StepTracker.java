import java.util.HashMap;
import java.util.Map;

public class StepTracker {
    private int goal = 10_000;

    public void setGoal(int goal) {
        this.goal = goal;
    }


    private Converter converter;
    private Map<Integer, int[]> db = new HashMap<>();
    StepTracker(){
        converter = new Converter();
        initDB();
    }

    private void initDB(){
        for(int m = 0; m <= 12; m++) {
            db.put(m, new int[30]);
        }
    }
    public void addDay(int month, int day, int stepCount){
        db.get(month)[day] = stepCount > 0 ? stepCount : 0;
    }
    public void printMonthStat(int month){
        StringBuilder sb = new StringBuilder();
        int day = 1;
        for(int d : db.get(month)){
            sb.append(day + " день: " + d + ", ");
            day++;
        }
        System.out.println(sb.replace(sb.length()-2, sb.length(), "."));

        System.out.println("Общее количество шагов за месяц: " + monthStepCount(month));
        System.out.println("Максимальное пройденное количество шагов в месяце: "+ dayWithMaxStepCount(month));
        System.out.println("Среднее количество шагов: " + monthMean(month));
        System.out.println("Пройденная дистанция (в км) " + monthTotalDist(month));
        System.out.println("Количество сожжённых килокалорий " + monthBurnedCal(month));
        System.out.println("Лучшая серия: " + maxDaysInARow(month));
    }

    public int monthStepCount(int month){
        int steps = 0;
        for(int d : db.get(month)){
            steps += d;
        }
        return steps;
    }

    public int dayWithMaxStepCount(int month){
        int max = 0;
        for(int d : db.get(month)){
            max = d > max ? d : max;
        }
        return max;
    }

    public double monthMean(int month) {
        int stepSum = 0;

        for(int d : db.get(month)) {
            stepSum += d;
        }
        return stepSum / db.get(month).length;
    }

    public double monthTotalDist(int month){
        return  converter.stepToMeters(monthStepCount(month));
    }
    public double monthBurnedCal(int month){
        return converter.stepToCal(monthStepCount(month));
    }

    public int maxDaysInARow(int month) {
        int maxRow = 0;
        int result = 0;

        for (int d : db.get(month)) {
            maxRow = d > goal ? maxRow + 1 : (result = maxRow > result ? maxRow : result);
            maxRow = d > goal ? maxRow : 0;

        }
        return result;
    }
}
