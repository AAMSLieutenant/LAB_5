package controller;
import model.Parser;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Controller {


    private static final Logger log=Logger.getLogger(Parser.class);

    static{
        PropertyConfigurator.configure("log4j.properties");
    }

    public void view(){
        Parser p=new Parser();
        p.mainMethod();

    }
}
