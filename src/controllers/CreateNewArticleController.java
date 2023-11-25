package controllers;
import java.util.ArrayList;
import java.util.List;
import classes.AcademicEvent;
import classes.dao.AcademicEventDao;
import classes.Article;
import classes.SubArea;
import classes.dao.ArticleDao;
import classes.dao.SubAreaDao;
import classes.users.Author;
import classes.dao.AuthorDao;

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

    public static void sendFirstForm( Integer eventId, String title, Integer[] authorsId,String summary, List<String> keywords, boolean involveHumans, String processNumber, String pdfFile, Integer subAreaId){
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
     
}
