package edu.neu.thymeleafcruddatabase.service;


import edu.neu.thymeleafcruddatabase.entity.Employee;
import java.util.List;

public interface EmployeeService {

  List<Employee> findAll();

  Employee findById(Long id);

  void save(Employee employee);

  void delete(Long employeeId);
}
