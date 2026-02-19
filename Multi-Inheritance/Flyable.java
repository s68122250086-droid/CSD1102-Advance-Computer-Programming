public interface Flyable {
    void takeOff();
    void land();
    double maxAltitude();

    default String status() {
        return "FLY MODE";
    }
}