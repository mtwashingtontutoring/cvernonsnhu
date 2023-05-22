package calvin.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import calvin.demo.models.Greeting;
import calvin.demo.repositories.GreetingRepository;

@Component
public class GreetingsConfig implements CommandLineRunner{
    @Autowired
    GreetingRepository greetingRepo;

    @Override
    public void run(String... args) throws Exception {
        long count = greetingRepo.count();
        if(count == 0) {
            greetingRepo.save(new Greeting("hello world"));
        }
    }
    
}
