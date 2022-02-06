package edu.neu.thymeleafcruddatabase.controller;

import edu.neu.thymeleafcruddatabase.entity.Employee;
import edu.neu.thymeleafcruddatabase.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    return "employees/list-employees";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model) {
    Employee employee = new Employee();
    model.addAttribute("employee", employee);
    return "employees/employee-form";
  }

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("employeeId") Long employeeId, Model model) {
    Employee employee = employeeService.findById(employeeId);
    model.addAttribute("employee", employee);
    return "employees/employee-form";
  }

  @PostMapping("/save")
  public String saveEmployee(@ModelAttribute Employee employee) {
    employeeService.save(employee);
    return "redirect:/employees/list";
  }

  @GetMapping("/delete")
  public String delete(@RequestParam("employeeId") Long employeeId) {
    employeeService.delete(employeeId);
    return "redirect:/employees/list";
  }
}
