public class Plane implements Transport  {
    private final String route;

    public Plane(String route) {
        this.route = route;
    }

    @Override
    public String getRoute() {
        return route;
    }
}
