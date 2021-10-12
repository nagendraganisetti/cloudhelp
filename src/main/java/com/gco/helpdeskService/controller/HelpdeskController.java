package com.gco.helpdeskService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gco.helpdeskService.exception.HelpdeskQueryNotFoundException;
import com.gco.helpdeskService.*;
import com.gco.helpdeskService.service.HelpdeskServiceImpl;
import com.gco.helpdeskService.entities.Helpdesk;


@RestController
@RequestMapping("/HelpdeskController")
public class HelpdeskController {
	
	Logger log = LoggerFactory.getLogger(HelpdeskController.class);
	
	@Autowired
	private HelpdeskServiceImpl studentService;
	
	@Autowired
	private HelpdeskServiceImpl helpdeskService;
	
	
	
     //create help desk query
	   @PostMapping(path = "/createHelpdesk", consumes = "application/json", produces = "application/json")
	   public ResponseEntity<Helpdesk> createHelpdeskQuery(@RequestBody Helpdesk helpdesk) {
		   
		   log.info("postStudent method of StudentController called ");
		   if(helpdesk != null) {
	        Helpdesk newHelpdesk = helpdeskService.addHelpDeskQuery(helpdesk);
			return new ResponseEntity<Helpdesk>(newHelpdesk, HttpStatus.ACCEPTED);
			}
		   log.info("postStudent method of StudentController ends ");
			return new ResponseEntity<Helpdesk>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
				
		//Delete help desk query
		@DeleteMapping(path = "/deleteHelpdesk/{queryId}", consumes = "application/json")
		public ResponseEntity<Boolean> deleteHelpDeskQuery(@PathVariable("queryId")int queryId) {
		log.info("deleteStudent method of StudentController called ");				
		helpdeskService.deleteHelpDesk(queryId);
		log.info("deleteStudent method of StudentController ends");		
		return new ResponseEntity<>(HttpStatus.OK);
					
	    }
					
		// View help desk query
		@GetMapping(path = "/helpdesk/{queryId}", consumes = "application/json")
		public ResponseEntity<Helpdesk> getHelpDesk(@PathVariable("queryId") int queryId) {
		
			log.info("getStudent method of StudentController called ");
			
		Helpdesk help = helpdeskService.getHelpDesk(queryId);
		if(help != null) {
						
		return new ResponseEntity<Helpdesk>(help, HttpStatus.OK);
		}
						
		log.info("getStudent method of StudentController ends");
	    return new ResponseEntity<Helpdesk>(HttpStatus.NOT_FOUND);
					}
		
		// Get all help desk queries
		@GetMapping(path = "/helpdesk/all", produces = "application/json")
			public ResponseEntity<List<Helpdesk>> getAllHelpdesk() {
			
			log.info("get Admin method of Admin Controller to get all helpdesk is called");

			 List<Helpdesk> queries = helpdeskService.getAllHelpDesk();
				if (queries.isEmpty()) {
	         throw new HelpdeskQueryNotFoundException("Query not found.....");
				}
				
				log.info("get Admin method of Admin Controller to get all helpdesk ends");
				return new ResponseEntity<>(queries, HttpStatus.OK);
			}
//		
//		// Update help desk query by id
//		@PutMapping(path = "/helpdesk-update/{studentId}", consumes = "application/json", produces = "application/json")
//		  public ResponseEntity<Helpdesk> solveHelpDeskQuery(@PathVariable("studentId") int studentId,@RequestBody Helpdesk helpdesk)throws NoSuchStudentException{ 
//	       
//			  log.info("putAdmin method of Admin Controller called");
//			  Helpdesk result = helpdeskService.solveHelpDeskQuery(studentId,helpdesk);
//
//			  log.info("putAdmin method of Admin Controller ends");
//			  if(result != null)
//				  return new ResponseEntity<>(result, HttpStatus.OK);
//			  else
//				  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//			 
//		  }
//		
}