package calvin.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import calvin.demo.models.Greeting;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, Long>{
}
