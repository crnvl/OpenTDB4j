package Requests;

import JSON.UrlReader;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * The OpenTDB is an OpenTDB API wrapper.
 * <p>First, configure the settings for the trivia using the {@link #setDifficulty(String)} and the {@link #setDifficulty(String)} method</p>
 * <p>Then, get the trivia using the {@link #getTrivia()} method</p>
 * <p>Lastly, get the content of the trivia using the {@link #getQuestion()}, {@link #getCorrectAnswer()}, {@link #getIncorrectAnswers()},
 * {@link #getCategory()}, {@link #getDifficulty()} methods</p>
 */
public class OpenTDB {

    public String question;
    public String difficulty;
    public String category;
    public String[] incorrectAnswers = new String[3];
    public String correctAnswer;
    public String type;

    int categorySet = 0;
    String difficultySet;


    /**
     * Set the category of the next question
     * @param value The category, must be 0 or 9 to 32
     */
    public void setCategory(int value) {
        categorySet = value;
    }

    /**
     * Set the difficulty of the next question
     * @param s Can be "easy", "medium", "hard"
     */
    public void setDifficulty(String s) {
        difficultySet = s;
    }

    /**
     * Get the question
     * @return The question as a String
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Get the difficulty of the question
     * @return The difficulty ("easy", "medium" or "hard")
     */
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * Get the category
     * @return The category as a String
     */
    public String getCategory() {
        return category;
    }

    /**
     * Get the 3 incorrect answers
     * @return The incorrect answers
     */
    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }

    /**
     * Get the correct answer
     * @return The correct answer
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Get the type of the question
     * @return The type ("multiple", "boolean")
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the trivia question form the OpenTDB API
     * Get the different values using the corresponding getters
     * @return This object
     */
    public OpenTDB getTrivia() {
        JSONObject json;

        StringBuilder args = new StringBuilder();

        try {

            if(categorySet != 0) {
                args.append("&category=").append(categorySet);
            }

            if(difficultySet != null) {
                args.append("&difficulty=").append(difficultySet);
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
