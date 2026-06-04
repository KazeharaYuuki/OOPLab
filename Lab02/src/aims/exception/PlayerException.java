package aims.exception; //

public class PlayerException extends Exception { // [cite: 1471]
    // Constructor không tham số
    public PlayerException() {
        super();
    }

    // Constructor nhận chuỗi thông báo lỗi cụ thể
    public PlayerException(String message) {
        super(message);
    }
}