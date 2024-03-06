package view;

import dao.concretes.CustomerDao;
import dev.patika.business.concretes.CustomerManager;
import entities.Customer;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager(new CustomerDao());

//        Customer customer = new Customer();
//
//        customer.setName("test dao");
//        customer.setMail("test2@test.com");
//        customer.setGender(Customer.GENDER.MALE);
//        customer.setOnDate(LocalDate.now());
//
//        customerManager.save(customer);
//        customerManager.deleteById(3);
        Customer customer = customerManager.findById(4);
        customer.setMail("test@test.com");
        customerManager.update(customer);
    }
}
