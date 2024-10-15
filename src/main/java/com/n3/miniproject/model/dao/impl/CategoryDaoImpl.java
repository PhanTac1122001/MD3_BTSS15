package com.n3.miniproject.model.dao.impl;

import com.n3.miniproject.model.dao.ICategoryDao;
import com.n3.miniproject.model.entity.Book;
import com.n3.miniproject.model.entity.Category;
import com.n3.miniproject.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDaoImpl implements ICategoryDao {
    @Override
    public List<Category> findAll() {

        List<Category> categories=new ArrayList<>();
        try(Connection  connection= ConnectionDB.openConnect();
            PreparedStatement ps =connection.prepareStatement("select * from category");) {

            ResultSet rs= ps.executeQuery();
            while (rs.next()){
               Category category=new Category();
               category.setId(rs.getInt("id"));
               category.setName(rs.getString("name"));
               category.setStatus(rs.getBoolean("status"));
               categories.add(category);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return categories;
    }

    @Override
    public Category findById(int id) {
        Category category=new Category();
        try(
                Connection  connection=ConnectionDB.openConnect();
        PreparedStatement ps=connection.prepareStatement("select *from category where id=?");
                ) {

            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){

                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));

            }
            return category;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean addCate(Category category) {
        try (
                Connection connection=ConnectionDB.openConnect();
                PreparedStatement ps=connection.prepareStatement("insert into category(name,status) values (?,?)")
                ){
            ps.setString(1,category.getName());
            ps.setBoolean(2,category.getStatus());
            ps.executeUpdate();
            return  true;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean updateCate(Category category) {
        try (
                Connection connection=ConnectionDB.openConnect();
                PreparedStatement ps=connection.prepareStatement("update category set name=?,status=? where id=?")
        ){
            ps.setString(1,category.getName());
            ps.setBoolean(2,category.getStatus());
            ps.setInt(3,category.getId());
            ps.executeUpdate();
            return  true;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCate(int id) {
    try (
            Connection connection=ConnectionDB.openConnect();
            PreparedStatement ps=connection.prepareStatement("delete from category where id=?")
            ){
        ps.setInt(1,id);
        ps.executeUpdate();

    }catch (SQLException e){
        throw new RuntimeException(e);
    }
    }
}
