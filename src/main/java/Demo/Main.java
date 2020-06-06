package Demo;

import Requests.OpenTDB;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] Args) throws LoginException {
        OpenTDB obj = new OpenTDB();
        obj.getCategory = 32;
        obj.getDifficulty = "easy";

        System.out.println(obj.getQuestion().question);
        System.out.println(obj.getQuestion().correctAnswer);

        for (int i = 0; i < obj.getQuestion().incorrectAnswers.length ; i++) {
            System.out.println(obj.getQuestion().incorrectAnswers[i]);
        }

        System.out.println(obj.getQuestion().category);
        System.out.println(obj.getQuestion().difficulty);

    }
}
