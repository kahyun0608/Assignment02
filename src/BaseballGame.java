import java.util.Scanner;

public class BaseballGame extends GameNumber {

    //생성자
    public BaseballGame() {
        makeGameNumber();

    }

    public boolean play() throws BadException {
        System.out.println("숫자를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.matches("^[1-9]*$") || input.length() != 3) {
            throw new BadException();
        }
        settingInput(input);
        return checkNumbers();

    }

}
