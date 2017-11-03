package net.dybinka.controller.Product;

import net.dybinka.DaoSingleton;
import net.dybinka.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAllProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");

        //Get all Products
        List<Product>products = DaoSingleton.getINSTANCE().getProductDAO().getAll();

        //Print all products as link
        for(Product product: products) {
            String productText = product.getName();

            String editLinkProduct = "<a href=\"/editP?product_id=" + product.getId() + "\">EDIT</a>";
            //"<form action=\"/editP?product_id=" + product.getId() + "\">"+
            //      "<input type =\"submit\" value=EDIT>"+
            //    "</form>";

            String deleteLinkProduct = "<a href=\"/deleteP?product_id=" + product.getId() + "\">DELETE</a>";
            //"<form action=\"/deleteP?product_id=" + product.getId() + "\">"+
            //      "<input type =\"submit\" value=DELETE>"+
            //    "</form>";

            String finalLink = productText + " " + editLinkProduct + " " + deleteLinkProduct;


            resp.getWriter().println(finalLink);
            resp.getWriter().println("<br><br>");
        }
          String addProductLink ="<form action=\"addP\">\n" +
                  "<p><input type=\"submit\" value=\"AddNewProduct\"></p>";
        resp.getWriter().println(addProductLink);
    }
}
