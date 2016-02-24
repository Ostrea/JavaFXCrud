package uni.projects.javafxcrud.models.repositories;

import org.springframework.data.repository.CrudRepository;
import uni.projects.javafxcrud.models.OrderTable;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<OrderTable, Long> {
    Optional<OrderTable> findByContract(long contractId);
}
