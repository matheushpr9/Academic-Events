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
                String eventId = rs.getString("eventId");
                String title = rs.getString("title");
                String[] authorsId = rs.getString("authorsId").split(",");
                int[] authorsIdArray = Arrays.stream(authorsId).mapToInt(Integer::parseInt).toArray();
                String summary = rs.getString("summary");
                String keywords = rs.getString("keywords");
                List<String> keywordsList = new ArrayList<String>(Arrays.asList(keywords.split(",")));
                String involveHumans = rs.getString("involveHumans");
                String processNumber = rs.getString("processNumber");
                String pdfFile = rs.getString("pdfFile");
                String subAreaId = rs.getString("subAreaId");
                String evaluation1Id = rs.getString("evaluation1Id");
                String evaluation2Id = rs.getString("evaluation2Id");
                String evaluation3Id = rs.getString("evaluation3Id");
                
                article = new Article(Integer.parseInt(id), Integer.parseInt(eventId), title, Arrays.stream(authorsIdArray).boxed().toArray(Integer[]::new), summary, keywordsList, Boolean.parseBoolean(involveHumans) , processNumber, pdfFile, Integer.parseInt(subAreaId),Integer.parseInt(evaluation1Id),Integer.parseInt(evaluation2Id),Integer.parseInt(evaluation3Id));
                
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
    
            String selectSQL = "SELECT * FROM Author"; 
    
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
    
            preparedStatement.setQueryTimeout(30); 
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String articleId = rs.getString("articleId");
                String eventId = rs.getString("eventId");
                String title = rs.getString("title");
                String[] authorsId = rs.getString("authorsId").split(",");
                int[] authorsIdArray = Arrays.stream(authorsId).mapToInt(Integer::parseInt).toArray();
                String summary = rs.getString("summary");
                String keywords = rs.getString("keywords");
                List<String> keywordsList = new ArrayList<String>(Arrays.asList(keywords.split(",")));
                String involveHumans = rs.getString("involveHumans");
                String processNumber = rs.getString("processNumber");
                String pdfFile = rs.getString("pdfFile");
                String subAreaId = rs.getString("subAreaId");
                String evaluation1Id = rs.getString("evaluation1Id");
                String evaluation2Id = rs.getString("evaluation2Id");
                String evaluation3Id = rs.getString("evaluation3Id");
                
                article = new Article(Integer.parseInt(articleId), Integer.parseInt(eventId) ,title, Arrays.stream(authorsIdArray).boxed().toArray(Integer[]::new), summary, keywordsList, Boolean.parseBoolean(involveHumans) , processNumber, pdfFile, Integer.parseInt(subAreaId),Integer.parseInt(evaluation1Id),Integer.parseInt(evaluation2Id),Integer.parseInt(evaluation3Id));
    
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
        Integer[] authorsId = article.getAuthorsId();
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
        
        String articleId = map.get("articleId");

        Article updatedArticle = this.get(articleId).stream().findFirst().get();

        Integer eventId = map.get("eventId") !=null ? Integer.parseInt(map.get("eventId")) : updatedArticle.getEventId();
        String title = map.get("title") !=null ? map.get("title") : updatedArticle.getTitle();
        String [] authorsIdStrings = map.get("authorsId").split(",");
        int[] authorsIdArray = Arrays.stream(authorsIdStrings).mapToInt(Integer::parseInt).toArray();
        Integer[] authorsId = map.get("authorsId") !=null ? Arrays.stream(authorsIdArray).boxed().toArray(Integer[]::new) : updatedArticle.getAuthorsId();
        String summary = map.get("summary") !=null ? map.get("summary") : updatedArticle.getSummary();
        List<String> keywords = map.get("keywords") !=null ? new ArrayList<String>(Arrays.asList(map.get("keywords").split(",")))  : updatedArticle.getKeywords();
        boolean involveHumans = map.get("involveHumans") !=null ? Boolean.parseBoolean(map.get("involveHumans")) : updatedArticle.isInvolveHumans();
        String processNumber = map.get("processNumber") !=null ? map.get("processNumber") : updatedArticle.getProcessNumber();
        String pdfFile = map.get("pdfFile") !=null ? map.get("pdfFile") : updatedArticle.getPdfFile();
        Integer subAreaId = map.get("subAreaId") !=null ? Integer.parseInt(map.get("subAreaId")) : updatedArticle.getSubAreaId();
        Integer evaluation1Id = map.get("evaluation1Id") !=null ? Integer.parseInt(map.get("evaluation1Id")) : updatedArticle.getEvaluation1Id();
        Integer evaluation2Id = map.get("evaluation2Id") !=null ? Integer.parseInt(map.get("evaluation2Id")) : updatedArticle.getEvaluation2Id();
        Integer evaluation3Id = map.get("evaluation3Id") !=null ? Integer.parseInt(map.get("evaluation3Id")) : updatedArticle.getEvaluation3Id();
    

        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("UPDATE Article SET articleId = "+ articleId +", eventId = "+eventId +", title = "+title+", authorsId = "+ authorsId.toString() +", summary = "+ summary +", keywords = "+ keywords+", involveHumans = "+ Boolean.toString(involveHumans)+", processNumber = "+ processNumber+", pdfFile = "+ pdfFile+", subAreaId = "+ subAreaId.toString()+", evaluation1Id = "+ evaluation1Id+", evaluation2Id = "+ evaluation2Id+", evaluation3Id = "+ evaluation3Id + " WHERE articleId = " + articleId + " WHERE articleId = "+articleId);
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

}