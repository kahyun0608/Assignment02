public class BadException extends RuntimeException {
    public BadException() {
        super("오류가 발생하였습니다. 숫자를 다시 입력해주세요.");
    }
}