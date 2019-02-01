package com.qa.business.service;

public interface NoteService {
	
	String getAllNotes();
	String createNote(String noteJSON);
	String updateNote(Long id, String noteJSON);
	String deleteNote(Long id);


}
