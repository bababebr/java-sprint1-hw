public class Converter {

    private final double stepLength = 0.75d;
    private final double calPerOneStep = 50.0;

    public  double stepToMeters(int stepCount) {
        return  stepCount * stepLength / 1000;
    }
    public  double stepToCal(int stepCount) {
        return  stepCount * calPerOneStep / 1000;
    }
}
