package calvin.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    @Id
    @GeneratedValue
    Long id;

    String message;
    
    public Greeting() {}
    
    public Greeting(String message) {
        this.id = null;
        this.message = message;
    }
    
    public Greeting(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
