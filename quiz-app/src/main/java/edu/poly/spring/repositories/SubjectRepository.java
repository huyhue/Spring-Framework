package edu.poly.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.poly.spring.domains.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long>{
	List<Subject> findSubjectsByNameContaining(String name);
}
