package com.linh.jpa;

import org.hibernate.Session;
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

import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class HelloJpaApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(HelloJpaApplication.class);

    @Autowired
    private StudentDAO studentRepository;
    
    @Autowired
    private StudentService studentService;

//    @Autowired
//    private CourceDAO publisherRepository;

    public static void main(String[] args) {
        SpringApplication.run(HelloJpaApplication.class, args);
    }
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
    	//delete
//    	int studentIInputdDelete = 3;
//    	try {
//    		studentService.deleteStudent(studentIInputdDelete);
//		} catch (Exception e) {
//			System.out.println("Không tìm thấy id: "+studentIInputdDelete +"để xóa!");
//		}
    	// add book
    	System.out.println("======== ADD book==============");
    	Student student = new Student("linh","ha nam");
//    	bookRepository.save(student);
    	
    	
    	System.out.println("======== end add book==============");
    	
    	//find by id
    	System.out.println("======== find book by id==============");
    	int studentIdInputFindbyId = 1;
    	try {
    		System.out.println("Kết quả tìm theo id: "+studentIdInputFindbyId+"\n");
    		System.out.println(studentService.findStudentById(studentIdInputFindbyId));
		} catch (Exception e) {
			System.out.println("Không tìm thấy sinh viên có id = "+studentIdInputFindbyId);
		}
    	
    	System.out.println("======== end find book by id==============");
//    	add register cource
    	System.out.println("======== add register cource==============");
    	Cource cource1 = new Cource("Eglish");
    	Cource cource2 = new Cource("Japanese");
    	//cách 1: truyền qua constructor
    	Set<Cource> cources = new HashSet<Cource>() {{
    		add(cource1);
    		add(cource2);
    	}};
    	Student student2 = new Student("Harry porter","Hogwarts",cources);
    	//cacsh2: get set
//    	student2.setStudent_name("Harry porter");
//    	student2.setCources(new HashSet<Cource>() {{
//    		add(cource1);
//    		add(cource2);
//    	}});
    	studentService.addStudent(student2);
    	System.out.println("======================");
    	System.out.println(studentService.findAllStudent());
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
