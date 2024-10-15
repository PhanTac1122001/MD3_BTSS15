package com.n3.miniproject.model.entity;

public class Book {
    private int id;
    private int category_id;
    private String name;
    private Double price;
    private int stock;
    private int totalPages;
    private int yearCreated;
    private String author;
    private Boolean status;

    public Book() {
    }

    public Book(int id, int category_id, String name, Double price, int stock, int totalPages, int yearCreated, String author, Boolean status) {
        this.id = id;
        this.category_id = category_id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.totalPages = totalPages;
        this.yearCreated = yearCreated;
        this.author = author;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
