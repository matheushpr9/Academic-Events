package controllers;

import java.util.List;

import models.classes.Article;
import models.dao.ArticleDao;

public class AuthorHomePageController {

    public List<Article> listAuthors(String document){
        ArticleDao articleDao = new ArticleDao();
        return articleDao.getAll();
    }
}