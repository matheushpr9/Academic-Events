package models.classes;

import java.util.List;

public class Article {
    private Integer articleId;
    private Integer eventId;
    private String title;
    private String[] authorsId;
    private String summary;
    private List<String> keywords;
    private boolean involveHumans;
    private String processNumber;
    private String pdfFile; 
    private Integer subAreaId;
    private Integer evaluation1Id;
    private Integer evaluation2Id;
    private Integer evaluation3Id; // can be null
    
    public Article( Integer eventId, String title,String[] authorsId, String summary, List<String> keywords, boolean involveHumans, String processNumber, String pdfFile, Integer subAreaId){
        
        this.eventId = eventId;
        this.title = title;
        this.authorsId = authorsId;
        this.summary = summary;
        this.keywords = keywords;
        this.involveHumans = involveHumans;
        this.processNumber = processNumber;
        this.pdfFile = pdfFile;
        this.subAreaId = subAreaId;
        this.evaluation1Id = null;
        this.evaluation2Id = null;
        this.evaluation3Id = null;
    }

    public Article(Integer articleId, Integer eventId, String title, String[] authorsId, String summary, List<String> keywords,
            boolean involveHumans, String processNumber, String pdfFile, int subAreaId) {
        this.articleId = articleId;
        this.eventId = eventId;
        this.title = title;
        this.authorsId = authorsId;
        this.summary = summary;
        this.keywords = keywords;
        this.involveHumans = involveHumans;
        this.processNumber = processNumber;
        this.pdfFile = pdfFile;
        this.subAreaId = subAreaId;
        this.evaluation1Id = null;
        this.evaluation2Id = null;
        this.evaluation3Id = null;
    }


    public Article(Integer articleId, Integer eventId, String title, String[] authorsId, String summary, List<String> keywords,
            boolean involveHumans, String processNumber, String pdfFile, int subAreaId, int evaluation1Id, int evaluation2, int evaluation3){
        this.articleId = articleId;
        this.eventId = eventId;
        this.title = title;
        this.authorsId = authorsId;
        this.summary = summary;
        this.keywords = keywords;
        this.involveHumans = involveHumans;
        this.processNumber = processNumber;
        this.pdfFile = pdfFile;
        this.subAreaId = subAreaId;
        this.evaluation1Id = evaluation1Id;
        this.evaluation2Id = evaluation2;
        this.evaluation3Id = evaluation3;
    }


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(String[] authorsId) {
        this.authorsId = authorsId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public boolean isInvolveHumans() {
        return involveHumans;
    }

    public void setInvolveHumans(boolean involveHumans) {
        this.involveHumans = involveHumans;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public String getPdfFile() {
        return pdfFile;
    }

    public void setPdfFile(String pdfFile) {
        this.pdfFile = pdfFile;
    }

    public int getSubAreaId() {
        return subAreaId;
    }

    public void setSubAreaId(int subAreaId) {
        this.subAreaId = subAreaId;
    }

    public Integer getEvaluation1Id() {
        return evaluation1Id;
    }

    public void setEvaluation1Id(Integer evaluation1Id) {
        this.evaluation1Id = evaluation1Id;
    }

    public Integer getEvaluation2Id() {
        return evaluation2Id;
    }

    public void setEvaluation2Id(Integer evaluation2) {
        this.evaluation2Id = evaluation2;
    }

    public Integer getEvaluation3Id() {
        return evaluation3Id;
    }

    public void setEvaluation3Id(Integer evaluation3) {
        this.evaluation3Id = evaluation3;
    }
    
    
    
}