package org.cleancode.service;

import org.cleancode.entity.Book;

import java.util.List;

public interface LibraryService {

    public List<Book> searchBookByTitle(String searchText);

    public List<Book> searchBookByAuthor(String searchText);

    public List<Book> searchBookByTitleOrAuthor(String searchText);

    public void addBook(Book book);

    public List<Book> getAllBooks();
}
