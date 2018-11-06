package model;

public enum Mark {

    DOT("."),
    COMA(","),
    COLON(":"),
    SEMICOLON(";");


    private final String mark;

    Mark(String mark) {
        this.mark = mark;
    }

    public String getMark(){
        return this.mark;
    }
}
