package controllers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.classes.AcademicEvent;
import models.classes.Article;
import models.classes.SubArea;
import models.dao.AcademicEventDao;
import models.dao.ArticleDao;
import models.dao.AuthorDao;
import models.dao.SubAreaDao;
import models.users.Author;

public class CreateNewArticleController {

    public static List<AcademicEvent> listEvents(){
        AcademicEventDao academicEventDao = new AcademicEventDao();
        return academicEventDao.getAll();
    }

    public static List<String> listEventsToDropDown(){
        
        List<AcademicEvent> academicEvents = listEvents();

        List<String> listedEventsToDropDown = new ArrayList<String>();

        for(int i=0; i<academicEvents.size(); i++){
            AcademicEvent academicEvent = academicEvents.get(i); 
            Integer academicEventId = academicEvent.getAcademicEventId();
            String name = academicEvent.getName();

            listedEventsToDropDown.add(academicEventId.toString() + " - " +name);
        }

        return listedEventsToDropDown;

    }

    public static List<SubArea> listSubareas(){
        SubAreaDao subAreaDao = new SubAreaDao();
        return subAreaDao.getAll();
    }

    public static List<String> listSubareasToDropDown(){
        
        List<SubArea> subAreas = listSubareas();

        List<String> listedSubareasToDropDown = new ArrayList<String>();

        for(int i=0; i<subAreas.size(); i++){
            SubArea subArea = subAreas.get(i); 
            Integer subAreaId = subArea.getId();
            String title = subArea.getTitle();

            listedSubareasToDropDown.add(subAreaId.toString() + " - " +title);
        }

        return listedSubareasToDropDown;

    }

    public static void sendFirstForm( Integer eventId, String title, String[] authorsId,String summary, List<String> keywords, boolean involveHumans, String processNumber, String pdfFile, Integer subAreaId){
        Article article = new Article(  eventId,  title, authorsId, summary, keywords, involveHumans, processNumber, pdfFile, subAreaId);
        ArticleDao articleDao = new ArticleDao();
        articleDao.save(article);
    }

    public static List<Author> listAllAuthors(){
        AuthorDao authorDao = new AuthorDao();
        return authorDao.getAll();
    }

    public static List<String> listAllAuthorsToDropDown(){
        
        List<Author> authors = listAllAuthors();

        List<String> listedAuthorsToDropdown = new ArrayList<String>();

        for(int i=0; i<authors.size(); i++){
            Author author = authors.get(i); 
            String authorName = author.getName();
            String authorDocument = author.getAuthorDocument();

            listedAuthorsToDropdown.add(authorName + " - " +authorDocument);
        }

        return listedAuthorsToDropdown;

    }

    public static Article getArticle(String eventId, String title, String summary){
        ArticleDao articleDao = new ArticleDao();

        Article article = articleDao.getArticle( eventId, title, summary);

        return article;
    }
    

    public static void sendSecondForm(Article article){
        ArticleDao articleDao = new ArticleDao();

        Map<String, String> articleMapOne;

        articleMapOne = new HashMap<>();


        articleDao.update(article,articleMapOne);
    }
     
}
