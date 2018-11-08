package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseSentenses() {

        String text="Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово, Предложение, Знак препинания и др." +
                "Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом. " +
                "Найти наибольшее количество предложений текста, в которых есть одинаковые слова. " +
                "Вывести все предложения заданного текста в порядке возрастания " +
                "количества слов в каждом из них.";
        Parser p=new Parser();
//        p.parseSentenses(text);

//        ArrayList<Sentense> expArr=new ArrayList<Sentense>();
//        expArr.add(new Sentense("Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово, Предложение, Знак препинания и др."));
//        expArr.add(new Sentense("Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом."));
//        expArr.add(new Sentense("Найти наибольшее количество предложений текста, в которых есть одинаковые слова."));
//        expArr.add(new Sentense("Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них."));

        ArrayList<String> expArr=new ArrayList<String>();
        expArr.add("Создать программу обработки текста учебника по программированию с использованием классов: Символ, Слово, Предложение, Знак препинания и др");
        expArr.add("Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом");
        expArr.add("Найти наибольшее количество предложений текста, в которых есть одинаковые слова");
        expArr.add("Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них");
        ArrayList<Sentense> sarr=p.parseSentenses(text);
        ArrayList<String> resArr=new ArrayList<String>();
        for(int i=0;i<sarr.size();i++){
            resArr.add(sarr.get(i).getSentense());
        }
        assertEquals(expArr,resArr);
    }

    @Test
    void parseWords() {

        ArrayList<Sentense> expArr=new ArrayList<Sentense>();
        expArr.add(new Sentense("Во всех задачах с формированием текста заменять табуляции и последовательности пробелов одним пробелом"));
        ArrayList<String> words=new ArrayList<String>();
        words.add("Во");
        words.add("всех");
        words.add("задачах");
        words.add("с");
        words.add("формированием");
        words.add("текста");
        words.add("заменять");
        words.add("табуляции");
        words.add("и");
        words.add("последовательности");
        words.add("пробелов");
        words.add("одним");
        words.add("пробелом");
        Parser p=new Parser();
        p.parseWords(expArr);
        ArrayList<String> exp=new ArrayList<String>();
        for(int i=0;i<expArr.get(0).getWords().size();i++){
            exp.add(expArr.get(0).getWords().get(i).getWord());
        }
        assertEquals(words,exp);

    }
}