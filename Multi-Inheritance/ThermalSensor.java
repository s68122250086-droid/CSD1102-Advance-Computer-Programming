public interface ThermalSensor {
    double readTemperatureC();
    boolean detectHuman(double thresholdC);
}