public class Converter {

    private final double STEP_LENGTH = 0.75d;
    private final double CAL_PER_ONE_STEP = 1000d;

    public Converter() {
    }

    public  double stepToMeters(int stepCount) {
        return  stepCount * STEP_LENGTH / 1000;
    }
    public  double stepToCal(int stepCount) {
        return  stepCount * CAL_PER_ONE_STEP;
    }
}
