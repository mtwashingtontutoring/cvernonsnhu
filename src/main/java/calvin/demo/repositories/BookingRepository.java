package calvin.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import calvin.demo.models.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}



