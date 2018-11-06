package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
            arr.add(new Sentense(s));
        }
        return arr;
    }

}
