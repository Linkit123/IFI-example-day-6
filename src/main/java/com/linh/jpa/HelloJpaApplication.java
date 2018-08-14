package com.linh.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linh.jpa.dao.CourceDAO;
import com.linh.jpa.dao.StudentDAO;
import com.linh.jpa.model.Cource;
import com.linh.jpa.model.Student;
import com.linh.jpa.service.StudentService;

import javax.transaction.Transactional;
import java.util.HashSet;

@SpringBootApplication
public class HelloJpaApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(HelloJpaApplication.class);

    @Autowired
    private StudentDAO bookRepository;
    
    @Autowired
    private StudentService bookService;

    @Autowired
    private CourceDAO publisherRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelloJpaApplication.class, args);
    }
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
    	//delete
    	bookService.deleteStudent(2);
    	// add book
    	System.out.println("======== ADD book==============");
    	Student student = new Student("linh","ha nam");
//    	bookRepository.save(student);
    	System.out.println(bookService.findAllStudent());
    	
    	System.out.println("======== end add book==============");
    	
    	System.out.println("======== find book by id==============");
    	System.out.println(bookService.findStudentById(2));
    	System.out.println("======== end find book by id==============");
//    	Student book = new Student();
//    	book.setName("Harry porter");
//    	Cource publisherD = new Cource("Publisher D");
//    	Cource publisherE = new Cource("Publisher E");
//    	book.setPublishers(new HashSet<Cource>() {{
//    		add(publisherD);
//    		add(publisherE);
//    	}});
//    	bookRepository.save(book);
//    	System.out.println("======================");
//    	System.out.println(bookRepository.findAll()); 
//    	System.out.println("======================");
//    	System.out.println(publisherRepository.findAll());
//    	System.out.println("======================");
//    	System.out.println(bookRepository.findOne(15));
    	
//        // save a couple of books
//        Publisher publisherA = new Publisher("Publisher A");
//        Publisher publisherB = new Publisher("Publisher B");
//        Publisher publisherC = new Publisher("Publisher C");
//
//        bookRepository.save(new HashSet<Book>(){{
//            add(new Book("Book A", new HashSet<Publisher>(){{
//                add(publisherA);
//                add(publisherB);
//            }}));
//
//            add(new Book("Book B", new HashSet<Publisher>(){{
//                add(publisherA);
//                add(publisherC);
//            }}));
//        }});
//
//        // fetch all books
//        for(Book book : bookRepository.findAll()) {
//            logger.info(book.toString());
//        }
//
//        // save a couple of publishers
//        Book bookA = new Book("Book A");
//        Book bookB = new Book("Book B");
//
//        publisherRepository.save(new HashSet<Publisher>() {{
//            add(new Publisher("Publisher A", new HashSet<Book>() {{
//                add(bookA);
//                add(bookB);
//            }}));
//
//            add(new Publisher("Publisher B", new HashSet<Book>() {{
//                add(bookA);
//                add(bookB);
//            }}));
//        }});
//
//        // fetch all publishers
//        for(Publisher publisher : publisherRepository.findAll()) {
//            logger.info(publisher.toString());
//        }
    }
}
