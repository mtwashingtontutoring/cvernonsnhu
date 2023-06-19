package calvin.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialDatabaseConfig implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        this.setInitialFlightDetails();
    }
    
    // initialize the flight details for a new database
    private void setInitialFlightDetails() {
    }
}
