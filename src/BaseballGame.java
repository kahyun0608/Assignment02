import java.util.Scanner;

public class BaseballGame extends GameNumber {

    //생성자
    public BaseballGame(String difficultyInput) {
        this.difficulty = Integer.valueOf(difficultyInput);
        makeGameNumber(this.difficulty);
    }

    public boolean play() throws BadException {
        System.out.println("숫자를 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.matches("^[1-9]*$") || input.length() != difficulty) {
            throw new BadException();
        }
        settingInput(input);
        return checkNumbers();

    }

}
