import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        buses.add(new Bus(1, true, 2));
        buses.add(new Bus(2, false, 5));
        buses.add(new Bus(3, true, 5));

        for(Bus bus : buses){
            bus.displayBusInformation();
        }

        boolean userOption = true;
        boolean firstTime = true;
        while(userOption){
            if(firstTime) {
                System.out.println("Do you want to Book(Yes/No): ");
                firstTime = false;
            }
            else {
                System.out.println("Do you want to continue Booking(Yes/No): ");
            }
            userOption = (sc.next().equalsIgnoreCase("Yes"));
            if(userOption){
                Booking booking = new Booking();
                if(booking.isAvailable(bookings, buses)){
                    bookings.add(booking);
                    booking.display();
                    System.out.println("Your Booking is successfully confirmed..");
                }
                else{
                    System.out.println("Oops! Booking full.. Try with another date or Bus..");
                }
            }
        }

    }
}