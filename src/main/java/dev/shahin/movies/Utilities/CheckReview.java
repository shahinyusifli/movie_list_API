package dev.shahin.movies.Utilities;

public class CheckReview implements ICheckReview{

    private String body;
    public CheckReview(String body) {
        this.body=body;
    }

    @Override
    public String dumyDetectTestReview() {
        if(body.equals("Test")) {
            return "It is test review";
        }
        return body;
    }
}
