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
import models.users.Revisor;

public class RevisorDao implements Dao<Revisor>{
    
    private Connection con;

    public RevisorDao(){
        con = DatabaseConnection.getConnection();
    }

    @Override
    public Optional<Revisor> get(Object revisorDocument){
        Revisor revisor = null;
        try{
            String selectString = "SELECT * FROM Revisor WHERE document = '" + revisorDocument.toString() + "';";
        
            PreparedStatement preparedStatement = con.prepareStatement(selectString);
            preparedStatement.setQueryTimeout(30);

            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String document = rs.getString("document");
                String lattes = rs.getString("lattes");
                String workingInstitution = rs.getString("workingInstitution");
                String researchId = rs.getString("researchId");
                
                revisor = new Revisor(name, email, password, phone, document, lattes, workingInstitution, researchId);
                
            }
            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(revisor);
    }

    @Override
    public List<Revisor> getAll(){
        List<Revisor> revisors = new ArrayList<>();
        try{
            String selectString = "SELECT * FROM Revisor;";
            
            PreparedStatement preparedStatement = con.prepareStatement(selectString);
            preparedStatement.setQueryTimeout(30);

            ResultSet rs = preparedStatement.executeQuery();
            
            Revisor revisor = null;

            while(rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String document = rs.getString("document");
                String lattes = rs.getString("lattes");
                String workingInstitution = rs.getString("workingInstitution");
                String researchId = rs.getString("researchId");
                
                revisor = new Revisor(name, email, password, phone, document, lattes, workingInstitution, researchId);
                revisors.add(revisor);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return revisors;
    }

    @Override
    public void save(Revisor revisor){
        String name = revisor.getName();
        String email = revisor.getEmail();
        String password = revisor.getPassword();
        String phone = revisor.getPhone();
        String document = revisor.getDocument();
        String lattes = revisor.getLattes();
        String workingInstitution = revisor.getWorkingInstitution();
        String researchId = revisor.getResearchId();
     
        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("INSERT INTO Revisor VALUES ('"+ name +"', '"+ email +"', '"+ password +"', '"+ phone +"', '"+ document +"', '"+ lattes +"', '"+ workingInstitution +"', '"+ researchId + "';");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Revisor revisor, Map<String, String> map){
        String revisorDocument = map.get("document");
        Revisor updatedRevisor = this.get(revisorDocument).stream().findFirst().get();

        String name = map.get("name") != null ? map.get("name") : updatedRevisor.getName();
        String email = map.get("email") != null ? map.get("email") : updatedRevisor.getEmail();
        String password = map.get("password") != null ? map.get("password") : updatedRevisor.getPassword();
        String phone = map.get("phone") != null ? map.get("phone") : updatedRevisor.getPhone();
        String document = map.get("document") != null ? map.get("document") : updatedRevisor.getDocument();
        String lattes = map.get("lattes") != null ? map.get("lattes") : updatedRevisor.getLattes();
        String workingInstitution = map.get("workingInstitution") != null ? map.get("workingInstitution") : updatedRevisor.getWorkingInstitution();
        String researchId = map.get("researchId") != null ? map.get("researchId") : updatedRevisor.getResearchId();

        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("UPDATE Revisor SET name = "+ name +",email = "+email+",password = "+ password +", phone = "+ phone +", document = "+ document +", lattes = "+ lattes + ", workingInstitution = "+ workingInstitution + ", researchId = "+ researchId + " WHERE document = "+document);
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }

    }    

    @Override
    public void delete(Revisor revisor){
        String revisorDocument = revisor.getDocument();
        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("DELETE FROM Revisor WHERE document = " + revisorDocument);
           
         
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
