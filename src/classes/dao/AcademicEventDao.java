package classes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.sql.Statement;

import classes.AcademicEvent;

public class AcademicEventDao implements Dao<AcademicEvent>{

    private Connection con;

    public AcademicEventDao(){
        this.con = DatabaseConnection.getConnection();
    }

    @Override
    public Optional<AcademicEvent> get(Object academicEventId){

        AcademicEvent academicEvent = null;

        try{

            String selectSQL = "SELECT * FROM AcademicEvent WHERE academicEventId = ?"; 

            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);

            preparedStatement.setString(1, academicEventId.toString());

            preparedStatement.setQueryTimeout(30); 
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                String id = rs.getString("academicEventId");
                String name = rs.getString("name");
                String initDate = rs.getString("initDate");
                String endDate = rs.getString("endDate");
                String location = rs.getString("location");
                String theme = rs.getString("theme");
                String description = rs.getString("description");
                String areaDirectorId = rs.getString("areaDirectorId");
                
                List<Integer> idsAcceptedArticlesList = new ArrayList<Integer>();
                List<String> idsAcceptedArticles = Arrays.asList(rs.getString("idsAcceptedArticles").split(","));
                for(int i=0; i<idsAcceptedArticles.size(); i++){
                    idsAcceptedArticlesList.add(Integer.parseInt(idsAcceptedArticles.get(i)));
                }
                
                List<Integer> activitiesIdList = new ArrayList<Integer>();
                List<String> activitiesId = Arrays.asList(rs.getString("activitiesId").split(","));
                for(int i=0; i<activitiesId.size(); i++){
                    activitiesIdList.add(Integer.parseInt(activitiesId.get(i)));
                }

                List<Integer> participantsIdList = new ArrayList<Integer>();
                List<String> participantsId = Arrays.asList(rs.getString("idsAcceptedArticles").split(","));
                for(int i=0; i<participantsId.size(); i++){
                    participantsIdList.add(Integer.parseInt(participantsId.get(i)));
                }
                
                academicEvent = new AcademicEvent(  
                                                    Integer.parseInt(id), 
                                                    name, initDate, endDate, 
                                                    location, theme, 
                                                    description, 
                                                    Integer.parseInt(areaDirectorId), 
                                                    idsAcceptedArticlesList, 
                                                    activitiesIdList, 
                                                    participantsIdList
                                                    );
                
            }

