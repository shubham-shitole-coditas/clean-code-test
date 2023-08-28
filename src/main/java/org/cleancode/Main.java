package org.cleancode;

import org.cleancode.entity.Book;
import org.cleancode.service.LibraryService;
import org.cleancode.service.impl.LibraryServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int ADD_BOOK = 1;
    private static final int SEARCH_BY_TITLE = 2;
    private static final int SEARCH_BY_AUTHOR = 3;
    private static final int SEARCH_BY_TITLE_OR_AUTHOR = 4;
    private static final int LIST_ALL_BOOKS = 5;
    private static final int EXIT = 6;

    public static void main(String[] args) {
        LibraryService libraryService = new LibraryServiceImpl();


        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (EXIT != choice) {
            try {


                System.out.println("Enter your choice");
                System.out.println("\n1.add book\n2.search by title" +
                        "\n3.search by author\n4. search by title or author\n5.list all books\n6.exit");
                choice = scanner.nextInt();
                switch (choice) {
                    case ADD_BOOK:
                        System.out.println("Enter book details, title, author, date of release (dd-mm-yyyy)");
                        Book book = readBookFromInput(scanner);
                        libraryService.addBook(book);
                        break;
                    case SEARCH_BY_TITLE:
                        System.out.println("Enter search text");
                        printBooks(libraryService.searchBookByTitle(scanner.next()));
                        break;
                    case SEARCH_BY_AUTHOR:
                        System.out.println("Enter search text");
                        printBooks(libraryService.searchBookByAuthor(scanner.next()));
                        break;

                    case SEARCH_BY_TITLE_OR_AUTHOR:
                        System.out.println("Enter search text");
                        printBooks(libraryService.searchBookByTitleOrAuthor(scanner.next()));
                        break;
                    case LIST_ALL_BOOKS:
                        printBooks(libraryService.getAllBooks());
                        break;
                    case EXIT:
                        System.exit(0);
                    default:
                        System.out.println("invalid choice");
                }
            } catch (Exception exception) {
                System.out.println("Error in library service");
                System.out.println("Exception:" + exception.getMessage());
            }
        }

    }

    private static Book readBookFromInput(Scanner scanner) {
        String title = scanner.next();
        String author = scanner.next();
        String yearOfPublication = scanner.next();
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublicationYear(yearOfPublication);
        return book;
    }

    private static void printBooks(List<Book> books) {
        books.forEach(book -> System.out.println(book.getTitle() + "|" + book.getAuthor() + "|" + book.getPublicationYear()));
    }
}