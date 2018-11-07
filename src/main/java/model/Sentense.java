package model;

import java.util.ArrayList;

public class Sentense {

    private String sentense;
    private ArrayList<Word> words;


    public Sentense(String sentense){
//        sentense=new String();
        words=new ArrayList<Word>();
        this.sentense=sentense;
    }

    public String getSentense() {
        return this.sentense;
    }

    public void setSentense(String sentense) {
        this.sentense = sentense;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }











}
