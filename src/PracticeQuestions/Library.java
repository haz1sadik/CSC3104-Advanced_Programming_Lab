package PracticeQuestions;

import java.util.ArrayList;
 
public class Library { 
    private ArrayList<Book> books; 
 
    public Library() { 
        this.books = new ArrayList<>(); 
    } 
 
    public void addBook(Book book) { 
        books.add(book); 
    } 
 
    public void removeBook(Book book) { 
        books.remove(book); 
    } 
 
    public void clearLibrary() { 
        books.clear(); 
    } 
 
    public int getNumberOfBooks() { 
        return books.size(); 
    } 
 
    public double calculateAverageRating() { 
        if (books.isEmpty()) { 
            return 0.0; 
        } 
 
        double totalRating = 0.0; 
        for (Book book : books) { 
            totalRating += book.getRating(); 
        } 
        return totalRating / books.size(); 
    } 
} 
 
class Book { 
    private String title; 
    private double rating; 
 
    public Book(String title, double rating) { 
        this.title = title; 
        this.rating = rating; 
    } 
 
    // Getters 
    public String getTitle() { 
        return title; 
    } 
 
    public double getRating() { 
        return rating; 
    } 
} 