import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Booking() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the passenger Name: ");
        this.passengerName = sc.next();

        System.out.println("Enter the Bus No: ");
        this.busNo = sc.nextInt();

        System.out.println("Enter your Booking Date in (dd-mm-yy) format: ");
        String date = sc.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;
        for(Bus bus : buses) {
            if(bus.getBusNo() == busNo) {
                capacity = bus.getCapacity();
                break;
            }
        }

        int bookingCount = 0;
        for(Booking booking : bookings) {
            if(booking.busNo == busNo && booking.date.equals(date)) {
                bookingCount++;
            }
        }

        return (bookingCount < capacity);
    }

    public void display() {
        System.out.println("Booking result...");
        System.out.println("Passenger name: " + passengerName);
        System.out.println("Bus No: " + busNo);
        System.out.println("Booked date: " + date);
    }

}
