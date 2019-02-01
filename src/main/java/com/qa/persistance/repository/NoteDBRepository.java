package com.qa.persistance.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query;

import static javax.transaction.Transactional.TxType.REQUIRED;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;



import com.qa.persistance.domain.Note;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class NoteDBRepository implements NoteRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllNotes() {
		Query query = manager.createQuery("Select a FROM Note a");
		Collection<Note> notes = (Collection<Note>) query.getResultList();
		return util.getJSONForObject(notes);
	}

	@Transactional(REQUIRED)
	@Override
	public String createNote(String noteJSON) {
		Note newNote = util.getObjectForJSON(noteJSON, Note.class);
		manager.persist(newNote);
		return "{\"message\": \"Note has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	@Override
	public String updateNote(Long id, String noteJSON) {
		Note noteinDB = findNote(id);
		Note newNote = util.getObjectForJSON(noteJSON, Note.class);
		if (noteinDB != null) {
			manager.remove(noteinDB);
			manager.persist(newNote);
			return "{\"message\": \"has been sucessfully updated\"}";
			}
		return"{\"message\": \"The note id is invalid\"}";
	}
	
	@Transactional(REQUIRED)
	@Override
	public String deleteNote(Long id) {
		Note noteinDB = findNote(id);
		if (noteinDB != null) {
			manager.remove(noteinDB);
			return "{\"message\": \"note sucessfully deleted\"}";
			}
		return "{\"message\": \"deletion did not work\"}";
	}
	
	
	private Note findNote(Long id) {
		return manager.find(Note.class, id);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}


}
