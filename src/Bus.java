public class Bus implements Transport{
    private final String route;

    public Bus(String route) {
        this.route = route;
    }

    @Override
    public String getRoute() {
        return route;
    }
}
