package controllers;

import model.Repository;
import model.Number;

public class UserController {
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void addNumbers(Number num1, Number num2){
        Number result = repository.add(num1, num2);
        System.out.println("Result: " + result);
    }

    public void subtractNumbers(Number num1, Number num2){
        Number result = repository.subtract(num1, num2);
        System.out.println("Result: " + result);
    }

    public void multiiplyNumbers(Number num1, Number num2) {
        Number result = repository.multiply(num1, num2);
        System.out.println("Result: " + result);
    }

    public void divideNumbers(Number num1, Number num2){
        Number result = repository.divide(num1, num2);
        System.out.println("Result: " + result);
    }

}
