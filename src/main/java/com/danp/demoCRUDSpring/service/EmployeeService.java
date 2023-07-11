package com.danp.demoCRUDSpring.service;

import com.danp.demoCRUDSpring.entity.Employee;
import com.danp.demoCRUDSpring.exception.NotFoundException;
import com.danp.demoCRUDSpring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findEmployeesList(){
        return employeeRepository.findAllByOrderByFirstNameAsc();
    }

    public Employee findById(int id){
        Optional<Employee> result= employeeRepository.findById(id);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }
        else{
            throw  new RuntimeException("we didn't find the employee with id: "+id);
        }
        return theEmployee;
    }

    public void save(Employee theEmployee){
        employeeRepository.save(theEmployee);
    }

    public void deleteById(int id){
        employeeRepository.deleteById(id);
    }
}
