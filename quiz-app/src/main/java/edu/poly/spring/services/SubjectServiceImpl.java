package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.spring.domains.Subject;
import edu.poly.spring.repositories.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	private SubjectRepository sr;

	@Override
	public List<Subject> findSubjectsByNameContaining(String name) {
		return sr.findSubjectsByNameContaining(name);
	}
	
	@Override
	public Subject save(Subject entity) {
		return sr.save(entity);
	}

	@Override
	public Iterable<Subject> saveAll(Iterable<Subject> entities) {
		return sr.saveAll(entities);
	}

	@Override
	public Optional<Subject> findById(Long id) {
		return sr.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return sr.existsById(id);
	}

	@Override
	public List<Subject> findAll() {
		return (List<Subject>) sr.findAll();
	}

	@Override
	public Iterable<Subject> findAllById(Iterable<Long> ids) {
		return sr.findAllById(ids);
	}

	@Override
	public long count() {
		return sr.count();
	}

	@Override
	public void deleteById(Long id) {
		sr.deleteById(id);
	}

	@Override
	public void delete(Subject entity) {
		sr.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<Subject> entities) {
		sr.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		sr.deleteAll();
	}
	
}
