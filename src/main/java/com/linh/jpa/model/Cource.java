package com.linh.jpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cource {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cource_id;
    private String cource_name;
    @ManyToMany(mappedBy = "cources")
    private Set<Student> students;
    
//    @Override
//	public String toString() {
//		return "Cource [cource_id=" + cource_id + ", cource_name=" + cource_name + ", students=" + students + "]";
//	}
	
	public int getCource_id() {
		return cource_id;
	}
	public void setCource_id(int cource_id) {
		this.cource_id = cource_id;
	}
	public Cource() {
		super();
	}
	public String getCource_name() {
		return cource_name;
	}
	public void setCource_name(String courcce_name) {
		this.cource_name = courcce_name;
	}
	 public Cource(String cource_name) {
		super();
		this.cource_name = cource_name;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Cource(String cource_name, Set<Student> students) {
		super();
		this.cource_name = cource_name;
		this.students = students;
	}  
}
