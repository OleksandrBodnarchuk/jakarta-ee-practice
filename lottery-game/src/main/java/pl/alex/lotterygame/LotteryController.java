package pl.alex.lotterygame;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(value = "/lottery")
public class LotteryController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer> numbersReceived = getNumbers(request);
        List<Integer> numbersGenerated = LotteryNumberHelper.generateRandomNumbers();
        List<Integer> winnerNumbers = LotteryNumberHelper.getCommonNumbers(numbersReceived, numbersGenerated);
        LotteryDTO lotteryDTO = new LotteryDTO(numbersReceived,numbersGenerated,winnerNumbers);
        request.setAttribute("lotteryDTO",lotteryDTO);
        request.getRequestDispatcher("/lottery.jsp").forward(request,response);
    }

    private List<Integer> getNumbers(HttpServletRequest request) {
        String[] numbers = request.getParameterValues("numbers");
        return Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
