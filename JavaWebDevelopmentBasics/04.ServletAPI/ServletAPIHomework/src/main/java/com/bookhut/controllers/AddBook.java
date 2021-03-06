package com.bookhut.controllers;

import com.bookhut.models.binding_models.AddBookModel;
import com.bookhut.serviceImpls.BookServiceImpl;
import com.bookhut.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "add-book", value = "/add-book")
public class AddBook extends HttpServlet {

    private BookService bookService;

    public AddBook() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("templates/add-book.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        Integer pages = Integer.parseInt(req.getParameter("pages"));

        AddBookModel book = new AddBookModel(title, author, pages);
        this.bookService.saveBook(book);

        req.getRequestDispatcher("templates/add-book.jsp").forward(req, resp);
    }
}
