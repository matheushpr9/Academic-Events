package classes.dao;

import classes.Article;

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

            String selectSQL = "SELECT * FROM Author WHERE articleId = ?"; 

            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);

            preparedStatement.setString(1, articleId.toString());

            preparedStatement.setQueryTimeout(30); 
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String id = rs.getString("articleId");
                String title = rs.getString("title");
                String authorsId = rs.getString("authorsId");
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
                
                article = new Article(id, title, Integer.parseInt(authorsId), summary, keywordsList, Boolean.parseBoolean(involveHumans) , processNumber, pdfFile, Integer.parseInt(subAreaId),Integer.parseInt(evaluation1Id),Integer.parseInt(evaluation2Id),Integer.parseInt(evaluation3Id));
                
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
                String title = rs.getString("title");
                String authorsId = rs.getString("authorsId");
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
                
                article = new Article(articleId, title, Integer.parseInt(authorsId), summary, keywordsList, Boolean.parseBoolean(involveHumans) , processNumber, pdfFile, Integer.parseInt(subAreaId),Integer.parseInt(evaluation1Id),Integer.parseInt(evaluation2Id),Integer.parseInt(evaluation3Id));
    
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
        String articleId = article.getArticleId();
        String title = article.getTitle();
        int authorsId = article.getAuthorsId();
        String summary = article.getSummary();
        List<String> keywords = article.getKeywords();
        boolean involveHumans = article.isInvolveHumans();
        String processNumber = article.getProcessNumber();
        String pdfFile = article.getPdfFile(); 
        Integer subAreaId = article.getSubAreaId();
        Integer evaluation1Id = article.getEvaluation1Id();
        Integer evaluation2Id = article.getEvaluation2Id();
        Integer evaluation3Id = article.getEvaluation3Id();
    
        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("INSERT INTO Article VALUES ("+ articleId +", "+title+", "+ authorsId +", "+ summary +", "+ keywords+", "+ Boolean.toString(involveHumans)+", "+ processNumber+", "+ pdfFile+", "+ subAreaId.toString()+", "+ evaluation1Id+", "+ evaluation2Id+", "+ evaluation3Id + ")");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
        
    @Override
    public void update(Article article, Map<String, String> map){
        
        String articleId = map.get("articleId");

        Article updatedArticle = this.get(articleId).stream().findFirst().get();

        String title = map.get("title") !=null ? map.get("title") : updatedArticle.getTitle();
        int authorsId = map.get("authorsId") !=null ? Integer.parseInt(map.get("authorsId")) : updatedArticle.getAuthorsId();
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
            statement.executeUpdate("UPDATE Article SET articleId = "+ articleId +", title = "+title+", authorsId = "+ authorsId +", summary = "+ summary +", keywords = "+ keywords+", involveHumans = "+ Boolean.toString(involveHumans)+", processNumber = "+ processNumber+", pdfFile = "+ pdfFile+", subAreaId = "+ subAreaId.toString()+", evaluation1Id = "+ evaluation1Id+", evaluation2Id = "+ evaluation2Id+", evaluation3Id = "+ evaluation3Id);
        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void delete(Article article){
        
        String articleId = article.getArticleId();
        
        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("DELETE FROM Article WHERE articleId = " + articleId);
           
         
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}