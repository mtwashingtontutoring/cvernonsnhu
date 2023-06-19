package calvin.demo.webcontrollers;

import calvin.demo.services.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import calvin.demo.models.Booking;

import java.time.LocalDateTime;

@Controller
@RequestMapping("bookings")
public class BookingPageController {

    private final BookingService bookingService;

    public BookingPageController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/select-flight")
    public String showBookingPage(Model model) { /*shows booking page*/
        Booking booking = new Booking();
        booking.setDepartureTime(LocalDateTime.now().withSecond(0).withNano(0));
        booking.setArrivalTime(LocalDateTime.from(booking.getDepartureTime()).plusDays(2));
        model.addAttribute("booking", booking);
        return "bookings/select-flight";
    }

    @PostMapping("/select-flight")  /*shows booking confirmation page with booking id, passenger, and flight info*/
    public String displayPassengerInfo(Model model,
        @ModelAttribute("bookingInfo") Booking booking)
    throws Exception {
       
        this.bookingService.create(booking);

        return "redirect:/home";
    }
}

