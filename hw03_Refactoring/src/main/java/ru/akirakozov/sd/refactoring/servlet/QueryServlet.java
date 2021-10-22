package ru.akirakozov.sd.refactoring.servlet;

import ru.akirakozov.sd.refactoring.dao.ProductDAO;
import ru.akirakozov.sd.refactoring.entity.Product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

/**
 * @author akirakozov
 */
public class QueryServlet extends HttpServlet {

    private final ProductDAO productDAO;

    public QueryServlet(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String command = request.getParameter("command");

        StringBuilder html = new StringBuilder();
        if ("max".equals(command)) {
            try {
                html.append("<html><body>\n");
                html.append("<h1>Product with max price: </h1>\n");
                Optional<Product> res = productDAO.getMaxProduct();
                res.ifPresent(product -> html.append(product.getName())
                                             .append("\t")
                                             .append(product.getPrice())
                                             .append("</br>\n"));
                html.append("</body></html>\n");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if ("min".equals(command)) {
            try {
                html.append("<html><body>\n");
                html.append("<h1>Product with min price: </h1>\n");
                Optional<Product> res = productDAO.getMinProduct();
                res.ifPresent(product -> html.append(product.getName())
                                             .append("\t")
                                             .append(product.getPrice())
                                             .append("</br>\n"));
                html.append("</body></html>\n");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if ("sum".equals(command)) {
            try {
                html.append("<html><body>\n");
                html.append("Summary price: \n");
                Optional<Integer> sum = productDAO.getProductPriceSum();
                sum.ifPresent(integer -> html.append(integer).append("\n"));
                html.append("</body></html>\n");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if ("count".equals(command)) {
            try {
                html.append("<html><body>\n");
                html.append("Number of products: \n");
                Optional<Integer> count = productDAO.getProductCount();
                count.ifPresent(integer -> html.append(integer).append("\n"));
                html.append("</body></html>\n");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            html.append("Unknown command: ").append(command).append("\n");
        }
        response.getWriter().println(html);
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
