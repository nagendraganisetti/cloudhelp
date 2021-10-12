package com.gco.helpdeskService.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.gco.helpdeskService.entities.*;

//@Data
//@AllArgsConstructor
//@Getter
//@Setter
//@NoArgsConstructor
@Entity
@Table(name="Helpdesk") /* Specifying table name*/
public class Helpdesk {

	@Id /* defining primary key*/
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* generating value automatically*/
    @Column(name = "query_Id") // specifying column name
	private int queryId;
	
	@Column(name="query_desc" ,length=100 ,nullable=false)
	private String queryDesc;
	
	@Column(name="query_solution" ,length=100)
	private String querySolution;
	
    private int studentId;
 
	public Helpdesk() {

	}


	public int getQueryId() {
		return queryId;
	}

	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}

	public String getQueryDesc() {
		return queryDesc;
	}

	public void setQueryDesc(String queryDesc) {
		this.queryDesc = queryDesc;
	}

	public String getQuerySolution() {
		return querySolution;
	}

	public void setQuerySolution(String querySolution) {
		this.querySolution = querySolution;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	
}
