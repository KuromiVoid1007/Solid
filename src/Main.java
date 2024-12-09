import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BookingService bookingService = new BookingService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Система заказа билетов ===");
            System.out.println("1. Посмотреть доступные маршруты");
            System.out.println("2. Забронировать билет");
            System.out.println("3. Отменить бронь");
            System.out.println("4. Показать все брони");
            System.out.println("5. Найти бронь по имени");
            System.out.println("6. Общее количество бронированных билетов");
            System.out.println("0. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookingService.displayRoutes();
                    break;
                case 2:
                    System.out.print("Введите имя пассажира: ");
                    String passengerName = scanner.nextLine();
                    System.out.print("Введите маршрут (Bus/Plane): ");
                    String routeName = scanner.nextLine();
                    bookingService.bookTicket(routeName, passengerName);
                    break;
                case 3:
                    System.out.print("Введите имя пассажира для отмены: ");
                    String cancelName = scanner.nextLine();
                    bookingService.cancelBooking(cancelName);
                    break;
                case 4:
                    bookingService.displayAllBookings();
                    break;
                case 5:
                    System.out.print("Введите имя для поиска: ");
                    String searchName = scanner.nextLine();
                    bookingService.findBookingByName(searchName);
                    break;
                case 6:
                    System.out.println("Общее количество бронированных билетов: " + bookingService.getTotalBookings());
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
        scanner.close();
    }
}