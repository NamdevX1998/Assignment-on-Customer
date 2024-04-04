package com.example.Customer.Controller;


import com.example.Customer.Service.CustomerService;
import com.example.Customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/register")
    public String getCustomerdetailPage(@ModelAttribute Customer customer){
        String result=customerService.addCustomer(customer);
        return result;
    }

    @PutMapping("/update/fname")        //update first name
    public String updateCustomerName(@RequestParam("id")int id,@RequestParam("fname")String Fname){
        String result=customerService.updateCustomerName(id,Fname);
        return result;
    }

    @GetMapping("/getAllUsersName")       //sorting based on name
    public List<String> getUsers(){
        return customerService.getUsers();
    }

    @GetMapping("/getUserById")
    public String getUser(@RequestParam("id")int id){
        return customerService.getUser(id);
    }

    @DeleteMapping("/deleteUserById")
    public String deleteUser(@RequestParam("id")int id){
        return customerService.deleteUser(id);
    }
}

