package controllers;

import java.util.List;
import models.classes.Article;
import models.dao.ArticleDao;

public class RevisorHomePageController {
    public static List<Article> getAllArticle(){
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.getAll();
        
        return articles;
    }

    public static List<Article> getAllArticleByAuthorDocument(String document){
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.getAll();
        
        return articles;
    }

}
