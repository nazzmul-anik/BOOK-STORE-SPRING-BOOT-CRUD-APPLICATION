package com.nazmul_anik.book_store.controller;

import com.nazmul_anik.book_store.entity.Book;
import com.nazmul_anik.book_store.entity.MyBooks;
import com.nazmul_anik.book_store.service.BookService;
import com.nazmul_anik.book_store.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    MyBookService myBookService;

    @GetMapping("/")
    public String home(){
        return "homePage.html";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegisterPage.html";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List< Book> list = bookService.getAllBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookListPage.html");
        modelAndView.addObject("books", list);
        return modelAndView;
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_books";
    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBooks> myBooksList = myBookService.getAllBooks();
        model.addAttribute("books", myBooksList);
        return "myBookListPage.html";
    }

    @RequestMapping("/myBookList/{id}")
    public String getMyBookList(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        MyBooks myBooks = new MyBooks(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
        myBookService.saveMyBooks(myBooks);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookEdit.html";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBookById(id);
        return "redirect:/available_books";
    }
}
