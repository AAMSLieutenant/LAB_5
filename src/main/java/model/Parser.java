package model;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

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


    public double count(Word word){
        String s=word.getWord();
        String container="aeiouyуеэоаыяиюіїєAEIOUYУЕЭОАЫЯИЮІЇЄ";
        double all=word.getWord().length();
        double vovels=0;
        for(int i=0;i<s.length();i++){
            if(container.contains(String.valueOf(s.charAt(i)))){
                vovels++;
            }
        }
        System.out.println(all);
        System.out.println(vovels);
        double percent=vovels/all;
        System.out.println(percent);
        return percent;
    }


    public void countPersentage(ArrayList<Sentense> sarr){
        Map<Double,String> map=new HashMap<Double,String>();
        System.out.println("--------------------");
        for(int i=0;i<sarr.size();i++){
            System.out.println("--------------------");
            for(int j=0;j<sarr.get(i).getWords().size();j++){
                Word curWord=sarr.get(i).getWords().get(j);
                map.put(count(curWord),curWord.getWord());
                System.out.println(curWord.getWord());
            }
        }
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }

}
