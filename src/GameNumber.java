import java.util.*;

public class GameNumber {
    //필드
    //만들어지는 랜덤숫자를 저장
    HashSet<Integer> gameNumberSet;
    ArrayList<Integer> gameNumberList;

    //플레이어가 입력한 숫자를 저장
    ArrayList<Integer> inputNumberList;

    //시도횟수를 저장
    int tryNumber = 0;

    //난이도
    int difficulty;


    //메서드
    //답이 될 숫자 생성하기
    public Set<Integer> makeGameNumber(int difficulty) {
        Random random = new Random();
        HashSet<Integer> gameNumbers = new LinkedHashSet<Integer>();
        while (gameNumbers.size() < difficulty) {
            gameNumbers.add(random.nextInt(9) + 1);
        }
        this.gameNumberSet = gameNumbers;
        this.gameNumberList = new ArrayList<>(gameNumbers);
        return gameNumberSet;
    }

    //입력값을 필드에 지정하기
    public void settingInput(String InputNumbers) throws BadException {
        HashSet<Integer> checkingSet = new LinkedHashSet<Integer>();

        for(int i = 0 ; i<difficulty ; i++){
            checkingSet.add(Character.getNumericValue(InputNumbers.charAt(i)));
        }

        while (checkingSet.size() != difficulty) {
            throw new BadException();
        }
        this.inputNumberList = new ArrayList<>(checkingSet);
    }

    //입력한 숫자가 포함되어있는지 확인 (아닐시 out)
    public boolean checkNumbers() {
        ArrayList<String> score = new ArrayList<String>();
        for (int i = 0; i < difficulty; i++) {
            if (!this.gameNumberList.contains(this.inputNumberList.get(i))) {
                score.add("out");
            } else if (this.inputNumberList.get(i) == this.gameNumberList.get(i)) {
                score.add("strike");
            } else {
                score.add("ball");
            }
        }
        // 입력값에 대한 결과 출력
        if (Collections.frequency(score, "strike") == difficulty) {
            System.out.println("✿｡ﾟฺ.* ૢ°₊·*:❀정답입니다!❀°₊·ˈ‧₊°ෆೄ*｡✿");
            return true;
        } else {
            PrintScore.printScore(score, "strike");
            PrintScore.printScore(score, "ball");
            PrintScore.printScore(score, "out");
            System.out.println();
            return false;
        }
    }
}
