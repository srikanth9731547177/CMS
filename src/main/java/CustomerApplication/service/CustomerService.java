package CustomerApplication.service;

import CustomerApplication.dao.CustomerDao;
import CustomerApplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public Customer addCustomerDetails(Customer customer)
    {
         /* customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerList.add(customer);
        customerIdCount++;
        return customer;*/
        return customerDao.save(customer);
    }

    public Iterable getCustomerDetails()
    {

        return customerDao.findAll();
    }
    public Customer getCustomerById(int customerId)
    {
        /*return customerList
                .stream()
                .filter(c -> c.getCustomerId()==customerId)
                .findFirst()
                .get();*/
        Optional<Customer> optionalCustomer = customerDao.findById(customerId);
        return optionalCustomer.get();
    }

    public Customer updateCustomerDetails(Customer customer,int customerId){
         /*customerList
                .stream()
                .forEach(c -> {
                    if (c.getCustomerId() == customerId) ;
                    c.setCustomerFirstName(customer.getCustomerFirstName());
                    c.setCustomerLastName(customer.getCustomerLastName());
                    c.setCustomerEmailId(customer.getCustomerEmailId());
                });
        return customerList.stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst().get();*/
        customer.setId(customerId);
        return customerDao.save(customer);
    }
    public void deleteCustomerRecord(int customerId){
         /* customerList.stream().forEach(c ->{
            if(c.getCustomerId() == customerId){
                customerList.remove(c);
            }
        });*/
        customerDao.deleteById(customerId);
    }

}
