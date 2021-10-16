package pl.alex.exchangeratecalculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

@WebServlet(value = "/exchange")
public class ExchangeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      if (validateParameters(req,resp)){
          paramsChecked(req, resp);
      } else{
          paramsFailed(req,resp);
      }

    }

    private void paramsFailed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/failed.jsp").forward(req,resp);
    }

    private boolean validateParameters(HttpServletRequest request, HttpServletResponse resp) {
        String exchangeParam = request.getParameter("exchange");
        if (exchangeParam == null || exchangeParam.equals("")) {
            request.setAttribute("message", "Typ wymiany nie został określony");
            return false;
        } else {
            ExchangeType[] exchangeTypes = ExchangeType.values();
            boolean invalidExchangeType = Arrays.stream(exchangeTypes)
                    .map(Enum::toString)
                    .noneMatch(exchangeType -> exchangeType.equals(exchangeParam));
            if (invalidExchangeType) {
                request.setAttribute("message", "Nieznany typ wymiany: " + exchangeParam);
                return false;
            }
        }
        String value = request.getParameter("value");
        if (value == null || value.equals("")) {
            request.setAttribute("message", "Kwota nie została określona");
            return false;
        } else if (!value.matches("-?\\d+(\\.\\d+)?")) {
            request.setAttribute("message", "Nieprawidłowy numerek");
            return false;
        }
        return true;
    }

    private void paramsChecked(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String base = req.getParameter("amount");
        BigDecimal baseValue = new BigDecimal(base);
        String currency = req.getParameter("currency");
        ExchangeType exchangeType = ExchangeType.valueOf(currency);
        ExchangeResult result = ExchangeCalculator.calculate(baseValue, exchangeType);
        req.setAttribute("result", result);
        req.getRequestDispatcher("/result.jsp").forward(req, resp);
    }

}
