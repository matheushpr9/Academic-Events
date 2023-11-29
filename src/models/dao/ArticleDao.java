package models.dao;

import java.util.List;
import java.util.Map;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import models.classes.Article;

//import classes.dao.DatabaseConnection;


public class ArticleDao implements Dao<Article>{

    private Connection con;

    public ArticleDao(){
        this.con = DatabaseConnection.getConnection();
    }

    @Override
    public Optional<Article> get(Object articleId){
        
        Article article = null;
        
        try{

            String selectSQL = "SELECT * FROM Article WHERE articleId = ?"; 

            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);

            preparedStatement.setString(1, articleId.toString());

            preparedStatement.setQueryTimeout(30); 
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String id = rs.getString("articleId");
                String eventId = rs.getString("academicEventId");
                String title = rs.getString("title");
                String[] authorsId = rs.getString("authorsId").split(",");
                String summary = rs.getString("summary");
                String keywords = rs.getString("keyword");
                List<String> keywordsList = new ArrayList<String>(Arrays.asList(keywords.split(",")));
                String involveHumans = rs.getString("involveHumans");
                String processNumber = rs.getString("processNumber");
                String pdfFile = rs.getString("pdfFile");
                String subAreaId = rs.getString("subAreaId");
                String evaluation1Id = rs.getString("evaluation1Id");
                String evaluation2Id = rs.getString("evaluation2Id");
                String evaluation3Id = rs.getString("evaluation3Id");
                
                article = new Article(  id !=null ? Integer.parseInt(id) : null, 
                                        eventId!=null ? Integer.parseInt(eventId):null, 
                                        title, 
                                        authorsId, 
                                        summary, 
                                        keywordsList, 
                                        Boolean.parseBoolean(involveHumans) , 
                                        processNumber, 
                                        pdfFile, 
                                        subAreaId!=null?Integer.parseInt(subAreaId):null,
                                        evaluation1Id!=null ? Integer.parseInt(evaluation1Id):null,
                                        evaluation2Id!=null ? Integer.parseInt(evaluation2Id):null,
                                        evaluation3Id!=null?Integer.parseInt(evaluation3Id):null
                                    );
            }

