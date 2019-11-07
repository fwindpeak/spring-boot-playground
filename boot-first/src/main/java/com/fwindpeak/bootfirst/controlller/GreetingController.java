package com.fwindpeak.bootfirst.controlller;

import com.fwindpeak.bootfirst.entity.Greeting;
import com.fwindpeak.bootfirst.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    private BookService bookService;

    @Autowired
    private void setBookService(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue = "World")String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping("/book")
    public List book(){
        if(bookService == null){
            System.out.println("bookService is null");
        }
        return bookService.getList();
    }

}
