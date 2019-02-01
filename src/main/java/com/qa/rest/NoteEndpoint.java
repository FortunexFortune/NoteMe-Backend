package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.business.service.NoteService;

@Path("/note")
public class NoteEndpoint {

	@Inject
	private NoteService service;

	@Path("/getAllNotes")
	@GET
	@Produces({ "application/json" })
	public String getAllNotes() {
//		http://localhost:8080/SpeedMe_Backend/api/note/getAllNotes
		return service.getAllNotes();
	}

	@Path("/createNote")
	@POST
	@Produces({ "application/json" })
	public String createNote(String noteJSON) {
//		http://localhost:8080/SpeedMe_Backend/api/note/createNote
		return service.createNote(noteJSON);
	}

	@Path("/deleteNote/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteNote(@PathParam("id") Long id) {
//		http://localhost:8080/SpeedMe_Backend/api/note/deleteNote/1
		return service.deleteNote(id);
	}
	
	@Path("/updateNote/{id}")
	@POST
	@Produces({ "application/json" })
	public String updateNote(@PathParam("id") Long id,String noteJSON) {
//		http://localhost:8080/SpeedMe_Backend/api/note/updateNote/3
		return service.updateNote(id, noteJSON);
	}

	public void setService(NoteService service) {
		this.service = service;
	}

	
}
