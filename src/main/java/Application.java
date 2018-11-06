import model.Parser;
import model.Sentense;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {


        Parser parser=new Parser();
        String str=parser.getText();
        System.out.println(str);

        ArrayList<Sentense> sarr=parser.parseSentenses(parser.getText());
        for(Sentense s:sarr){
            System.out.println(s.getSentense());
        }
    }
}
