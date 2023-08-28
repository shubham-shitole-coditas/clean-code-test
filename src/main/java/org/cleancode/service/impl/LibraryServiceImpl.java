package org.cleancode.service.impl;

import org.cleancode.entity.Book;
import org.cleancode.entity.Library;
import org.cleancode.service.LibraryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryServiceImpl implements LibraryService {

    private Library library;

    public LibraryServiceImpl() {
        library = new Library();
    }

    @Override
    public List<Book> searchBookByTitle(String searchText) {
        return library.getBooks().stream().filter(book -> book.getTitle().contains(searchText)).collect(Collectors.toList());
    }

    @Override
    public List<Book> searchBookByAuthor(String searchText) {
        return library.getBooks().stream().filter(book -> book.getAuthor().contains(searchText)).collect(Collectors.toList());
    }

    @Override
    public List<Book> searchBookByTitleOrAuthor(String searchText) {
        List<Book> books = searchBookByTitle(searchText);
        books.addAll(searchBookByAuthor(searchText));
        return books;
    }

    @Override
    public void addBook(Book book) {
        library.addBook(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return library.getBooks();
    }
}
