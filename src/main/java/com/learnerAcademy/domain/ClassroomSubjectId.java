package com.learnerAcademy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClassroomSubjectId implements Serializable {
 
    private static final long serialVersionUID = 1L;
    
    @Column(name = "class_id")
    private Integer classroomId;
    @Column(name = "subject_id")
    private Integer subjectId;
    
    public ClassroomSubjectId() {
    	
    }
    
	public ClassroomSubjectId(Integer classroomId, Integer subjectId) {
		super();
		this.classroomId = classroomId;
		this.subjectId = subjectId;
	}

	public Integer getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}
}