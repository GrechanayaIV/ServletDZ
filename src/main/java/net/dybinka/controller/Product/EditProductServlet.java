package net.dybinka.controller.Product;

import net.dybinka.DaoSingleton;
import net.dybinka.model.Manufacturer;
import net.dybinka.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

public class EditProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String productIdStr = req.getParameter("product_id");
        UUID productId = UUID.fromString(productIdStr);

        String name = req.getParameter("name");
        BigDecimal price = new BigDecimal(Integer.valueOf(req.getParameter("price")));
        Manufacturer manufacturer = DaoSingleton.getINSTANCE().getManufacturerDAO().getByName(req.getParameter("manufacturer"));

        Product product = DaoSingleton.getINSTANCE().getProductDAO().getById(productId);
        product.setName(name);
        product.setPrice(price);
        product.setManufacturer(manufacturer);

        DaoSingleton.getINSTANCE().getProductDAO().update(product);

        //Show some feedback for user
        resp.getWriter().println("Product updated!");
        resp.getWriter().println("<br>");
        resp.getWriter().println("<br>");

        //Show link to see all product
        String link = " <form action=\"listP\">\n" +
                "   <p><input type=\"submit\" value=ShowAllProduct\"></p>\n" +
                "  </form>";
        resp.getWriter().println(link);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdStr = req.getParameter("product_id");
        UUID productId = UUID.fromString(productIdStr);

        //Get product data
        Product product = DaoSingleton.getINSTANCE().getProductDAO().getById(productId);
        String name = product.getName();
        String price = String.valueOf(product.getPrice());
        Manufacturer manufacturer = product.getManufacturer();
        String mName = manufacturer.getName();

        req.setAttribute("productId", productId);

        //Make HTML form
        String form = "<!DOCTYPE html>\n" +
                "<html>\n" +
                " <head>\n" +
                "<meta charset=\"utf-8\"/>\n" +
                "<title>Update product</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Update product</h2>\n" +
                "<form action=\"editP\" method=\"POST\" accept-charset=\"utf-8\">\n" +
                "<p>New Name</p>\n" +
                "<input type=\"text\" name=\"name\"/ value=\"" + name + "\">\n" +
                "<p>New Price</p>\n" +
                "<input type=\"text\" name=\"price\"/ value=\"" + price +"\">\n" +
                "<p>New Manufacture</p>" +
                "<input type=\"text\" name=\"manufacturer\"/ value=\"" + mName +"\">\n"+
                "<input type=\"hidden\" name=\"product_id\" value=\"" + productIdStr + "\">" +
                "<br>\n" +
                "<input type=\"submit\" value=\"update\"/>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";


        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println(form);

    }
}
