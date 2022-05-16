package com.example.usermanagement_mvc.controller;

import com.example.usermanagement_mvc.model.Customer;
import com.example.usermanagement_mvc.service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "UserManagement", value = "/customers")
public class CustomerController extends HttpServlet {
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String router = req.getParameter("router");
        if (router == null) {
            router = "";
        }
        switch (router) {
            case "create":
                createForm(req, resp);
                break;
            case "edit":
                editForm(req, resp);
                break;
            case "delete":
                deleteFrom(req, resp);
                break;
            default:
                listCustomer(req, resp);
                break;
        }
    }


    private void deleteFrom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        customerService.removeById(id);
        listCustomer(req, resp);
    }

    private void editForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("lib/edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void createForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("lib/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void listCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        List<Customer> customers;
        if (name != null && name != "") {
            customers = customerService.searchByName(name);
        } else {
            customers = customerService.findAll();
        }
        req.setAttribute("customerList", customers);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("lib/list.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String router = req.getParameter("router");
        if (router == null) {
            router = "";
        }
        switch (router) {
            case "create":
                createCustomer(req, resp);
                break;
            case "edit":
                editCustomer(req, resp);
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    private void editCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        customerService.updateById(id, new Customer(id, name, email, address));
        listCustomer(req, resp);
    }

    private void createCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        customerService.save(new Customer(id, name, email, address));
        listCustomer(req, resp);
    }
}
