public class Main {
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
}