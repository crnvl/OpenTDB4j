package Demo;

import Requests.OpenTDB;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] Args) throws LoginException {
        OpenTDB obj = new OpenTDB();
        obj.setCategory = 32;
        obj.setDifficulty = "easy";

        obj.getQuestion();

        System.out.println(obj.question);
        System.out.println(obj.correctAnswer);

        for (int i = 0; i < obj.incorrectAnswers.length ; i++) {
            System.out.println(obj.incorrectAnswers[i]);
        }

        System.out.println(obj.category);
        System.out.println(obj.difficulty);

    }
}
