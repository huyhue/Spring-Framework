package edu.poly.spring.services;

import java.util.List;
import java.util.Optional;

import edu.poly.spring.domains.Subject;

public interface SubjectService {

	void deleteAll();

	void deleteAll(Iterable<Subject> entities);

	void delete(Subject entity);

	void deleteById(Long id);

	long count();

	Iterable<Subject> findAllById(Iterable<Long> ids);

	List<Subject> findAll();

	boolean existsById(Long id);

	Optional<Subject> findById(Long id);

	Iterable<Subject> saveAll(Iterable<Subject> entities);

	Subject save(Subject entity);

	List<Subject> findSubjectsByNameContaining(String name);

}