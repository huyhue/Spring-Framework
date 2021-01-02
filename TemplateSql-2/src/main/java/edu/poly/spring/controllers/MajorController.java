package edu.poly.spring.controllers;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.poly.spring.models.Major;

@Controller
public class MajorController {
	@Autowired
	private EntityManagerFactory emf;

	@GetMapping("/list")
	@Transactional
	public String list() {
		Session session = emf.createEntityManager().unwrap(Session.class);
		String hql = "from Major";
		Query<Major> query = session.createQuery(hql);
		List<Major> list = query.list();
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Major major = (Major) iterator.next();
			System.out.println("============Name: " + major.getName());
		}
		return "list";
	}
	
	@Transactional
	@GetMapping("/find")
	public String find(@RequestParam String name) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		//http://localhost:8080/find?name=p
		Query query = session.createQuery("from Major a where a.name like :name");
		query.setParameter("name", "%" + name + "%");
		
		List<Major> list = query.list();
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Major major = (Major) iterator.next();
			System.out.println("Name: "+major.getName());
		}
		return "list";
	}
	@Transactional
	@GetMapping("/search")
	public String search(@RequestParam String name) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		//http://localhost:8080/search?name=
		Query query = session.createQuery("select a.id from Major a where a.name like :name");
		query.setParameter("name", "%" + name + "%");
		
		List<Integer[]> list = query.list();
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Integer major = (Integer) iterator.next();
			System.out.println("Major ID: " + major.toString());
		}
		return "list";
	}
	@Transactional
	@GetMapping("/insert")
	public String insert(@RequestParam String name) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		
		Major major = new Major();
		major.setName(name);
		
		session.save(major);
		System.out.println("Complete!!!");
		return "list";
	}
}
