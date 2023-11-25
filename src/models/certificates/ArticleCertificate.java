package models.certificates;

import java.sql.Date;
import java.util.List;

public class ArticleCertificate extends BaseCertificate{
    private String articleTitle;
    private List<String> authors;

    public ArticleCertificate(String eventName, Date date, String text, String articleTitle, List<String> authors) {
        super(eventName, date, text);
        this.articleTitle = articleTitle;
        this.authors = authors;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    
    
}