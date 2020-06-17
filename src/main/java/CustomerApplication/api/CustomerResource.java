package CustomerApplication.api;

import CustomerApplication.model.Customer;
import CustomerApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/customer/api*")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;
    @PostMapping("/add")
    @ResponseBody
    public Customer insertIntoCustomerDetails(@RequestBody Customer customer){
        return customerService.addCustomerDetails(customer);
    }
    @GetMapping("/getCustomerDetails")
    public Iterable getAllCustomerDetails(){
        return customerService.getCustomerDetails();
    }

    @GetMapping(value ="/{customerId}")
    public Customer getCustomer(@PathVariable("customerId")  int customerId){
        return customerService.getCustomerById(customerId);
    }

    @PutMapping(value="/update/{customerId}")
    public Customer updateCustomerDetails(@PathVariable("customerId") int customerId,@RequestBody Customer customer){
        return customerService.updateCustomerDetails(customer,customerId);
    }
    @DeleteMapping(value="/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId){
        customerService.deleteCustomerRecord(customerId);
    }

}
