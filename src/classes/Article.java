package classes;

import java.util.List;
//import classes.Author;
//import classes.evaluation;
//import classes.SubArea;

class Article {
    private String uuid;
    private String title;
    private int authorsId;
    private String summary;
    private List<String> keywords;
    private boolean involveHumans;
    private String processNumber;
    private String pdfFile; 
    private int subAreaId;
    private Evaluation evaluation1;
    private Evaluation evaluation2;
    private Evaluation evaluation3; // can be null
    
    public Article(String uuid, String title, int authorsId, String summary, List<String> keywords,
            boolean involveHumans, String processNumber, String pdfFile, int subAreaId, Evaluation evaluation1,
            Evaluation evaluation2, Evaluation evaluation3) {
        this.uuid = uuid;
        this.title = title;
        this.authorsId = authorsId;
        this.summary = summary;
        this.keywords = keywords;
        this.involveHumans = involveHumans;
        this.processNumber = processNumber;
        this.pdfFile = pdfFile;
        this.subAreaId = subAreaId;
        this.evaluation1 = evaluation1;
        this.evaluation2 = evaluation2;
        this.evaluation3 = evaluation3;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(int authorsId) {
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

    public Evaluation getEvaluation1() {
        return evaluation1;
    }

    public void setEvaluation1(Evaluation evaluation1) {
        this.evaluation1 = evaluation1;
    }

    public Evaluation getEvaluation2() {
        return evaluation2;
    }

    public void setEvaluation2(Evaluation evaluation2) {
        this.evaluation2 = evaluation2;
    }

    public Evaluation getEvaluation3() {
        return evaluation3;
    }

    public void setEvaluation3(Evaluation evaluation3) {
        this.evaluation3 = evaluation3;
    }
    
    
    
}