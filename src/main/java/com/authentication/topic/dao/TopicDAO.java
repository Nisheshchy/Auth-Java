package com.authentication.topic.dao;

import com.authentication.topic.model.TopicModel;
import com.authentication.utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;

public class TopicDAO {
    public ArrayList<TopicModel> getAllTopic(){
        String sql="Select * from topic";
        ArrayList<TopicModel> topicList=new ArrayList<>();
        try(Connection con= DbConnection.getConnection();
            Statement st=con.createStatement();
        ){
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                Timestamp createdAt=rs.getTimestamp("createdAt");
                Timestamp updatedAt=rs.getTimestamp("updatedAt");
                TopicModel topic=new TopicModel();
                topic.setId(id);
                topic.setName(name);
                topic.setCreatedAt(createdAt);
                topic.setUpdatedAt(updatedAt);
                topicList.add(topic);
            }
            return topicList;
        } catch (Exception e) {
            System.out.println("Error while searching topic");
            return null;
        }
    }

    public boolean addTopic(String topic_name){
        String sql="INSERT INTO topic(name,createdAt) VALUES(?,?)";
        try(Connection con=DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
        ){
            Timestamp now=new Timestamp(System.currentTimeMillis());
            ps.setString(1,topic_name);
            ps.setTimestamp(2,now);
            int row=ps.executeUpdate();
            return row>0;
        }catch (Exception e){
            System.out.println("Error while adding topic"+e.getMessage());
            return false;
        }
    }

    public TopicModel getSingleTopic(int id){
        String sql="SELECT * FROM topic WHERE id=?";
        try(Connection con=DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
        ){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                TopicModel topic=new TopicModel();
                topic.setId(rs.getInt(1));
                topic.setName(rs.getString(2));
                topic.setCreatedAt(rs.getTimestamp(3));
                topic.setUpdatedAt(rs.getTimestamp(4));
                return topic;
            }
            return null;
        }catch (Exception e){
            System.out.println("Error while searching topic");
            return null;
        }
    }

    public  boolean updateTopic(int id, String name){
        String sql="Update topic SET name=?, updatedAt=? WHERE id=?";
        try(Connection con=DbConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
        ){
            Timestamp now=new Timestamp(System.currentTimeMillis());
            ps.setString(1,name);
            ps.setTimestamp(2,now);
            ps.setInt(3,id);
            int row=ps.executeUpdate();
            return row>0;
        }catch (Exception e){
            System.out.println("Error while updating topic"+e.getMessage());
            return false;
        }
    }
}
