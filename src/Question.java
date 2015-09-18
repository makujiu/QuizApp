/**
 *@author Martin Nowosad
 */
public class Question {
    private String question;
    private String answer;

    //Used to advanced question-mode (specific algorithm to practice hard questions)
    // hard = 1, easy = 0, -1 = not defined;
    private int hard = -1;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getHard() {
        return hard;
    }

    public void setHard(int hard) {
        this.hard = hard;
    }
}
