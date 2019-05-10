package com.nsv.jsmbaba.servlets;

import com.nsv.jsmbaba.domain.Customer;
import com.nsv.jsmbaba.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("RegistrationServlet-doPost()-BEGIN");
        CustomerService service = new CustomerService();
        Customer customer = new Customer();
        customer.setName(req.getParameter("name"));
        customer.setStreet(req.getParameter("street"));
        customer.setCity(req.getParameter("city"));
        customer.setState(req.getParameter("state"));
        customer.setCountry(req.getParameter("country"));
        customer.setZipCode(req.getParameter("zipcode"));
        int noOfRowsUpdated = service.createCustomer(customer);
        PrintWriter writer = resp.getWriter();
        if(noOfRowsUpdated > 0){
            writer.println("Customer "+customer.getName()+" is created"+"\n"+customer.toString());
        }else{
            writer.println("Customer is not created");
        }

    }
}
