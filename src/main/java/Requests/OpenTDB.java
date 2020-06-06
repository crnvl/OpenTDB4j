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

    public Integer getCategory;
    public String getDifficulty;

    public OpenTDB getQuestion() {
        JSONObject json = null;

        StringBuilder args = new StringBuilder();

        try {

            if(getCategory != null) {
                args.append("&category=" + getCategory);
            }

            if(getDifficulty != null) {
                args.append("&difficulty=" + getDifficulty);
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

            JSONArray incorrectAnswers = getSimple.getJSONArray("incorrect_answers");

            for (int i = 0; i < incorrectAnswers.length(); i++) {
                this.incorrectAnswers[i] = String.valueOf(incorrectAnswers.get(i));
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return this;
    }

}
