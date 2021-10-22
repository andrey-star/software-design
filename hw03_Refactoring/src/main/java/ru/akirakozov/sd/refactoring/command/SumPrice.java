package ru.akirakozov.sd.refactoring.command;

import java.sql.SQLException;

public class SumPrice extends ProductCommand {

    @Override
    public String toHtml() throws SQLException {
        return htmlConverter.valueToHtml(productDAO.getProductPriceSum().get(), "Summary price");
    }
}
