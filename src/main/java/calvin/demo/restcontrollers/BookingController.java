package calvin.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import calvin.demo.models.Booking;
import calvin.demo.services.BookingService;

@RestController
@RequestMapping("/api/bookings") /*retrieves bookings*/
public class BookingController {
    @Autowired
    BookingService bookingService;
    
    /*retrieves all bookings*/
    @GetMapping 
    public List<Booking> findAll() {
        return bookingService.findAll();
    }
    /*retrieves bookings by id */
    @GetMapping("{bookingId}")
    public ResponseEntity<Booking> findById(@PathVariable("bookingId") long id) {

        try {
            return ResponseEntity.ok(bookingService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    /*Creates bookings */
    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody Booking newBooking) {
        try {
            return ResponseEntity.ok(bookingService.create(newBooking));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    /*updates booking id */
    @PutMapping("{bookingId}")
    public ResponseEntity<Booking> update(
        @PathVariable String bookingId,
        @RequestBody Booking newBooking
    ) {
        try {
            return ResponseEntity.ok(bookingService.update(newBooking));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    /*deletes booking id */
    @DeleteMapping("{bookingId}")
    public ResponseEntity<Void> delete(@PathVariable long bookingId) {
        try {
            bookingService.delete(bookingId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    }

