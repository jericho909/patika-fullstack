package dev.patika.spring.api;

import dev.patika.spring.business.abstracts.ICustomerService;
import dev.patika.spring.dto.CustomerResponse;
import dev.patika.spring.dto.CustomerSaveRequest;
import dev.patika.spring.dto.CustomerUpdateRequest;
import dev.patika.spring.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> findAll(){
        return this.customerService.findAll().stream().map(customer -> this.modelMapper.map(customer, CustomerResponse.class)).toList();
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody CustomerSaveRequest customerSaveRequest){
        Customer newCustomer = this.modelMapper.map(customerSaveRequest, Customer.class);
        newCustomer.setOnDate(LocalDate.now());
        return this.customerService.save(newCustomer);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Customer update(@RequestBody CustomerUpdateRequest customerUpdateRequest){
//        return this.customerService.update(customer);
//        return this.modelMapper.map(this.customerService.update(customer), CustomerDto.class);
        Customer editedCustomer = this.customerService.getById(customerUpdateRequest.getId());
        editedCustomer.setName(customerUpdateRequest.getName());
        editedCustomer.setGender(customerUpdateRequest.getGender());
        return this.customerService.update(editedCustomer);
    }
    
    @DeleteMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody Customer customer){
        this.customerService.delete(customer.getId());
    }

    @GetMapping("customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getById(@PathVariable("id") int id){
        return this.modelMapper.map(this.customerService.getById(id), CustomerResponse.class);
    }
}
