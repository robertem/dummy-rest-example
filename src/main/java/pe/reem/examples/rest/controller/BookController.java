package pe.reem.examples.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pe.reem.examples.rest.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by robert on 13/11/17.
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> findAll() {
        List<Book> books = new ArrayList<Book>();

        Book book = new Book();
        book.setName("Cien Años de Soledad");
        book.setAuthor("Gabriel García Márquez");

        Book book2 = new Book();
        book2.setName("El Amor en los tiempos de cólera");
        book2.setAuthor("Gabriel García Márquez");

        books.add(book);
        books.add(book2);

        return books;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Book findOne(@PathVariable("id") String id) {
        Book book = new Book();
        book.setName(id);
        book.setAuthor("ni idea");

        return book;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, String> create(@RequestBody Book book) {
        Map<String, String> response = new HashMap<String, String>();
        response.put("result", "éxito");
        response.put("libro creado", book.getName());

        return response;
    }

}
