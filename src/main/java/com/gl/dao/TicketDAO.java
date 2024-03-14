package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.bean.Ticket;

@Repository
public interface TicketDAO extends JpaRepository<Ticket, Long> {
	List<Ticket> findByTitleContainingIgnoreCase(String searchTitle);
}
