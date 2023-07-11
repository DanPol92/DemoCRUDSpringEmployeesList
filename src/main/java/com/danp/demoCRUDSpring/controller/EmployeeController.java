package com.danp.demoCRUDSpring.controller;

import com.danp.demoCRUDSpring.entity.Employee;
import com.danp.demoCRUDSpring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/list")
    public String ListOfEmployee(Model themodel){

       // throw new NotFoundException("oups, cannot get the list!");

        List<Employee> thelist=employeeService.findEmployeesList();
        themodel.addAttribute("employees",thelist);

        return "list";
    }

    @GetMapping("/showFormForAdd")
    public String addEmployee(Model theModel){
        Employee theEmployee=new Employee();
        theModel.addAttribute("employee",theEmployee);

        return "/form";
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") int id, Model theModel){
        Employee theEmployee=employeeService.findById(id);
        theModel.addAttribute("employee",theEmployee);

        return "/form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
        employeeService.save(theEmployee);

        return "redirect:/admin";
    }

    @GetMapping("/delete")
    public String deletemployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);

        return "redirect:/admin";
    }





}
