package entity;

/**
 * A simple implementation of the User interface.
 */
public class Request {
    private String name;
    private double scores;
    private Boolean status;

    public Request(String name, double scores, Boolean status) {
        this.name = name;
        this.scores = scores;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public double getScores() {
        return scores;
    }

    public Boolean getStatus() {
        return status;
    }
}
