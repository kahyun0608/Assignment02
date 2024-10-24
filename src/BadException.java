public class BadException extends RuntimeException {
    public BadException() {
        super("잘못된 입력값입니다. 다시 입력해주세요.");
    }
}