package model;

import java.util.ArrayList;
import java.util.List;

public class RepositoryImpl implements Repository {
    private Number num1;
    private Number num2;
    private FileOperation fileOperation;

    public RepositoryImpl(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public Number add(Number num1, Number num2) {
        List<String> numsPart = partOfNumbers(num1, num2);
        String resultReal = String.valueOf(Double.parseDouble(numsPart.get(0)) + Double.parseDouble(numsPart.get(1)));
        String resultImagine = String.valueOf(Double.parseDouble(numsPart.get(2)) + Double.parseDouble(numsPart.get(3)));
        String result = createExpression(resultReal, resultImagine);
        logirovanie(result);
        return new Number(result);
    }

    @Override
    public Number subtract(Number num1, Number num2) {
        List<String> numsPart = partOfNumbers(num1, num2);
        String resultReal = String.valueOf(Double.parseDouble(numsPart.get(0)) - Double.parseDouble(numsPart.get(1)));
        String resultImagine = String.valueOf(Double.parseDouble(numsPart.get(2)) - Double.parseDouble(numsPart.get(3)));
        String result = createExpression(resultReal, resultImagine);
        logirovanie(result);
        return new Number(result);
    }

    @Override
    public Number multiply(Number num1, Number num2) {
        List<String> numsPart = partOfNumbers(num1, num2);
        String resultReal = String.valueOf(Double.parseDouble(numsPart.get(0)) * Double.parseDouble(numsPart.get(1)));
        String resultImagine = String.valueOf(Double.parseDouble(numsPart.get(2)) * Double.parseDouble(numsPart.get(3)));
        String result = createExpression(resultReal, resultImagine);
        logirovanie(result);
        return new Number(result);
    }

    @Override
    public Number divide(Number num1, Number num2) {
        List<String> numsPart = partOfNumbers(num1, num2);
        String resultReal = String.valueOf(Double.parseDouble(numsPart.get(0)) / Double.parseDouble(numsPart.get(1)));
        String resultImagine = String.valueOf(Double.parseDouble(numsPart.get(2)) / Double.parseDouble(numsPart.get(3)));
        String result = createExpression(resultReal, resultImagine);
        logirovanie(result);
        return new Number(result);

    }

    private void logirovanie(String result){
        List<String> lines = fileOperation.readAllLines();
        lines.add(result);
        fileOperation.saveAllLines(lines);
    }

    private String createExpression(String real, String imagine){
        StringBuilder result = new StringBuilder();
        result.append(real);
        result.append("+");
        result.append(imagine);
        result.append("*");
        result.append("i");
        return result.toString();
    }

    private int whichNumber(Number num){
        if (num.getNum().contains("i")){
            return 1;
        }
        return 2;
    }

    private String[] getComplex(Number num){
        String[] allNumber = new String[2];
        if(!num.getNum().contains("-") && !num.getNum().contains("+") || testOnImaginaryPart(num) == 1){
            allNumber[0] = "0";
            String[] imagine = num.getNum().split("i");
            allNumber[1] = imagine[0];
            return allNumber;
        }

        if (num.getNum().contains("+")){
            allNumber = num.getNum().split("\\+");
        }
        else {
            allNumber = num.getNum().split("-");
        }
        String[] imaginaryPart = allNumber[1].split("i");
        allNumber[1] = imaginaryPart[0];
        return allNumber;
    }

    private int testOnImaginaryPart(Number num){
        String[] number;
        if (num.getNum().contains("-")) {
            number = num.getNum().split("-");
            if (number.length == 1){
                return 1;
            }
        }
        return 2;
    }

    private List<String> partOfNumbers(Number num1, Number num2){
        String num1_real = "", num2_real = "", num1_imaginary = "", num2_imaginary = "";
        List<String> partOfNum = new ArrayList<>();

        if (whichNumber(num1) == 1 ){
            num1_real = getComplex(num1)[0];
            num1_imaginary = getComplex(num1)[1];
        }
        if (whichNumber(num2) == 1 ){
            num2_real = getComplex(num2)[0];
            num2_imaginary = getComplex(num2)[1];
        }
        else{
            if (whichNumber(num1) == 2){
                num1_real = num1.getNum();
            }
            if (whichNumber(num2) == 2){
                num2_real = num2.getNum();
            }
        }

        if (!num1_real.isEmpty() && !num2_real.isEmpty()){
            partOfNum.add(num1_real);
            partOfNum.add(num2_real);
        }

        if (!num1_imaginary.isEmpty() ) {
            partOfNum.add(num1_imaginary);
        }
        else{
            partOfNum.add("0");
        }

        if (!num2_imaginary.isEmpty() ) {
            partOfNum.add(num2_imaginary);
        }
        else {
            partOfNum.add("0");
        }

        return partOfNum;
    }

}
