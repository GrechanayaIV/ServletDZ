package net.dybinka.controller.Manufacturer;

import net.dybinka.DaoSingleton;
import net.dybinka.dao.ManufacturerDAO;
import net.dybinka.dao.hibernate.ManufacturerDAOImpl;
import net.dybinka.model.Manufacturer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAllManufacturerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        //Get all Manufacturer
        List<Manufacturer> manufacturers = DaoSingleton.getINSTANCE().getManufacturerDAO().getAll();

        //Print all manufacturers as link
        for(Manufacturer manufacturer: manufacturers){
            String customerText = manufacturer.getName();

            String editLinkManufacturer ="<a href=\"/editM?manufacturer_id=" + manufacturer.getId() + "\">EDIT</a>";
                    //"<form action=\"/edit?manufacturer_id=" + manufacturer.getId() + "\">"+
                      //      "<input type =\"submit\" value=EDIT>"+
                        //    "</form>";

            String deleteLinkManufacturer ="<a href=\"/deleteM?manufacturer_id=" + manufacturer.getId() + "\">DELETE</a>";
                    //"<form action=\"/delete?manufacturer_id=" + manufacturer.getId() + "\">"+
                      //      "<input type =\"submit\" value=DELETE>"+
                        //    "</form>";

            String finalLink = customerText +" " + editLinkManufacturer + " " + deleteLinkManufacturer;


            resp.getWriter().println(finalLink);
            resp.getWriter().println("<br><br>");
        }
        String addManufacturerLink ="<form action=\"addM\">\n" +
                "<p><input type=\"submit\" value=\"AddNewManufacturer\"></p>";
        resp.getWriter().println(addManufacturerLink);
    }

}
