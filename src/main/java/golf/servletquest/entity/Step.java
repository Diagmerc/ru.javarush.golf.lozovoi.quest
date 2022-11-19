package golf.servletquest.entity;

public class Step {
    private Integer id;

    private Integer nextId;

    private String answer;

    private String question;

    public Step(Integer current, String question) {
        this.id = current;
        this.nextId = -1;
        this.answer = null;
        this.question = question;
    }

    public Step(Integer current, Integer nextId, String answer, String question) {
        this.id = current;
        this.nextId = nextId;
        this.answer = answer;
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public int getId() {
        return id;
    }

    public int getNextId() {
        return nextId;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Step{" +
                "currentId=" + id +
                ", nextId=" + nextId +
                ", text='" + answer + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
