package view;

import java.util.Scanner;
import controllers.UserController;
import model.Number;

public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void calculate() {
        Commands com = Commands.NONE;
        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command.toUpperCase());
            if (com == Commands.EXIT) return;
            switch (com) {
                case ADD:
                    userController.addNumbers(InputNumber(), InputNumber());
                    break;
                case SUBTRACT:
                    userController.subtractNumbers(InputNumber(), InputNumber());
                    break;
                case MULTIPLY:
                    userController.multiiplyNumbers(InputNumber(), InputNumber());
                    break;
                case DIVIDE:
                    userController.divideNumbers(InputNumber(), InputNumber());
                    break;
            }

        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private Number InputNumber() {
        String num = prompt("Number: ");
        Number newNum = new Number(num);
        return newNum;
    }
}
