package com.qa.persistance.repository;

public interface NoteRepository {
	
	String getAllNotes();
	String createNote(String noteJSON);
	String updateNote(Long id, String noteJSON);
	String deleteNote(Long id);

}
