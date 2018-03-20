package org.astanis.timesheet.controller;

import org.astanis.timesheet.model.Employee;
import org.astanis.timesheet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listEmployees(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", employeeService.listAll());
        return "admin";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String addEmployees(@ModelAttribute("employee") Employee employee) {
        if (employee.getId() == 0) {
            employeeService.saveEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }

        return "redirect:/admin";
    }

    @RequestMapping("edit/{id}")
    public String editEmployees(@PathVariable("id") long id, Model model) {
        model.addAttribute("employee", employeeService.readById(id));
        model.addAttribute("listEmployees", employeeService.listAll());

        return "admin";
    }

    @RequestMapping("/remove/{id}")
    public String removeEmployees(@PathVariable("id") long id) {
        employeeService.deleteEmployeeById(id);

        return "redirect:/admin";
    }

    @RequestMapping("employeedata/{id}")
    public String employeeData(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.readById(id));

        return "employeedata";
    }
}
