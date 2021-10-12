package com.gco.helpdeskService.service;

import java.util.List;

import com.gco.helpdeskService.entities.Helpdesk;

public interface HelpdeskService {
	
    public Helpdesk addHelpDeskQuery(Helpdesk helpdesk);
	
	//public void solveHelpDeskQuery(int queryId,Helpdesk helpdesk);

    public List<Helpdesk> getAllHelpDesk();
	
	public Helpdesk getHelpDesk(int queryId);
	
	public boolean deleteHelpDesk(int queryId);

}