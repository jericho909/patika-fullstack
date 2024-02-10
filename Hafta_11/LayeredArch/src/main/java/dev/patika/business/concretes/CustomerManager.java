package dev.patika.business.concretes;

import dao.abstracts.ICustomerDao;
import dev.patika.business.abstracts.ICustomerService;
import entities.Customer;

import java.util.List;

public class CustomerManager implements ICustomerService {
    private final ICustomerDao customerDao;

    public CustomerManager(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void save(Customer customer) {
        Customer checkCustomer = this.customerDao.findByMail(customer.getMail());
        if (checkCustomer != null) {
            throw new RuntimeException(customer.getMail() + " is already registered.");
        }

        this.customerDao.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return this.customerDao.findById(id);
    }

    @Override
    public void update(Customer customer) {
        Customer checkMail = this.customerDao.findByMail(customer.getMail());
        if (checkMail != null && checkMail.getId() != customer.getId()) {
            throw new RuntimeException("Mail already exists.");
        }
        this.customerDao.update(customer);
    }

    @Override
    public void deleteById(int id) {
        this.customerDao.delete(this.findById(id));
    }

    @Override
    public List<Customer> findAll() {
        return this.customerDao.findAll();
    }
}
