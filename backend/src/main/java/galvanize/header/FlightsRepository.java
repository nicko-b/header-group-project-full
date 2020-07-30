package galvanize.header;

import galvanize.header.entities.Flights;
import org.springframework.data.repository.CrudRepository;

public interface FlightsRepository extends CrudRepository<Flights, Long> {
    Flights getById(Long id);

}