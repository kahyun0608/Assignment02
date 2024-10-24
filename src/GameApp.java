import java.util.ArrayList;
import java.util.Scanner;

public class GameApp {
    static ArrayList<Integer> record = new ArrayList<Integer>();

    public static boolean start() throws BadException {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("☆환영합니다! 원하시는 번호를 입력해주세요.☆");
        System.out.println("1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기");

        String start = sc.nextLine();
        switch (start) {
            case "1":                                             //1번 게임 시작하기 선택
                System.out.println("설정하고자 하는 자리수를 입력하세요. -> 3, 4, 5");
                String difficultyInput = sc.nextLine();
                //345가 아닐 경우 오류를 출력하자
                while (!difficultyInput.matches("^[3-5]*$")) {
                    throw new BadException();
                }
                BaseballGame baseballGame = new BaseballGame(difficultyInput);
                boolean gameWin = false;
                while (!gameWin) {                    //게임 한 판(round) 시작
                    try {
                        gameWin = baseballGame.play(); //게임 구동 -> 한 번의 숫자 입력 후 결과출력
                        baseballGame.trynumber += 1; //시도 횟수 + 1

                    } catch (BadException e) {
                        System.out.println(e.getMessage());
                    }
                }
                record.add(baseballGame.trynumber);     //방금 한 게임의 시도횟수 저장
                return false;
            case "2":                                          // 2번 게임 기록 보기 선택
                System.out.println("<게임 기록 보기>");
                for (int i = 0; i < record.size(); i++) {
                    System.out.println(i + 1 + "번째 게임 : 시도횟수 - " + record.get(i));
                }
                return false;
            case "3":                                                    // 3번 종료하기 선택
                System.out.println("< 숫자 야구 게임을 종료합니다. >");
                return true;
            default:
                throw new BadException();
        }
    }
}
