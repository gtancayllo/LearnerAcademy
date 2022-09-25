package com.learnerAcademy.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="subject_class")
public class ClassroomSubject {
	
		private Integer id;
		private Classroom classroom;
		private Subject subject;
		private Teacher teacher;
	
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "subject_class_id")
	    public Integer getId() {
	        return id;
	    }
	 
	    public void setId(Integer id) {
	        this.id = id;
	    }
	 
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "class_id")  
	    public Classroom getClassroom() {
	        return classroom;
	    }
	 
	    public void setClassroom(Classroom classroom) {
	        this.classroom = classroom;
	    }
	 
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "subject_id")
	    public Subject getSubject() {
	        return subject;
	    }
	 
	    public void setSubject(Subject subject) {
	        this.subject = subject;
	    }
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "teacher_id")
	    public Teacher getTeacher() {
	        return teacher;
	    }
	 
	    public void setTeacher(Teacher teacher) {
	        this.teacher = teacher;
	    }
}
