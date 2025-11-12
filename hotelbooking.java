// HotelRoom.java
public class HotelRoom {
    private int roomNumber;
    private String roomType;
    private boolean isBooked;

    public HotelRoom(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isBooked = false;
    }

    public int getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean status) { isBooked = status; }
}

// User.java
public class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}

// Booking.java
public class Booking {
    private User user;
    private HotelRoom room;

    public Booking(User user, HotelRoom room) {
        this.user = user;
        this.room = room;
        this.room.setBooked(true);
    }

    public User getUser() { return user; }
    public HotelRoom getRoom() { return room; }
}

// RoomService.java
import java.util.ArrayList;
import java.util.List;

public class RoomService {
    private Booking booking;
    private List<String> services;

    public RoomService(Booking booking) {
        this.booking = booking;
        this.services = new ArrayList<>();
    }

    public void requestService(String service) {
        services.add(service);
    }

    public List<String> getServices() { return services; }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        // Setup sample room and user
        HotelRoom room = new HotelRoom(101, "Deluxe");
        User user = new User("Alice", "alice@example.com");

        // Create a booking
        Booking booking = new Booking(user, room);

        // Request room service
        RoomService roomService = new RoomService(booking);
        roomService.requestService("Breakfast");
        roomService.requestService("Laundry");

        // Display details
        System.out.println("Guest: " + booking.getUser().getName());
        System.out.println("Room Number: " + booking.getRoom().getRoomNumber());
        System.out.println("Room Services: " + roomService.getServices());
        System.out.println("Is Room Booked? " + booking.getRoom().isBooked());
    }
}
