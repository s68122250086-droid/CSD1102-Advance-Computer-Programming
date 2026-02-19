public class GPSTracker {

    private double lat;
    private double lon;

    public void updatePosition(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String currentPosition() {
        return "(" + lat + ", " + lon + ")";
    }
}