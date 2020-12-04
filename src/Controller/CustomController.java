package Controller;

import dao.serviceImp.CustomerServiceImp;
import models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomController {
    private CustomerServiceImp customerServiceImp;

    @Autowired
    public void setCustomerServiceImp(CustomerServiceImp customerServiceImp) {
        this.customerServiceImp = customerServiceImp;
    }

    @RequestMapping("/all")
    @ResponseBody
    public List<Customer> queryCustomers() {
        return this.customerServiceImp.queryCustomers();
    }


    @RequestMapping("/query")
    @ResponseBody
    public List<Customer> queryCustomer(@RequestParam String name) {
        return this.customerServiceImp.queryCustomersByName(name);
    }

    @RequestMapping("/add")
    @ResponseBody
    public boolean addCustomer(Customer customer) {
        return this.customerServiceImp.addCustomer(customer);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteCustomer(@PathVariable int id) {
        return this.customerServiceImp.deleteCustomer(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public boolean updateCustomer(Customer customer) {
        return this.customerServiceImp.updateCustomer(customer);
    }
}
