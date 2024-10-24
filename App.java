package Assignment02;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        String finalinput;
        do {
            System.out.println("첫번째 양의 정수: ");
            int num1 = sc.nextInt();
            num1=calculator.check(num1);
            String skip = sc.nextLine();
            System.out.println("연산자: ");
            char operator = sc.next().charAt(0);
            System.out.println("두번째 양의 정수: ");
            int num2 = sc.nextInt();
            num2=calculator.check(num2);
            if ((operator == '/') && (num2 == 0)) {
                System.out.println("나누는 수는 0이 될 수 없습니다.");
            } else {
                double result = calculator.Operate(num1, operator, num2);
                System.out.println("결과값: " + result);
            }

            System.out.println("더 계산하시려면 아무 키나 입력해주세요. 아니라면 exit을 입력해주세요.");
            String skip2 = sc.nextLine();
            finalinput = sc.nextLine();
        } while (!finalinput.equals("exit"));


        calculator.getResultCollection();
        System.out.println("가장 먼저 저장된 데이터를 삭제하시겠습니까? (yes / no)");
        do {
            String delete = sc.nextLine();
            if (delete.equals("yes")) {
                calculator.setRemoveResult();
                break;
            } else if (delete.equals("no")) {
                break;
            } else {
                System.out.println("yes / no 로만 대답해주세요.");
            }
        } while (true);
        calculator.getResultCollection();
    }
}
