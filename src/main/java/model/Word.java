package model;

public class Word {

    private String word;
    private char[] letters;
    private double length;
    private double vovels;
    private double percentage;

    public char[] getLetters() {
        return letters;
    }

    public void setLetters(char[] letters) {
        this.letters = letters;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getVovels() {
        return vovels;
    }

    public void setVovels(double vovels) {
        this.vovels = vovels;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }




    public Word(String word){
        this.word=word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }





}
