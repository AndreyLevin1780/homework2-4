package pro.sky.Calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Calculator.service.CalculatorService;

@RestController
@RequestMapping ("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Добро пожаловать в калькулятор.";
    }

    @GetMapping("/plus")
    public String plus(Integer num1, Integer num2) {
        String checkResult = checkParameters(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else
            return num1 + "+" + num2 + "=" + calculatorService.plus(num1, num2);
    };

    @GetMapping("/minus")
    public String minus(Integer num1, Integer num2) {
        String checkResult = checkParameters(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else
          return num1 + "-" + num2 + "=" + calculatorService.minus(num1, num2);
    };

    @GetMapping("/multiply")
    public String multiply(Integer num1, Integer num2) {
        String checkResult = checkParameters(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else
          return num1 + "*" + num2 + "=" + calculatorService.multiply(num1, num2);
    };

    @GetMapping("/divide")
    public String divide(Integer num1, Integer num2) {
        String checkResult = checkParameters(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else if (num2 == 0) {
            return "Деление на 0.";
        } else
        return num1 + "/" + num2 + "=" + calculatorService.divide(num1, num2);
    };

    private String checkParameters (Integer num1, Integer num2) {
        if (num1 == null) {
            return "Параметр 1 не задан.";
        } else if (num2 == null) {
            return "Параметр 2 не задан.";
        }
            return null;
    }

}
