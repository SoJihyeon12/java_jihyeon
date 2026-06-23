package ch01;

public class LoginFailException extends Exception{
    public LoginFailException(String message) {
        super(message);
    }
}