package edu.poly.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.spring.domains.Subject;
import edu.poly.spring.exceptions.SubjectNotFoundException;
import edu.poly.spring.services.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
	//Gioi thieu REST va Spring Data REST
	//Phai tai phan mem  postman (getpostman.com)moi chay duoc, google chorone khong ho tro mo
	//ho tro chon GET POST PUT ...
	//Du lieu: Body - raw - JSON
	@Autowired
	private SubjectService ss;
	
	@GetMapping("/{id}/get")
	public Subject get(@PathVariable Long id) {
		Subject s = ss.findById(id)
				.orElseThrow(()->new SubjectNotFoundException());
		return s;
	}
	
	@PostMapping("")
	public Subject insert(@RequestBody Subject s) {
		return ss.save(s);
	}
	
	@GetMapping()
	public List<Subject> getAll() {
		return (List<Subject>) ss.findAll();
	}
	
	@PutMapping("{id}/update")
	public Subject update(@PathVariable Long id, @RequestBody Subject s) {
		return ss.findById(id)
				.map(sub ->{ //map: streaming; lambda expression;  sub: Subject
					sub.setName(s.getName());
					sub.setLogo(s.getLogo());
					return ss.save(s);
				})
				.get();
	}
	
	@GetMapping("/{name}/find")
	public List<Subject> findByName(@PathVariable String name) {
		return ss.findSubjectsByNameContaining(name);
	}
}