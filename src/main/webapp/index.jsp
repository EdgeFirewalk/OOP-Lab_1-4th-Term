<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Тригонометрический калькулятор</title>

    <link rel="stylesheet" href="index.css">
</head>
<body>
    <div class="app">
        <div class="container">
            <form class="calculator app__block" action="calculator" method="post">
                <div class="calculator__title title">Тригонометрические функции</div>
                <div class="calculator__selected-function">
                    <label for="function-selector">Выбранная функция:</label>
                    <select id="function-selector" class="calculator__function-selector" name="function-selector">
                        <option value="sin" selected>sin</option>
                        <option value="cos">cos</option>
                        <option value="tan">tan</option>
                        <option value="ctan">ctan</option>
                    </select>
                </div>
                <div class="calculator__calculate-in">
                    Расчёт в:
                    <input id="degrees" class="calculator__value-selector" type="radio" name="calculate-in" value="degrees" checked>
                    <label for="degrees">градусах</label>
                    <input id="rad" class="calculator__value-selector" type="radio" name="calculate-in" value="rad">
                    <label for="rad">радианах</label>
                </div>
                <div class="calculator__precision">
                    <label for="precision">С точностью:</label>
                    <input id="precision" class="calculator__precision-selector" type="number" name="precision" value="6" min="0" required>
                    знаков
                </div>
                <div class="calculator__angle">
                    <label for="angle">Угол:</label>
                    <input id="angle" class="calculator__angle-selector" type="number" name="angle" value="60" required>
                </div>
                <input class="calculator__calculate-button" type="submit" value="Рассчитать">
            </form>
        </div>
    </div>
</body>
</html>
