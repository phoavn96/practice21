package controller;

import entity.Employee;
import service.EmployeeService;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet(name = "createEmployee",value = "/employee/create")
public class CreateEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/employee/employee.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Employee employee = new Employee();
        employee.setFullName(req.getParameter("fullName"));
        employee.setBirthday(Date.valueOf(req.getParameter("birthday")));
        employee.setAddress(req.getParameter("address"));
        employee.setPosition(req.getParameter("position"));
        employee.setDepartment(req.getParameter("department"));
        employeeService.create(employee);
        resp.sendRedirect("/employee/list");


    }
}
