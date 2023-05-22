package calvin.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import calvin.demo.models.Greeting;
import calvin.demo.repositories.GreetingRepository;

@Service
public class HelloService {
    @Autowired
    GreetingRepository greetingsRepo;

    public Greeting greeting() {
        List<Greeting> greetings = greetingsRepo.findAll();

        return greetings.get(greetings.size() - 1);
    }
}
