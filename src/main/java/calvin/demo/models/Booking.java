package calvin.demo.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;
    private String passengerFirstName;
    private String passengerLastName;
    private String arrivalAirportCode;
    private String departureAirportCode;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    
    public Booking() {
    }

    public Booking(Long bookingId, String passengerFirstName, String passengerLastName, String arrivalAirportCode,
            String departureAirportCode, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.bookingId = bookingId;
        this.passengerFirstName = passengerFirstName;
        this.passengerLastName = passengerLastName;
        this.arrivalAirportCode = arrivalAirportCode;
        this.departureAirportCode = departureAirportCode;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getPassengerFirstName() {
        return passengerFirstName;
    }

    public void setPassengerFirstName(String passengerFirstName) {
        this.passengerFirstName = passengerFirstName;
    }

    public String getPassengerLastName() {
        return passengerLastName;
    }

    public void setPassengerLastName(String passengerLastName) {
        this.passengerLastName = passengerLastName;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }
}