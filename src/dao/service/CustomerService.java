package dao.service;

import models.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> queryCustomers();
    public List<Customer> queryCustomersByName(String name);
    public boolean addCustomer(Customer customer);
    public boolean deleteCustomer(int id);
    public boolean updateCustomer(Customer customer);
}
