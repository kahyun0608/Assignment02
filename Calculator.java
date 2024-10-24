package Assignment02;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    //필드
    private ArrayList<Double> ResultCollection;
    double result;
    char Operator;

    //생성자
    public Calculator() {
        ResultCollection = new ArrayList<Double>();
    }

    //메서드
    public double Operate(int num1, char type, int num2) {
        Operator = type;
        if (Operator=='+'){
            result = num1+num2;
        } else if (Operator=='-'){
            result = num1-num2;
        }else if (Operator=='*'){
            result = num1*num2;
        }else if (Operator=='/'){
            result = (double)num1 / (double)num2;
        } else {
            System.out.println("잘못된 연산자를 입력하셨습니다.");
        }
        ResultCollection.add(result);
        return result;
    }
    public void setRemoveResult() {
        ResultCollection.remove(0);
    }
    public ArrayList<Double> getResultCollection() {
        System.out.println(ResultCollection);
        return ResultCollection;
    }
    public int check(int number){
        while(number<0) {
            System.out.println("양의 정수가 아닙니다. 0보다 큰 정수를 다시 입력해주세요.");
            Scanner sc = new Scanner(System.in);
            number = sc.nextInt();
        }return number;
        }
    }

