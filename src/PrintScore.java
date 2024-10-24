import java.util.ArrayList;
import java.util.Collections;

public class PrintScore {
    //메서드
    //score 리스트와 output(strike, ball, out 중 하나)를 입력받아 리스트 안의 output의 개수를 세어 출력
    public static void printScore(ArrayList<String> score, String output) {
        int numberOfOutput = Collections.frequency(score, output);
        if (numberOfOutput > 0) {
            System.out.print(numberOfOutput + output + " ");
        }
    }
}
