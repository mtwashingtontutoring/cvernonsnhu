package calvin.demo.webcontrollers;

import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import calvin.demo.models.Booking;
import calvin.demo.services.BookingService;

@Controller
public class LandingPageController {
    BookingService bookingService;

    public LandingPageController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/home")
    public String showLandingPage(Model model) { /* shows landing page */
        Collection<Booking> bookings = this.bookingService.findAll();
        model.addAttribute("bookings", bookings);
        return "index";
    }
}
