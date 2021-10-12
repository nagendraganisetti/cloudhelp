package com.gco.helpdeskService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gco.helpdeskService.entities.Helpdesk;

@Repository
public interface HelpdeskRepository extends JpaRepository<Helpdesk,Integer> {

	//List<Helpdesk> Queries(String string);
	 
	
}
