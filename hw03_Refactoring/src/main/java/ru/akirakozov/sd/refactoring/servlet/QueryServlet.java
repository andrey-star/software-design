package ru.akirakozov.sd.refactoring.servlet;

import ru.akirakozov.sd.refactoring.command.*;
import ru.akirakozov.sd.refactoring.dao.ProductDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author akirakozov
 */
public class QueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String command = request.getParameter("command");

        ProductCommand com;
        if ("max".equals(command)) {
            com = new MaxProduct();
        } else if ("min".equals(command)) {
            com = new MinProduct();
        } else if ("sum".equals(command)) {
            com = new SumPrice();
        } else if ("count".equals(command)) {
            com = new CountProducts();
        } else {
            com = new UnknownCommand(command);
        }

        try {
            response.getWriter().println(com.toHtml());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
