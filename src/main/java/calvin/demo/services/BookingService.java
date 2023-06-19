package calvin.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import calvin.demo.models.Booking;
import calvin.demo.repositories.BookingRepository;

@Service
public class BookingService {
    private final BookingRepository bookingRepo;

    public BookingService(
        BookingRepository bookingRepo
    ) {
        this.bookingRepo = bookingRepo;
    }

    /* lists bookings */
    public List<Booking> findAll() {
        return bookingRepo.findAll();
    }

    /* finds bookings by id */
    public Booking findById(long id) throws Exception {
        return bookingRepo.findById(id).orElseThrow(Exception::new);
    }

    /* creates bookings */
    public Booking create(Booking newBooking) throws Exception {
        return bookingRepo.save(newBooking);
    }

    /* updates bookings */
    public Booking update(Booking newBooking) throws Exception {
        if (!bookingRepo.existsById(newBooking.getBookingId())) {
            throw new Exception("already exists"); /* throws exception if booking already exists */
        }
        return bookingRepo.save(newBooking);
    }

    /* deletes bookings */
    public void delete(long bookingId) throws Exception {
        bookingRepo.deleteById(bookingId);
    }

    public void delete(Booking newBooking) throws Exception {
        bookingRepo.delete(newBooking);
    }
}
