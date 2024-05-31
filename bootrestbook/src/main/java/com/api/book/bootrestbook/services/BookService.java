package com.api.book.bootrestbook.services;
import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    /* 
    private static List<Book> list = new ArrayList<Book>();
    static{
         
        list.add(new Book(101,"Mathematics","Ishaan"));
        list.add(new Book(102,"Data Structures","Yash"));
        list.add(new Book(103,"Database Management System","Rahul"));
        
    }
    */
    // get all books
    public List<Book> getAllBooks()
    {
        List<Book> list=(List<Book>)this.bookRepository.findAll();
        return list;
    }

    //get book by id
    public Book getBookById(int id)
    {
        Book book=null;
        try
        {
            //book=list.stream().filter(e->e.getId()==id).findFirst().get();
            book=this.bookRepository.findById(id);
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return book;
    }

    //adding the book
    public Book addBook(Book b)
    {
        Book result=this.bookRepository.save(b);
        //list.add(b);
        return result;
    }

    //deleting the book
    public void deleteBook(int bid)
    {
        /* 
        list=list.stream().filter(book->{
            if(book.getId()!=bid) return true;
            else return false;
        }).collect(Collectors.toList());
        */
        this.bookRepository.deleteById(bid);
    }

    public void updateBook(Book book,int bookId)
    {
        /* 
        list=list.stream().map(b->{
            if(b.getId()==bookId)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
        */

        book.setId(bookId);
        this.bookRepository.save(book);

    }

}
