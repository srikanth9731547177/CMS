package CustomerApplication.dao;

import CustomerApplication.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer,Integer> {

}
