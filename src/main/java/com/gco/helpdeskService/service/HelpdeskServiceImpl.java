package com.gco.helpdeskService.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gco.helpdeskService.entities.Helpdesk;

import com.gco.helpdeskService.repository.HelpdeskRepository;



@Service
@Transactional
public class HelpdeskServiceImpl implements HelpdeskService{
	
	Logger log = LoggerFactory.getLogger(HelpdeskServiceImpl.class);
	
	@Autowired
	private HelpdeskRepository helpdeskRepository;
	
//	@Autowired
//	private HelpdeskValidation helpdeskValidation;

	// create help desk query	
		@Override
		public Helpdesk addHelpDeskQuery(Helpdesk helpdesk) {
			
			log.debug("addHelpDeskQuery service in helpdesk service is invoked");
			helpdesk.setQuerySolution("Pending");
			//helpdesk.setStudent(adminService.viewStudent(helpdesk.getStudent().getStudentId()));
			return helpdeskRepository.save(helpdesk);
		}
	
//		//update help desk query
//		@Override
//		public Helpdesk solveHelpDeskQuery(int studentId,Helpdesk helpdesk) throws NoSuchStudentException{
//			
//			Helpdesk helpdesk =helpdeskRepository.findStudentById(queryId); 
//			helpdesk.setHelpdesk(studentId);
//			log.debug("solveHelpDeskQuery service in helpdesk service is invoked");
//			//helpdeskValidation.validateHelpDeskFields(helpdesk);
//			return helpdeskRepository.save(helpdesk);
//			
//		}
//		
//		
		
		//get all help desk query
		@Override
		public List<Helpdesk> getAllHelpDesk() {
			
			log.debug("getAllHelpDesk service in helpdesk service is invoked");
			ArrayList<Helpdesk> list = new ArrayList<>();
			Iterable<Helpdesk> helpdeskList = helpdeskRepository.findAll();
			for (Helpdesk helpdesk : helpdeskList) {
				list.add(helpdesk);
			}
			return list;
		}
		
		//get help desk query by id
		@Override
		public Helpdesk getHelpDesk(int queryId) {
			
			log.debug("getHelpDesk service in helpdesk service is invoked");
			
			return helpdeskRepository.findById(queryId).get();
			
		}
		
		// delete help desk query
	    @Override
		public boolean deleteHelpDesk(int queryId) {
	    	
	    	log.debug("deleteHelpDeskQuery service in helpdesk service is invoked");
			if (helpdeskRepository.findById(queryId) != null) {
			    Helpdesk helpdesk = helpdeskRepository.findById(queryId).get();
				//helpdesk.setStudent(null);
				helpdeskRepository.delete(helpdesk);
				return true;
			}
			else
				return false;
		}
		
}
