package net.dybinka.controller.Manufacturer;

import net.dybinka.DaoSingleton;
import net.dybinka.dao.ManufacturerDAO;
import net.dybinka.dao.hibernate.ManufacturerDAOImpl;
import net.dybinka.model.Manufacturer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class ManufacturerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();
        UUID uuid = UUID.fromString(req.getParameter("id"));

        Manufacturer manufacturer = DaoSingleton.getINSTANCE().getManufacturerDAO().getById(uuid);

        writer.println("<html>" +
                "<head>" +
                "</head>" +
                "<body>" +
                "<h1>Manufacturer:</h1>" +
                "<br/>" +
                "ID:" + manufacturer.getId() +
                "<br/>" +
                "Name:" + manufacturer.getName() +
                "<br/>" +
                "</body>" +
                "</html>");
    }
}
