package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.bean.Ticket;
import com.gl.dao.TicketDAO;

@Service
public class TicketServiceImpl implements TicketService{
	
	@Autowired
	TicketDAO dao;

	@Override
	public void addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		dao.save(ticket);
		
	}

	@Override
	public List<Ticket> getAllTicket() {

		return dao.findAll();
	}

	@Override
	public List<Ticket> searchTicketByTitle(String searchTitle) {

		return  dao.findByTitleContainingIgnoreCase(searchTitle);
	}

	

	@Override
	public void deleteById(long id) {
	
		dao.deleteById(id);
	}

	@Override
	public void updateTicketById(Ticket ticket, long id) {
         	
 		Ticket t = dao.findById(id).get();
 		t.setDescription(ticket.getDescription());
 		t.setStatus(ticket.getStatus());
 		t.setTitle(ticket.getTitle());
 		dao.save(t);
	}

	@Override
	public Ticket getTicketById(long id) {
		
		return dao.findById(id).get();
	}

	

}
