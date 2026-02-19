public class ScenarioTest {

    public static void main(String[] args) {

        RescueRobot robot = new RescueRobot("RR-01");

        robot.updatePosition(13.7563, 100.5018);

        robot.takeOff();
        System.out.println(robot.status());
        robot.land();

        robot.startEngine();
        System.out.println("Max Speed: " + robot.maxSpeed());
        robot.stopEngine();

        robot.readTemperatureC();
        robot.detectHuman(36.5);

        robot.send("Found hotspot...");

        robot.showBattery();
    }
}