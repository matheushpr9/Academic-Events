package controllers;

import classes.users.Author;

import classes.dao.AuthorDao;

public class LoginController {

    public boolean validateLogin(String document, String password){

        AuthorDao authorDao = new AuthorDao();

        Author author = authorDao.get(document).stream().findFirst().get();

        String databasePassword = author.getPassword().toString();

        if(password == databasePassword){
            return true;
        }
        return false;

    }

    public void createAccount(){

    }

    public void forgotMyPassword(){

    }
    
}