package com.bookhut.controllers;

import com.bookhut.models.binding_models.AddBookModel;
import com.bookhut.models.view_models.ViewBookModel;
import com.bookhut.serviceImpls.BookServiceImpl;
import com.bookhut.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "edit-book", value = "/shelves/edit/*")
public class EditBook extends HttpServlet {

    private BookService bookService;

    public EditBook() {
        this.bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tokens[] = req.getRequestURI().split("/");
        String title = URLDecoder.decode(tokens[3], "UTF-8");
        ViewBookModel viewBookModel = this.bookService.findBookByTitle(title);
        req.setAttribute("book", viewBookModel);
        req.getRequestDispatcher("/templates/edit-book.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        int pages = Integer.parseInt(req.getParameter("pages"));
        AddBookModel addBookModel = new AddBookModel(title, author, pages);
        this.bookService.saveBook(addBookModel);

        resp.sendRedirect("/shelves");
    }
}
