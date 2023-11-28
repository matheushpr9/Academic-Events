package models.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import models.users.Author;

public class AuthorDao implements Dao<Author>{
    
    private Connection con;

    public AuthorDao(){
        con = DatabaseConnection.getConnection();
    }

    @Override
    public Optional<Author> get(Object authorDocument){
        Author author  = null;
        try{

            String selectSQL = "SELECT * FROM Author WHERE authorDocument = ?"; 

            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);

            preparedStatement.setString(1, authorDocument.toString());
            
            preparedStatement.setQueryTimeout(30); 
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String document = rs.getString("authorDocument");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                
                author  = new Author(name, email, password, phone, document);
                
            }
            preparedStatement.close();
        }catch( SQLException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(author);
    }

    @Override
    public List<Author> getAll(){
        List<Author> authors = new ArrayList<>();
        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            ResultSet rs = statement.executeQuery("SELECT * FROM author");
            Author author = null;
            while(rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String document = rs.getString("authorDocument");
                author  = new Author(name, email, password, phone, document);
                authors.add(author);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return authors;
            
    }

    @Override
    //public void save(String document, String name, String email, String password, String phone ){
    public void save(Author author){
        String document = author.getAuthorDocument();
        String name = author.getName();
        String email = author.getEmail();
        String password = author.getPassword();
        String phone = author.getPhone();

        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("INSERT INTO Author VALUES ("+ document +", "+name+", "+ email +", "+ password +", "+ phone);
           
         
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    @Override
    public void update(Author author, Map<String, String> map){

        String authorDocument = map.get("authorDocument");
        Author updatedAuthor = this.get(authorDocument).stream().findFirst().get();

        String name = map.get("name") != null ? map.get("name") : updatedAuthor.getName();
        String email = map.get("email") != null ? map.get("email") : updatedAuthor.getEmail();
        String password = map.get("password") != null ? map.get("password") : updatedAuthor.getPassword();
        String phone = map.get("phone") != null ? map.get("phone") : updatedAuthor.getPhone();
        

        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("UPDATE Author SET authorDocument = "+authorDocument+",name = "+name+",email = "+ email +", password = "+ password +", phone = "+ phone + " WHERE authorDocument = "+authorDocument);
           
         
        }catch(SQLException e){
            e.printStackTrace();
        }
        

    }

    @Override
    public void delete(Author author){

        String authorDocument = author.getAuthorDocument();

        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("DELETE FROM Author WHERE authorDocument = " + authorDocument);
           
         
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }

}
