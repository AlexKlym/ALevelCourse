package com.alevel.qalist;

public class QAException extends Exception {
    QAException(Throwable cause) {
        super(cause);
    }

    public QAException(String s) {
        super(s);
    }
}