            preparedStatement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.ofNullable(academicEvent);

    }

    @Override
    public List<AcademicEvent> getAll(){
        
        List<AcademicEvent> academicEvents = new ArrayList<>();
        AcademicEvent academicEvent = null;

        try{

            String selectSQL = "SELECT * FROM AcademicEvent";
            
            PreparedStatement preparedStatement = con.prepareStatement(selectSQL);

            preparedStatement.setQueryTimeout(30);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("academicEventId");
                String name = rs.getString("name");
                String initDate = rs.getString("initDate");
                String endDate = rs.getString("endDate");
                String location = rs.getString("location");
                String theme = rs.getString("theme");
                String description = rs.getString("description");
                String areaDirectorId = rs.getString("areaDirectorId");
                
                List<Integer> idsAcceptedArticlesList = new ArrayList<Integer>();
                List<String> idsAcceptedArticles = rs.getString("idsAcceptedArticles")!= null ? Arrays.asList(rs.getString("idsAcceptedArticles").split(",")) : new ArrayList<String>();
                for(int i=0; i<idsAcceptedArticles.size(); i++){
                    idsAcceptedArticlesList.add(Integer.parseInt(idsAcceptedArticles.get(i)));
                }
                
                List<Integer> activitiesIdList = new ArrayList<Integer>();
                List<String> activitiesId = rs.getString("activitiesId") != null ? Arrays.asList(rs.getString("activitiesId").split(",")) : new ArrayList<String>();
                for(int i=0; i<activitiesId.size(); i++){
                    activitiesIdList.add(Integer.parseInt(activitiesId.get(i)));
                }

                List<Integer> participantsIdList = new ArrayList<Integer>();
                List<String> participantsId = rs.getString("idsAcceptedArticles") != null ? Arrays.asList(rs.getString("idsAcceptedArticles").split(",")) : new ArrayList<String>();
                for(int i=0; i<participantsId.size(); i++){
                    participantsIdList.add(Integer.parseInt(participantsId.get(i)));
                }

                Integer areaDirectorIdInt = areaDirectorId !=null ? Integer.parseInt(areaDirectorId) : 1;
                
                academicEvent = new AcademicEvent(  
                                                    Integer.parseInt(id), 
                                                    name, initDate, endDate, 
                                                    location, theme, 
                                                    description, 
                                                    areaDirectorIdInt, 
                                                    idsAcceptedArticlesList, 
                                                    activitiesIdList, 
                                                    participantsIdList
                                                    );

                academicEvents.add(academicEvent);
            }

            preparedStatement.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }

        return academicEvents;

    }

    @Override
    public void save(AcademicEvent academicEvent){
        int academicEventId = academicEvent.getAcademicEventId();
        String name = academicEvent.getName();
        String initDate = academicEvent.getInitDate();
        String endDate = academicEvent.getEndDate();
        String location = academicEvent.getLocation();
        String theme = academicEvent.getTheme();
        String description = academicEvent.getDescription();
        int areaDirectorId = academicEvent.getAreaDirectorId();
        List<Integer> idsAcceptedArticles = academicEvent.getIdsAcceptedArticles();
        List<Integer> activitiesId = academicEvent.getActivitiesId();
        List<Integer> participantsId = academicEvent.getParticipantsId();
    
        try{
            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("INSERT INTO AcademicEvent VALUES (" + academicEventId +", " + name +", " + initDate +", " + endDate +", " + location +", " + theme +", " + description +", " + areaDirectorId +", " + idsAcceptedArticles.toString() +", "+ activitiesId.toString() +", " + participantsId.toString() +")");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(AcademicEvent academicEvent, Map<String, String> map){

        Integer academicEventId = Integer.parseInt(map.get("academicEventId"));

        AcademicEvent updatedAcademicEvent = this.get(academicEventId).stream().findFirst().get();

        String name = map.get("name") != null ? map.get("name") : updatedAcademicEvent.getName();
        String initDate = map.get("initDate") != null ? map.get("initDate") : updatedAcademicEvent.getInitDate();
        String endDate = map.get("endDate") != null ? map.get("endDate") : updatedAcademicEvent.getEndDate();
        String location = map.get("location") != null ? map.get("location") : updatedAcademicEvent.getLocation();
        String theme = map.get("theme") != null ? map.get("theme") : updatedAcademicEvent.getTheme();
        String description = map.get("description") != null ? map.get("description") : updatedAcademicEvent.getDescription();
        Integer areaDirectorId = map.get("areaDirectorId") != null ? Integer.parseInt(map.get("areaDirectorId")) : updatedAcademicEvent.getAreaDirectorId();
        
        List<String> idsAcceptedArticles = map.get("idsAcceptedArticles") != null ? new ArrayList<String> (Arrays.asList(map.get("idsAcceptedArticles").split(","))) : updatedAcademicEvent.getIdsAcceptedArticles().stream().map( i -> i.toString()).collect(Collectors.toList());
        
        List<Integer> idsAcceptedArticlesList = new ArrayList<Integer>();
        
        
        for(int i=0; i<idsAcceptedArticles.size(); i++){

            idsAcceptedArticlesList.add(Integer.parseInt(idsAcceptedArticles.get(i)));

        }

        List<String> activitiesId = map.get("activitiesId") != null ? new ArrayList<String> (Arrays.asList(map.get("activitiesId").split(","))) : updatedAcademicEvent.getActivitiesId().stream().map( i -> i.toString()).collect(Collectors.toList());
        List<Integer> activitiesIdList = new ArrayList<Integer>();
        for(int i=0; i<activitiesId.size(); i++){

            activitiesIdList.add(Integer.parseInt(activitiesId.get(i)));

        }

        List<String> participantsId = map.get("participantsId") != null ? new ArrayList<String> (Arrays.asList(map.get("participantsId").split(","))) : updatedAcademicEvent.getParticipantsId().stream().map( i -> i.toString()).collect(Collectors.toList());
        List<Integer> participantsIdList = new ArrayList<Integer>();
        for(int i=0; i<activitiesId.size(); i++){

            participantsIdList.add(Integer.parseInt(participantsId.get(i)));

        }

        try{

            Statement statement = con.createStatement();

            statement.setQueryTimeout(30);
            statement.executeUpdate("UPDATE AcademicEvent SET academicEventId = " + academicEventId +", name = " + name +", initDate = " + initDate +", endDate = " + endDate +", location = " + location +", theme = " + theme +", description =" + description +", areaDirectorId = " + areaDirectorId +", idsAcceptedArticles = " + idsAcceptedArticles.toString() +", activitiesId = "+ activitiesId.toString() +", participantsId = " + participantsId.toString());

        }catch(SQLException e){
            e.printStackTrace();
        }


    }


    @Override
    public void delete(AcademicEvent academicEvent){

        Integer academicEventId = academicEvent.getAcademicEventId();

        try{

            Statement statement = con.createStatement();
            statement.setQueryTimeout(30);
            statement.executeUpdate("DELETE FROM Article WHERE academicEventId = " + academicEventId);

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

}
