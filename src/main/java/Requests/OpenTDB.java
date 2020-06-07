package Requests;

import JSON.UrlReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class OpenTDB {

    public String getQuestion;
    public String getDifficulty;
    public String getCategory;
    public String[] getIncorrectAnswers = new String[3];
    public String getCorrectAnswer;
    public String getType;

    public Integer setCategory;
    public String setDifficulty;

    public OpenTDB getTrivia() {
        JSONObject json = null;

        StringBuilder args = new StringBuilder();

        try {

            if(setCategory != null) {
                args.append("&category=" + setCategory);
            }

            if(setDifficulty != null) {
                args.append("&difficulty=" + setDifficulty);
            }

            json = UrlReader.readJsonFromUrl("https://opentdb.com/api.php?amount=1&type=multiple" + args);

            JSONObject o = new JSONObject(json.toString());
            JSONArray results = o.getJSONArray("results");

            JSONObject getSimple = new JSONObject(results.get(0).toString());

            this.getQuestion = String.valueOf(getSimple.get("question"));
            this.getDifficulty = String.valueOf(getSimple.get("difficulty"));
            this.getCategory = String.valueOf(getSimple.get("category"));
            this.getCorrectAnswer = String.valueOf(getSimple.get("correct_answer"));
            this.getType = String.valueOf(getSimple.get("type"));

            JSONArray incorrectAnswers = getSimple.getJSONArray("incorrect_answers");

            for (int i = 0; i < incorrectAnswers.length(); i++) {
                this.getIncorrectAnswers[i] = String.valueOf(incorrectAnswers.get(i));
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return this;
    }

}
