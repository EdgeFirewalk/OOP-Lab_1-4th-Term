package com.example.lab_1;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "calculator", value = "/calculator")
public class Calculator extends HttpServlet {
    public void init() {}

    public void destroy() {}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Получаем данные из формы
        String selectedFunction = request.getParameter("function-selector");
        String selectedValue = request.getParameter("calculate-in");
        String precisionString = request.getParameter("precision");
        String angleString = request.getParameter("angle");

        int precision = Integer.parseInt(precisionString);
        double angle = Double.parseDouble(angleString);

        // Переводим градусы в радианы, если необходимо
        if ("degrees".equals(selectedValue)) {
            angle = Math.toRadians(angle);
        }

        // Тригонометрические подсчёты
        double result = 0;
        switch (selectedFunction) {
            case "sin":
                result = Math.sin(angle);
                break;
            case "cos":
                result = Math.cos(angle);
                break;
            case "tan":
                result = Math.tan(angle);
                break;
            case "ctan":
                result = 1.0 / Math.tan(angle);
                break;
            default:
                break;
        }

        // Переводим результат к желаемой точности
        String formattedResult = String.format("%." + precision + "f", result);

        // Устанавливаем тип контента ответа
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Для написания ответа
        PrintWriter out = response.getWriter();

        // Пишем ответ в виде HTML, вставляя результат вычислений в разметку
        out.print("<!DOCTYPE html> <html> <head> <title>Тригонометрический калькулятор</title> <link rel=\"stylesheet\" href=\"index.css\"> </head> <body> <div class=\"app\"> <div class=\"container\"> <form class=\"calculator app__block\" action=\"calculator\" method=\"post\"> <div class=\"calculator__title title\">Тригонометрические функции</div> <div class=\"calculator__selected-function\"> <label for=\"function-selector\">Выбранная функция:</label> <select id=\"function-selector\" class=\"calculator__function-selector\" name=\"function-selector\"> <option value=\"sin\" selected>sin</option> <option value=\"cos\">cos</option> <option value=\"tan\">tan</option> <option value=\"ctan\">ctan</option> </select> </div> <div class=\"calculator__calculate-in\"> Расчёт в: <input id=\"degrees\" class=\"calculator__value-selector\" type=\"radio\" name=\"calculate-in\" value=\"degrees\" checked> <label for=\"degrees\">градусах</label> <input id=\"rad\" class=\"calculator__value-selector\" type=\"radio\" name=\"calculate-in\" value=\"rad\"> <label for=\"rad\">радианах</label> </div> <div class=\"calculator__precision\"> <label for=\"precision\">С точностью:</label> <input id=\"precision\" class=\"calculator__precision-selector\" type=\"number\" name=\"precision\" value=\"6\" min=\"0\" required> знаков </div> <div class=\"calculator__angle\"> <label for=\"angle\">Угол:</label> <input id=\"angle\" class=\"calculator__angle-selector\" type=\"number\" name=\"angle\" value=\"60\" required> </div> <input class=\"calculator__calculate-button\" type=\"submit\" value=\"Рассчитать\"> </form> <div class=\"answer app__block\"> <div class=\"answer__title title\">Результат</div> <p class=\"answer__result\">" + formattedResult + "</p> </div> </div> </div> </body> </html>");
    }
}
