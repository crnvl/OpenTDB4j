package Demo;

import Requests.Categories;
import Requests.OpenTDB;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] Args) {
        OpenTDB obj = new OpenTDB();
        obj.setCategory(Categories.ANY_CATEGORY);
        obj.setDifficulty("easy");

        obj.getTrivia();

        System.out.println("q: " + obj.getQuestion());
        System.out.println("c: " + obj.getCorrectAnswer());

        for (String s : obj.getIncorrectAnswers()) {
            System.out.println("f:" + s);
        }

        System.out.println("cat: " + obj.getCategory());
        System.out.println("dif: " + obj.getDifficulty());
        System.out.println("typ: " + obj.getType());
    }
}
