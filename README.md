# ⚾️숫자 야구 게임⚾️
## 1. 구현 기능 
- 시작 메뉴 (게임시작/게임기록 확인/게임종료)
- 게임시작 시 난이도 조정 (맞출 숫자 자릿수 설정 가능 3/4/5)
- 게임 시작 시 난이도에 맞춰 랜덤한 자릿수의 숫자를 생성(중복X)
- 플레이어에게 숫자를 입력받아(중복X) 각 자리의 수가 생성된 랜덤숫자와 숫자와 자리가 일치하는지 비교하고 세 가지 결과로 분류 (strike, ball, out)
- 스트라이크가 3개면 플레이어가 정답을 맞추며 게임이 종료 되고 그렇지 않다면 스트라이크, 볼, 아웃의 개수를 힌트로 제시.
- 게임 한 라운드가 끝날 때마다 1의 시작메뉴가 반복적으로 제시됨.
- 라운드 별 입력 시도횟수가 저장되어 조회가능.
- 요구하는 조건에 맞지 않는 값(예외)을 입력시 예외처리(메세지 출력, 재입력 요구)

## 2. 기능 시연
<details>
<summary> ✨ 숫자 야구 게임 (난이도 3)</summary>
<div markdown="1">
  <br>
  오답->힌트 출력 <br><br>
<img src="https://github.com/user-attachments/assets/ac27876d-d410-492c-b85b-7c8cacce9536" width="500px">
  <br><br>
  정답 <br><br>
  <img src="https://github.com/user-attachments/assets/b95d2a02-ed5b-4bce-9e1c-51bc49d5d4f7" width="500px">
</div>
</details>
<details>
<summary> ✨ 예외 처리 (난이도4)</summary>
<div markdown="1">
  <br>
<img src="https://github.com/user-attachments/assets/2f470b62-9abf-4a2a-8d0c-8d9f7b95eced" width="500px">
</div>
</details>
<details>
<summary> ✨ 게임 기록 보기 / 게임 종료</summary>
<div markdown="1">
  <br>
<img src="https://github.com/user-attachments/assets/f284ea6a-d0cc-4b06-a6c3-5ae13f313218" width="500px">
</div>
</details>

## 3. 어려웠던 문제
- 입력한 숫자들이 입력순서가 아닌 숫자 크기 순으로 저장되어 비교하는 과정에서 잘못된 힌트들이 출력 => 중복검사를 위해 넣었던 `HashSet`를 `LinkedHashSet`로 변경. 

  ```java
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
  ```
- 예외처리 과정에서 예외처리가 되지 않았다는 오류 발생 => throw-throws문만 던지고 정작 예외를 처리해주지않아서 발생하였으므로 try-catch문으로 예외를 처리. 

  ```java
      public static void main(String[] args) {
        System.out.println("+:..* 숫자 야구 게임 *..:+");
        boolean gameWin = false;
        while (!gameWin) {
            try {
                gameWin = GameApp.start();
            } catch (BadException e) {
                System.out.println(e.getMessage());
            }
        }
    }
  ```

  ## 4. 개선사항
- 접근제어자를 public으로 통일하였으나 상황에 따라 접근제어를 설정할 수 있다.
 
  ## 5. 소감
    저번 과제는 필수 기능들만 구현했는데 이번에는 모든 도전 기능들을 완벽하진 않더라도 구현하는 데에 성공하였습니다.  
  또, 저번 과제에서는 예외처리 하는 방법을 잘 이해하지 못한 상태에서 진행했기때문에 모든 예외처리를 while문이나 if문으로 처리했는데 이번에는 예외처리도 시도해보았다는 의의를 가집니다. 

  다만 아쉬운 점은 접근제어를 언제 어떤식으로 써야할지 잘 몰라서 전부 public으로 만들었다는 점과 인터페이스나 추상메서드, 함수형 프로그래밍에 대한 이해도도 좀 떨어져서 이를 사용하지 못했습니다.  
  이런 것들을 사용했으면 복잡한 코드가 좀 더 단순화되고 잘 정리되었을까 싶어 아쉬움이 남습니다.  
  마지막으로, 콜렉션이나 예외처리 등 배운 개념들을 꼼꼼히 복습하여 코딩과정에서의 실수를 줄이도록 하겠습니다.
