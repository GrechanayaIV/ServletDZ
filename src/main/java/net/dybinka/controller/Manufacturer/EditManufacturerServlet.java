package net.dybinka.controller.Manufacturer;

import net.dybinka.DaoSingleton;
import net.dybinka.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class EditManufacturerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String manufacturerIdStr = req.getParameter("manufacturer_id");
        UUID manufacturerId = UUID.fromString(manufacturerIdStr);

        String name = req.getParameter("name");

        Manufacturer manufacturer = DaoSingleton.getINSTANCE().getManufacturerDAO().getById(manufacturerId);
        manufacturer.setName(name);

        DaoSingleton.getINSTANCE().getManufacturerDAO().update(manufacturer);

        //Show some feedback for user
        resp.getWriter().println("Manufacturer updated!");
        resp.getWriter().println("<br>");
        resp.getWriter().println("<br>");

        //Show link to see all manufacturers
        String link = " <form action=\"listM\">\n" +
                "   <p><input type=\"submit\" value=ShowAllManufacturer\"></p>\n" +
                "  </form>";
        resp.getWriter().println(link);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manufacturerIdStr = req.getParameter("manufacturer_id");
        UUID manufacturerId = UUID.fromString(manufacturerIdStr);

        //Get manufacturer data
        Manufacturer manufacturer = DaoSingleton.getINSTANCE().getManufacturerDAO().getById(manufacturerId);
        String name = manufacturer.getName();

        req.setAttribute("manufacturerId", manufacturerId);

       /** req.getRequestDispatcher("edit_manufacturer.jsp").forward(req,resp);*/
        //Make HTML form
       String form = "<!DOCTYPE html>\n" +
                "<html>\n" +
                " <head>\n" +
                "<meta charset=\"utf-8\"/>\n" +
                "<title>Update manufacturer</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Update manufacturer</h2>\n" +
                "<form action=\"editM\" method=\"POST\" accept-charset=\"utf-8\">\n" +
                "<p>New Name</p>\n" +
                "<input type=\"text\" name=\"name\"/ value=\"" + name + "\">\n" +
                "<input type=\"hidden\" name=\"manufacturer_id\" value=\"" +manufacturerIdStr + "\">" +
                "<br>\n" +
                "<input type=\"submit\" value=\"update\"/>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";


        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println(form);

    }
}
