package model;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Parser {

    private String text;
    private ArrayList<Sentense> sentenses;

    public Parser(){
        text=new String();
    }

    public String getText(){
        try {
            FileInputStream fis = new FileInputStream("File.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
            do{
                text+=br.readLine();
            }while(br.readLine()!=null);
            br.close();
            text=text.replace(",","");
            text=text.replace(":","");
            text=text.replace(";","");


            return text;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Sentense> parseSentenses(String text){
        ArrayList<Sentense> arr=new ArrayList<Sentense>();
        StringTokenizer stk=new StringTokenizer(text);
        String currentParser=Mark.DOT.getMark();
        String s=new String();
        while(stk.hasMoreTokens()){
            s=stk.nextToken(currentParser);
//            System.out.println("Clean string:"+s);
            Sentense sen=new Sentense(s);
//            System.out.println("Sentense from object:"+sen.getSentense());
            arr.add(sen);
        }
        for(int i=0;i<arr.size();i++){
           System.out.println("Sentense "+i+" "+arr.get(i).getSentense());
        }
        arr.remove(20);
        return arr;
    }

    public void parseWords(ArrayList<Sentense> sentenses){
        StringTokenizer stk;
        String currentParser=Mark.SPACE.getMark();
        String s=new String();
        System.out.println(sentenses.size());
        for(int i=0;i<sentenses.size();i++){
            stk=new StringTokenizer(sentenses.get(i).getSentense());
            System.out.println("---------------------------------");
            System.out.println(sentenses.get(i).getSentense());
            while(stk.hasMoreTokens()){
                s=stk.nextToken(currentParser);
                Word w=new Word(s);
                sentenses.get(i).getWords().add(w);
            }
            for(int j=0;j<sentenses.get(i).getWords().size();j++){
                System.out.println(sentenses.get(i).getWords().get(j).getWord());
            }
            System.out.println("---------------------------------");
        }
    }


    public void count(Word word){
        String s=word.getWord();
        String container="aeiouyуеэоаыяиюіїєAEIOUYУЕЭОАЫЯИЮІЇЄ";
        double length=word.getWord().length();
        word.setLength(length);
        double vovels=0;
        for(int i=0;i<s.length();i++){
            if(container.contains(String.valueOf(s.charAt(i)))){
                vovels++;
            }
        }
        //System.out.println(all);
        //System.out.println(vovels);
        word.setVovels(vovels);
        double percent=vovels/length;
        word.setPercentage(percent);
        System.out.println(percent);

    }


    public void countPersentage(ArrayList<Sentense> sarr){
        ArrayList<Word> words=new ArrayList<Word>();
        for(int i=0;i<sarr.size();i++){
            for(int j=0;j<sarr.get(i).getWords().size();j++){
                words.add(sarr.get(i).getWords().get(j));
            }
        }
        System.out.println(words.size());
        for(int i=0;i<words.size();i++){
            count(words.get(i));
        }

        Collections.sort(words, new Comparator<Word>() {
            public int compare(Word w1, Word w2) {
                if((w1.getPercentage()>w2.getPercentage())){
                    return 1;
                }
                if((w1.getPercentage()<w2.getPercentage())){
                    return -1;
                }
                return 0;
            }
        });
        for(int i=0;i<words.size();i++){
            System.out.println(words.get(i).getWord());
        }
//        Map<Double,String> map=new TreeMap<Double,String>();
//        System.out.println("--------------------");
//        for(int i=0;i<sarr.size();i++){
//            System.out.println("--------------------");
//            System.out.println("Sentence number "+i);
//            for(int j=0;j<sarr.get(i).getWords().size();j++){
//                Word curWord=sarr.get(i).getWords().get(j);
//                map.put(count(curWord),curWord.getWord());
//                System.out.println("word number "+j);
//                System.out.println(curWord.getWord());
//            }
//        }

//        for(Map.Entry entry:map.entrySet()){
//            System.out.println(entry.getKey()+","+entry.getValue());
//        }
//        System.out.println("Size of the map "+map.size());
    }

}
