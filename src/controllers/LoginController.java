package controllers;

import models.dao.AuthorDao;
import models.users.Author;
import models.users.Revisor;
import models.dao.RevisorDao;

class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) {
        super(message);
    }
}

public class LoginController {

    public boolean validateLoginAuthor(String document, String password) {
        Author author = null;
        AuthorDao authorDao = new AuthorDao();
        
        try {
            author = authorDao.get(document).stream().findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (author != null) {
            String databasePassword = author.getPassword().toString();
            if (password.equals(databasePassword)) {
                return true;
            }
        }

        return false;
    }

    public boolean validateLoginRevisor(String document, String password) {
        Revisor revisor = null;
        RevisorDao revisorDao = new RevisorDao();
        
        try {
            revisor = revisorDao.get(document).stream().findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (revisor != null) {
            String databasePassword = revisor.getPassword().toString();
            if (password.equals(databasePassword)) {
                return true;
            }
        }

        return false;
    }

    public void createAccount() {
    }

    public void forgotMyPassword() {
    }

    public boolean validateLoginAuthorWithException(String document, String password) throws InvalidLoginException {
        Author author = null;
        AuthorDao authorDao = new AuthorDao();
        
        try {
            author = authorDao.get(document).stream().findFirst().get();
        } catch (Exception e) {
            throw new InvalidLoginException("Error validating author's login");
        }

        if (author != null) {
            String databasePassword = author.getPassword().toString();
            if (password.equals(databasePassword)) {
                return true;
            }
        }

        return false;
    }

    public boolean validateLoginRevisorWithException(String document, String password) throws InvalidLoginException {
        Revisor revisor = null;
        RevisorDao revisorDao = new RevisorDao();
        
        try {
            revisor = revisorDao.get(document).stream().findFirst().get();
        } catch (Exception e) {
            throw new InvalidLoginException("Error validating reviewer login");
        }

        if (revisor != null) {
            String databasePassword = revisor.getPassword().toString();
            if (password.equals(databasePassword)) {
                return true;
            }
        }

        return false;
    }
}
