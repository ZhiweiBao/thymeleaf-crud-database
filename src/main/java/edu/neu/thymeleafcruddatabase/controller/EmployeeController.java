package edu.neu.thymeleafcruddatabase.controller;

import edu.neu.thymeleafcruddatabase.entity.Employee;
import edu.neu.thymeleafcruddatabase.service.EmployeeService;
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

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping("/list")
  public String listEmployees(Model model) {
    model.addAttribute("employees", employeeService.findAll());
    return "list-employees";
  }
}
