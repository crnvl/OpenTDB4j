package Demo;

import Requests.OpenTDB;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] Args) throws LoginException {
        OpenTDB obj = new OpenTDB();
        obj.setCategory(29);
        obj.setDifficulty("easy");

        obj.getTrivia();

        System.out.println(obj.getQuestion());
        System.out.println(obj.getCorrectAnswer());

        String[] incorrectAnswers = obj.getIncorrectAnswers();
        for (int i = 0; i < obj.incorrectAnswers.length ; i++) {
            System.out.println(obj.incorrectAnswers[i]);
        }

        System.out.println(obj.getCategory());
        System.out.println(obj.getDifficulty());
        System.out.println(obj.getType());

    }
}
