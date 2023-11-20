package classes.dao;

import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import classes.SubArea;

public class SubAreaDao implements Dao<SubArea>{
    
    private Connection con;

    public SubAreaDao(){
        this.con = DatabaseConnection.getConnection();
    }

    @Override
    public Optional<SubArea> get(Object subareaId){

        SubArea subArea = null;

        try{

            String selectSQL = "SELECT * FROM Subarea WHERE subareaId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);

            preparedStatement.setString(1, subareaId.toString());
            
            preparedStatement.setQueryTimeout(30);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                String id = rs.getString("subareaId");
                String title = rs.getString("title");
                String areaId = rs.getString("areaId");

                subArea = new SubArea(Integer.parseInt(id), title, Integer.parseInt(areaId));

            }

            preparedStatement.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(subArea);

    }

    @Override
    public List<SubArea> getAll(){
        
        List<SubArea> subareas = new ArrayList<>();
        SubArea subArea = null;

        try{
            String sqlString = "SELECT * FROM Subarea";

            PreparedStatement preparedStatement = con.prepareStatement(sqlString);

            preparedStatement.setQueryTimeout(30);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString("subareaId");
                String title = rs.getString("title");
                String areaId = rs.getString("areaId");

                subArea = new SubArea(Integer.parseInt(id), title, Integer.parseInt(areaId));

                subareas.add(subArea);
            }
            
            preparedStatement.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    
        return subareas;

    }

    @Override
    public void save(SubArea subArea){
        Integer id = subArea.getId();
        String title = subArea.getTitle();
        Integer areaId = subArea.getAreaId();

        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("INSERT INTO Subarea VALUES ("+ id.toString() +", " + title +", " +title+", "+ areaId + ")");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(SubArea subArea, Map<String,String> map){
        
        String subareaId = map.get("subareaId");

        SubArea updatedSubArea = this.get(subareaId).stream().findFirst().get();

        String title = map.get("title") != null ? map.get("title") : updatedSubArea.getTitle();
        Integer areaId = map.get("areaId") != null ? Integer.parseInt(map.get("areaId")) : updatedSubArea.getId();

        try{
            
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("UPDATE  SET subareaId = "+subareaId+",title = "+title+",areaId = "+ areaId.toString() + " WHERE subareaId = " + subareaId);

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(SubArea subArea){
    
    }

}
