package com.linh.jpa.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int student_id;
    private String student_name;
    private String student_address;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_cource", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"), inverseJoinColumns = @JoinColumn(name = "cource_id", referencedColumnName = "cource_id"))
    private Set<Cource> cources;
    
    @Override
    public String toString() {
        String result = String.format(
                "Book [id=%d, name='%s']%n",
                student_id, student_name);
        if (cources != null) {
            for(Cource cource : cources) {
                result += String.format(
                        "Publisher[id=%d, name='%s']%n",
                        cource.getCource_id(), cource.getCource_name());
            }
        }
        return result;
    }
    public Student() {
		super();
	}
//	@Override
//	public String toString() {
//		return "------Student [student_id=" + student_id + ", student_name=" + student_name + ", student_address="
//				+ student_address + ", cources=" + cources + "]------%n";
//	}
	
	public int getStudent_id() {
		return student_id;
	}
	public Student(String student_name, String student_address) {
		super();
		this.student_name = student_name;
		this.student_address = student_address;
	}
	public Student(String student_name, String student_address, Set<Cource> cources) {
		super();
		this.student_name = student_name;
		this.student_address = student_address;
		this.cources = cources;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}
	
	public Set<Cource> getCources() {
		return cources;
	}
	public void setCources(Set<Cource> cources) {
		this.cources = cources;
	}
}
