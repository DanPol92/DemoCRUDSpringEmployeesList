package com.danp.demoCRUDSpring.repository;

import com.danp.demoCRUDSpring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    public List<Employee> findAllByOrderByFirstNameAsc();

}
