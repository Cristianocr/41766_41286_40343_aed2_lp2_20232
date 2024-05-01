package edu.ufp.inf.lp2._p04_bank;

public class IllicitDepositException extends Exception{
    public IllicitDepositException() {
    }

    public IllicitDepositException(String message) {
        super(message);
    }

    public IllicitDepositException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllicitDepositException(Throwable cause) {
        super(cause);
    }

    public IllicitDepositException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
