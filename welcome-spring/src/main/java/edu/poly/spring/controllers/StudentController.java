package edu.poly.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.poly.spring.domain.Major;
import edu.poly.spring.domain.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
	@ModelAttribute("majors")
	public List<Major> getMajors(){
		List<Major> list = new ArrayList<>();
		Major m1 = new Major(1, "Java");
		Major m2 = new Major(2, "PHP");
		Major m3 = new Major(3, "C#");
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		return list;
	}
	@GetMapping("")
	public String showForm() {
		return "student-form";
	}
	@PostMapping()
	public String showInfo(HttpServletRequest request, ModelMap model) {
		String name = request.getParameter("name");
		String gpa = request.getParameter("gpa");
		String major = request.getParameter("major");
		
		model.addAttribute("name", name);
		model.addAttribute("gpa", gpa);
		model.addAttribute("major", major);
		return "student-info";
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newStudent() {
		return "students/new";
	}
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String saveStudent() {
		return "students/edit";
	}
	@RequestMapping("/edit")
	public String editStudent() {
		return "students/edit";
	}
	@RequestMapping(value = "/new", params = "btnDelete", method = RequestMethod.POST)
	public String deleteStudent() {
		return "students/delete";
	}
	@RequestMapping(value = "/new", params = "btnList", method = RequestMethod.POST)
	public String listStudents() {
		return "students/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		Student student = new Student();
		student.setName("HuyTP");
		student.setStudentId("ST01");
		student.setMajorId(1);
		model.addAttribute("student",student);
		return "students/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(ModelMap model,Student student) {
		System.out.println("Name: "+ student.getName());
		System.out.println("Major: "+ student.getMajorId());
		
		Student st= new Student();
		model.addAttribute("student",st);
		return "students/add";
	}
	
}
