package exceptions;

public class ArrayIsFull extends RuntimeException{
    public ArrayIsFull() {
    }

    public ArrayIsFull(String message) {
        super(message);
    }

    public ArrayIsFull(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayIsFull(Throwable cause) {
        super(cause);
    }

    public ArrayIsFull(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
