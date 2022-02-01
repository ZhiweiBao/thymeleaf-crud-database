package edu.neu.thymeleafcruddatabase.controller;

import edu.neu.thymeleafcruddatabase.model.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  private List<Employee> employees;

  @PostConstruct
  private void loadData(){
    Employee emp1 = new Employee(1L,"Leslie","Andrews","leslie@luv2code.com");
    Employee emp2 = new Employee(2L,"Emma","Brandon","emma@luv2code.com");
    Employee emp3 = new Employee(3L,"Mary","Smith","mary@luv2code.com");
    employees = new ArrayList<>();
    employees.add(emp1);
    employees.add(emp2);
    employees.add(emp3);
  }

  @GetMapping("/list")
  public String listEmployees(Model model) {
    model.addAttribute("employees", employees);
    return "list-employees";
  }
}
