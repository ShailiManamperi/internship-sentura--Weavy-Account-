package lk.ijse.devop.user_mircoservice.exception;

public class SaveFailException extends Exception{
    public SaveFailException(String message){
        super(message);
    }

    public SaveFailException(String message,Throwable cause){
        super(message,cause);
    }
}
