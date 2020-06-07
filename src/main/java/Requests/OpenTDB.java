package Requests;

import JSON.UrlReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class OpenTDB {

    public String question;
    public String difficulty;
    public String category;
    public String[] incorrectAnswers = new String[3];
    public String correctAnswer;
    public String type;

    int categorySet = 0;
    String difficultySet;

    public void setCategory(int value) {
        categorySet = value;
    }

    public void setDifficulty(String s) {
        difficultySet = s;
    }

    public String getQuestion() {
        return question;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getCategory() {
        return category;
    }

    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getType() {
        return type;
    }

    public OpenTDB getTrivia() {
        JSONObject json = null;

        StringBuilder args = new StringBuilder();

        try {

            if(categorySet != 0) {
                args.append("&category=" + categorySet);
            }

            if(difficultySet != null) {
                args.append("&difficulty=" + difficultySet);
            }

            json = UrlReader.readJsonFromUrl("https://opentdb.com/api.php?amount=1&type=multiple" + args);

            JSONObject o = new JSONObject(json.toString());
            JSONArray results = o.getJSONArray("results");

            JSONObject getSimple = new JSONObject(results.get(0).toString());

            this.question = String.valueOf(getSimple.get("question"));
            this.difficulty = String.valueOf(getSimple.get("difficulty"));
            this.category = String.valueOf(getSimple.get("category"));
            this.correctAnswer = String.valueOf(getSimple.get("correct_answer"));
            this.type = String.valueOf(getSimple.get("type"));

            JSONArray incorrectAnswersList = getSimple.getJSONArray("incorrect_answers");

            for (int i = 0; i < incorrectAnswersList.length(); i++) {
                this.incorrectAnswers[i] = String.valueOf(incorrectAnswersList.get(i));
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return this;
    }

}
