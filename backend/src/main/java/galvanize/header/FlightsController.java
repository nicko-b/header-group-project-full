package galvanize.header;
import org.springframework.web.bind.annotation.CrossOrigin;
import galvanize.header.entities.Flights;
import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
@CrossOrigin
public class FlightsController {

    private final FlightsRepository repository;

    public FlightsController(FlightsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Optional<Flights> flights(@PathVariable Long id) {
        return this.repository.findById(id);
    }

    @GetMapping("/all")
    public Iterable<Flights> flights() {
        return this.repository.findAll();
    }



    private Flights checkFlight(Long id) throws Exception {
        Flights foundFlight = this.repository.getById(id);
        if(foundFlight != null){
            return foundFlight;
        }
        throw new Exception("Flight not in database");
    }
}