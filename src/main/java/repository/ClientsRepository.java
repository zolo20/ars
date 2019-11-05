package repository;

import clients.entity.Client;
import org.springframework.data.repository.CrudRepository;


public interface ClientsRepository extends CrudRepository<Client, Long> {
}
