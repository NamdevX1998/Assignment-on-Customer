package com.example.Customer.Service;

import com.example.Customer.Repository.CustomerRepository;
import com.example.Customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Customer is added succefully";
    }
    public String updateCustomerName(int id, String fname) {
         Customer customer=customerRepository.findById(id).get();
         if(customer==null)
             return "Invalid Customer Id";
         customer.setFirst_Name(fname);
         customerRepository.save(customer);
         return "Updation succefully";
    }

    public List<String> getUsers() {
        List<Customer>list=customerRepository.findAll();
        List<String>ans=new ArrayList<>();
        for(Customer customer:list){
            ans.add(customer.getFirst_Name());
        }
        Collections.sort(ans);
        return ans;
    }

    public String getUser(int id) {
        Customer customer=customerRepository.findById(id).get();
        if(customer==null)
            return "Invalid User Id";
        return "Customer name is : "+customer.getFirst_Name();
    }

    public String deleteUser(int id) {
        Customer customer=customerRepository.findById(id).get();
        if(customer==null)
            return "Invalid User Id";
        customerRepository.delete(customer);
        return "Customer is deleted";
    }
}
