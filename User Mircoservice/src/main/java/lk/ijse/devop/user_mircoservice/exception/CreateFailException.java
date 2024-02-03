package lk.ijse.devop.user_mircoservice.exception;

public class CreateFailException extends Exception{

    public CreateFailException(String message, Throwable cause) {
        super(message+" :( "+ cause.getMessage(), cause);
    }

}
