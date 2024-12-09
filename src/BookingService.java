import java.util.*;

public class BookingService {
    private final List<Transport> availableRoutes;
    private final Map<String, String> bookings;

    public BookingService() {
        this.availableRoutes = new ArrayList<>();
        this.bookings = new HashMap<>();
        initializeRoutes();
    }

    private void initializeRoutes() {
        availableRoutes.add(new Bus("Bus: City A - City B"));
        availableRoutes.add(new Plane("Plane: City C - City D"));
    }

    public void displayRoutes() {
        System.out.println("\nДоступные маршруты:");
        for (Transport route : availableRoutes) {
            System.out.println("- " + route.getRoute());
        }
    }

    public void bookTicket(String routeName, String passengerName) {
        for (Transport route : availableRoutes) {
            if (route.getRoute().contains(routeName)) {
                bookings.put(passengerName, route.getRoute());
                System.out.println("Билет успешно забронирован для " + passengerName + " на " + route.getRoute());
                return;
            }
        }
        System.out.println("Маршрут не найден!");
    }

    public void cancelBooking(String passengerName) {
        if (bookings.remove(passengerName) != null) {
            System.out.println("Бронь успешно отменена для " + passengerName);
        } else {
            System.out.println("Бронь на имя " + passengerName + " не найдена!");
        }
    }

    public void displayAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("Нет активных броней.");
        } else {
            System.out.println("\nСписок всех броней:");
            bookings.forEach((name, route) -> System.out.println(name + " -> " + route));
        }
    }

    public void findBookingByName(String name) {
        String route = bookings.get(name);
        if (route != null) {
            System.out.println("Бронь найдена: " + name + " -> " + route);
        } else {
            System.out.println("Бронь для " + name + " не найдена!");
        }
    }

    public int getTotalBookings() {
        return bookings.size();
    }
}