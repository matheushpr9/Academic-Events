package classes;

public class Evaluation {
    private int articleId;
    private int revisorId;
    private String comment;
    private int grade;

    public Evaluation(int articleId, int revisorId, String comment, int grade) {
        this.articleId = articleId;
        this.revisorId = revisorId;
        this.comment = comment;
        this.grade = grade;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getRevisorId() {
        return revisorId;
    }

    public void setRevisorId(int revisorId) {
        this.revisorId = revisorId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    
    
}
