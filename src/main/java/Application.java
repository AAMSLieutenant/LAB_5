import controller.Controller;
import model.Parser;
import model.Sentense;
import model.Word;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {

        Controller controller=new Controller();
        controller.view();

//        Parser parser=new Parser();
//        String str=parser.getText();
//        System.out.println(str);
//
//        ArrayList<Sentense> sarr=parser.parseSentenses(parser.getText());
//        for(Sentense s:sarr){
//            System.out.println(s.getSentense());
//        }
//        parser.parseWords(sarr);
//        parser.count(new Word("Hello"));
//        parser.countPersentage(sarr);
//        for(int i=0;i<sarr.size();i++){
//            System.out.println("---------------------------------");
//            for(int j=0;j<sarr.get(i).getWords().size();i++){
//                System.out.println(sarr.get(i).getWords().get(j).getWord());
//            }
//            System.out.println("---------------------------------");
//        }

    }
}
