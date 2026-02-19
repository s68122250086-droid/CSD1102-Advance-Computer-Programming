public interface Drivable {
    void startEngine();
    void stopEngine();
    double maxSpeed();

    default String status() {
        return "DRIVE MODE";
    }
}