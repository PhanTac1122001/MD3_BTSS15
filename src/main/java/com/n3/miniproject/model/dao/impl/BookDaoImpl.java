package com.n3.miniproject.model.dao.impl;

import com.n3.miniproject.model.dao.IBookDao;
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
public class BookDaoImpl implements IBookDao {
    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        try (
                Connection connection = ConnectionDB.openConnect();
                PreparedStatement ps = connection.prepareStatement("select * from book")
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setCategory_id(rs.getInt("category_id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setStock(rs.getInt("stock"));
                book.setTotalPages(rs.getInt("totalPages"));
                book.setYearCreated(rs.getInt("yearCreated"));
                book.setAuthor(rs.getString("author"));
                book.setStatus(rs.getBoolean("status"));

                bookList.add(book);


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

    @Override
    public Book findById(int id) {
        try(
                Connection connection=ConnectionDB.openConnect();
                PreparedStatement ps=connection.prepareStatement("select * from book where id=?")
                ) {
                ps.setInt(1,id);
                ResultSet rs= ps.executeQuery();
                if (rs.next()){
                    Book book=new Book();
                    book.setId(rs.getInt("id"));
                    book.setCategory_id(rs.getInt("category_id"));
                    book.setName(rs.getString("name"));
                    book.setPrice(rs.getDouble("price"));
                    book.setStock(rs.getInt("stock"));
                    book.setTotalPages(rs.getInt("totalPages"));
                    book.setYearCreated(rs.getInt("yearCreated"));
                    book.setAuthor(rs.getString("author"));
                    book.setStatus(rs.getBoolean("status"));
                    return book;
                }
                return null;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean addBook(Book book) {
        try (
                Connection connection=ConnectionDB.openConnect();
                PreparedStatement ps=connection.prepareStatement("insert into book(category_id,name,price,stock,totalPages,yearCreated,author,status) values (?,?,?,?,?,?,?,?)")
                ){
                ps.setInt(1,book.getCategory_id());
                ps.setString(2,book.getName());
                ps.setDouble(3,book.getPrice());
                ps.setInt(4,book.getStock());
                ps.setInt(5,book.getTotalPages());
                ps.setInt(6,book.getYearCreated());
                ps.setString(7,book.getAuthor());
                ps.setBoolean(8,book.getStatus());
                ps.executeUpdate();
                return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean updateBook(Book book) {
        try (
                Connection connection=ConnectionDB.openConnect();
                PreparedStatement ps=connection.prepareStatement("update book set category_id=?,name=?,price=?,stock=?,totalPages=?,yearCreated=?,author=?,status=? where id=?")
        ){
            ps.setInt(1,book.getCategory_id());
            ps.setString(2,book.getName());
            ps.setDouble(3,book.getPrice());
            ps.setInt(4,book.getStock());
            ps.setInt(5,book.getTotalPages());
            ps.setInt(6,book.getYearCreated());
            ps.setString(7,book.getAuthor());
            ps.setBoolean(8,book.getStatus());
            ps.setInt(9,book.getId());
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBook(int id) {
        try (
                Connection connection=ConnectionDB.openConnect();
                PreparedStatement ps=connection.prepareStatement("delete from book where id=?")
        ){
            ps.setInt(1,id);
            ps.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
