package com.danp.demoCRUDSpring.controller;

import com.danp.demoCRUDSpring.entity.Employee;
import com.danp.demoCRUDSpring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class LoginController {
    private final EmployeeService employeeService;

    @Autowired
    public LoginController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping("/")
    public String showHomePage(Model theModel){

        theModel.addAttribute("theDate", new Date());
        return "index";
    }

    @GetMapping("/admin")
    public String showAdminPage(Model theModel){

        List<Employee> thelist=employeeService.findEmployeesList();
        theModel.addAttribute("employees",thelist);

        return "admin";
    }

    @GetMapping("/access-denied")
    public String showErrorForPermission(){
        return "access-denied";
    }
}
