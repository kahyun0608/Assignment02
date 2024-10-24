public class Main extends BaseballGame {
    public static void main(String[] args) {
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