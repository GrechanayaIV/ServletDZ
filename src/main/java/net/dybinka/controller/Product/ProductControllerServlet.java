package net.dybinka.controller.Product;

import net.dybinka.DaoSingleton;
import net.dybinka.model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

public class ProductControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String productIdStr = req.getParameter("product_id");
        UUID productId = UUID.fromString(productIdStr);

        Product product = DaoSingleton.getINSTANCE().getProductDAO().getById(productId);

        req.setAttribute("productId", product.getId());
        req.setAttribute("name", product.getName());
        req.setAttribute("price", product.getPrice());
        req.setAttribute("manufacturer", product.getManufacturer());

        req.getRequestDispatcher("/jsp/product.jsp").forward(req, resp);
    }
}
