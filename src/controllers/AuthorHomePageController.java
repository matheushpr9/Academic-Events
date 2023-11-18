package controllers;

import java.util.List;
import classes.Article;
import classes.dao.ArticleDao;

public class AuthorHomePageController {

    public List<Article> listAuthors(String document){
        ArticleDao articleDao = new ArticleDao();
        return articleDao.getAll();
    }
}