            preparedStatement.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(article);

    }


    @Override
    public List<Article> getAll(){
    
        List<Article> articles = new ArrayList<>();
        Article article = null;
            
         try{
    
            String selectSQL = "SELECT * FROM Article"; 
    
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
    
            preparedStatement.setQueryTimeout(30); 
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String articleId = rs.getString("articleId") != null ? rs.getString("articleId") : "0";
                String eventId = rs.getString("academicEventId") != null ? rs.getString("academicEventId") : "";
                String title = rs.getString("title") != null ? rs.getString("title") : "";
                String[] authorsId = rs.getString("authorsId").split(",");
                String summary = rs.getString("summary") != null ? rs.getString("summary") : "";
                String keywords = rs.getString("keyword") != null ? rs.getString("keyword") : "";
                List<String> keywordsList = new ArrayList<String>(Arrays.asList(keywords.split(",")));
                String involveHumans = rs.getString("involveHumans") != null ? rs.getString("involveHumans") : "";
                String processNumber = rs.getString("processNumber") != null ? rs.getString("processNumber") : "";
                String pdfFile = rs.getString("pdfFile") != null ? rs.getString("pdfFile") : "";
                String subAreaId = rs.getString("subAreaId") != null ? rs.getString("subAreaId") : "0";
                String evaluation1Id = rs.getString("evaluation1Id") != null ? evaluation1Id = rs.getString("evaluation1Id") : "0";
                String evaluation2Id = rs.getString("evaluation2Id") != null ? rs.getString("evaluation2Id") : "0";
                String evaluation3Id = rs.getString("evaluation3Id") != null ? rs.getString("evaluation3Id") : "0";
                
                article = new Article(Integer.parseInt(articleId), Integer.parseInt(eventId) ,title, authorsId, summary, keywordsList, Boolean.parseBoolean(involveHumans) , processNumber, pdfFile, Integer.parseInt(subAreaId),Integer.parseInt(evaluation1Id),Integer.parseInt(evaluation2Id),Integer.parseInt(evaluation3Id));
    
                articles.add(article);
                
            }
    
            preparedStatement.close();
    
    
        }catch(SQLException e){
            e.printStackTrace();
        }
    
        return articles;
    }

    @Override
    public void save(Article article){
        Integer articleId = article.getArticleId();
        Integer eventId = article.getEventId();
        String title = article.getTitle();
        String[] authorsId = article.getAuthorsId();
        String authorsIdString = authorsId != null ? authorsId.toString(): null;
        String summary = article.getSummary();
        List<String> keywords = article.getKeywords();
        Boolean involveHumansBool = article.isInvolveHumans();
        Integer involveHumans = involveHumansBool.toString()=="true"?1:0;
        String processNumber = article.getProcessNumber();
        String pdfFile = article.getPdfFile(); 
        Integer subAreaId = article.getSubAreaId();
        Integer evaluation1Id = article.getEvaluation1Id();
        Integer evaluation2Id = article.getEvaluation2Id();
        Integer evaluation3Id = article.getEvaluation3Id();
    
        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("INSERT INTO Article VALUES ("+ articleId +"," + eventId +",'" +title+"','"+ authorsIdString +"','"+ summary +"','"+ keywords.toString()+"',"+ involveHumans.toString() +",'"+ processNumber+"','"+ pdfFile+"',"+ subAreaId.toString()+","+ evaluation1Id+","+ evaluation2Id+","+ evaluation3Id + ")");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
        
    @Override
    public void update(Article article, Map<String, String> map){
        
        String articleId = article.getArticleId().toString();

        Article updatedArticle = this.get(articleId).stream().findFirst().get();

        Integer eventId = map.get("academicEventId") !=null ? Integer.parseInt(map.get("academicEventId")) : updatedArticle.getEventId();
        String title = map.get("title") !=null ? map.get("title") : updatedArticle.getTitle();
        String [] authorsIdStrings = map.get("authorsId")!=null ? map.get("authorsId").split(",") : updatedArticle.getAuthorsId();
        String summary = map.get("summary") != null ? map.get("summary") : updatedArticle.getSummary();
        List<String> keywords = map.get("keyword") !=null ? new ArrayList<String>(Arrays.asList(map.get("keyword").split(",")))  : updatedArticle.getKeywords();
        boolean involveHumans = map.get("involveHumans") !=null ? Boolean.parseBoolean(map.get("involveHumans")) : updatedArticle.isInvolveHumans();
        Integer involveHumansInteger = involveHumans == false?0:1;
        String processNumber = map.get("processNumber") !=null ? map.get("processNumber") : updatedArticle.getProcessNumber();
        String pdfFile = map.get("pdfFile") !=null ? map.get("pdfFile") : updatedArticle.getPdfFile();
        Integer subAreaId = map.get("subAreaId") !=null ? Integer.parseInt(map.get("subAreaId")) : updatedArticle.getSubAreaId();
        Integer evaluation1Id = map.get("evaluation1Id") != null ? Integer.parseInt(map.get("evaluation1Id")) : updatedArticle.getEvaluation1Id()!= null?updatedArticle.getEvaluation1Id():0;
        Integer evaluation2Id = map.get("evaluation2Id") != null ? Integer.parseInt(map.get("evaluation2Id")) : updatedArticle.getEvaluation2Id()!= null?updatedArticle.getEvaluation1Id():0;
        Integer evaluation3Id = map.get("evaluation3Id") != null ? Integer.parseInt(map.get("evaluation3Id")) : updatedArticle.getEvaluation3Id()!= null?updatedArticle.getEvaluation1Id():0;
    

        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("UPDATE Article SET academicEventId = "+ eventId +", title = '"+title+"', authorsId = '"+ authorsIdStrings.toString() +"', summary = '"+ summary +"', keyword = '"+ keywords.toString()+"', involveHumans = "+ involveHumansInteger +", processNumber = '"+ processNumber+"', pdfFile = '"+ pdfFile+"', subAreaId = "+ subAreaId.toString()+", evaluation1Id = "+ evaluation1Id+", evaluation2Id = "+ evaluation2Id+", evaluation3Id = "+ evaluation3Id + " WHERE articleId = " + articleId);
        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void delete(Article article){
        
        Integer articleId = article.getArticleId();
        
        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("DELETE FROM Article WHERE articleId = " + articleId.toString());
           
         
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Article getArticle(String eventIdC, String titleC, String summaryC){

        Article article = null;
        
        try{

            String selectSQL = "SELECT * FROM Article WHERE academicEventId = "+ eventIdC+ " AND title = '"+ titleC +"' AND summary = '"+ summaryC+"';"; 

            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
    
            preparedStatement.setQueryTimeout(30); 
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String id = rs.getString("articleId");
                String eventId = rs.getString("academicEventId");
                String title = rs.getString("title");
                String[] authorsId = rs.getString("authorsId").split(",");
                String summary = rs.getString("summary");
                String keywords = rs.getString("keyword");
                List<String> keywordsList = new ArrayList<String>(Arrays.asList(keywords.split(",")));
                String involveHumans = rs.getString("involveHumans");
                String processNumber = rs.getString("processNumber");
                String pdfFile = rs.getString("pdfFile");
                String subAreaId = rs.getString("subAreaId");
                String evaluation1Id = rs.getString("evaluation1Id");
                String evaluation2Id = rs.getString("evaluation2Id");
                String evaluation3Id = rs.getString("evaluation3Id");
                
                article = new Article(  id !=null ? Integer.parseInt(id) : null, 
                                        eventId!=null ? Integer.parseInt(eventId):null, 
                                        title, 
                                        authorsId, 
                                        summary, 
                                        keywordsList, 
                                        Boolean.parseBoolean(involveHumans) , 
                                        processNumber, 
                                        pdfFile, 
                                        subAreaId!=null?Integer.parseInt(subAreaId):null,
                                        evaluation1Id!=null ? Integer.parseInt(evaluation1Id):null,
                                        evaluation2Id!=null ? Integer.parseInt(evaluation2Id):null,
                                        evaluation3Id!=null?Integer.parseInt(evaluation3Id):null
                                    );
                
            }

            preparedStatement.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return article;


    }

    public List<Article> getArticlesByAuthorDocument(String document){
    
        List<Article> articles = new ArrayList<>();
        Article article = null;
            
         try{
    
            String selectSQL = "SELECT * FROM Article authorsId = '"+ document +"';"; 
    
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
    
            preparedStatement.setQueryTimeout(30); 
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String articleId = rs.getString("articleId") != null ? rs.getString("articleId") : "0";
                String eventId = rs.getString("academicEventId") != null ? rs.getString("academicEventId") : "";
                String title = rs.getString("title") != null ? rs.getString("title") : "";
                String[] authorsId = rs.getString("authorsId").split(",");
                String summary = rs.getString("summary") != null ? rs.getString("summary") : "";
                String keywords = rs.getString("keyword") != null ? rs.getString("keyword") : "";
                List<String> keywordsList = new ArrayList<String>(Arrays.asList(keywords.split(",")));
                String involveHumans = rs.getString("involveHumans") != null ? rs.getString("involveHumans") : "";
                String processNumber = rs.getString("processNumber") != null ? rs.getString("processNumber") : "";
                String pdfFile = rs.getString("pdfFile") != null ? rs.getString("pdfFile") : "";
                String subAreaId = rs.getString("subAreaId") != null ? rs.getString("subAreaId") : "0";
                String evaluation1Id = rs.getString("evaluation1Id") != null ? evaluation1Id = rs.getString("evaluation1Id") : "0";
                String evaluation2Id = rs.getString("evaluation2Id") != null ? rs.getString("evaluation2Id") : "0";
                String evaluation3Id = rs.getString("evaluation3Id") != null ? rs.getString("evaluation3Id") : "0";
                
                article = new Article(Integer.parseInt(articleId), Integer.parseInt(eventId) ,title, authorsId, summary, keywordsList, Boolean.parseBoolean(involveHumans) , processNumber, pdfFile, Integer.parseInt(subAreaId),Integer.parseInt(evaluation1Id),Integer.parseInt(evaluation2Id),Integer.parseInt(evaluation3Id));
    
                articles.add(article);
                
            }
    
            preparedStatement.close();
    
    
        }catch(SQLException e){
            e.printStackTrace();
        }
    
        return articles;
    }

}