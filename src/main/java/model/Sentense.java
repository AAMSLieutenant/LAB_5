package model;

public class Sentense {

    private Word[] words;

    public String getSentense() {
        return sentense;
    }

    public void setSentense(String sentense) {
        this.sentense = sentense;
    }

    private String sentense;

    public Sentense(String sentense){
        this.sentense=sentense;
    }

}
