package com.deepak.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.deepak.Entity.StudentEntity;
import com.deepak.Repository.StudentRepository;
import com.deepak.binding.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository stuRepo;

	// this method save form data into student
	// this method only to display index page
	@GetMapping("/")
	public String laodForm(Model model) {   // model object used to send data To UI
		handleSubmittedFormData(model);
		return "index";
	}

	
	
	
	// method to save student data into db
	@PostMapping("/save")
	public String handleSubmittedFormData(Student s, Model model) {

		// copy Student class properties into StudentEntity class...

		StudentEntity entity = new StudentEntity();

		// set Timings manually bcz array object not able to copy one class to anther
		entity.setTimings(Arrays.toString(s.getTimings()));

		// copy s => StudentEntity
		BeanUtils.copyProperties(s, entity);

		stuRepo.save(entity);
		System.out.println(s);
		// to send the data to UI USE Model object
//		Student student1 = new Student();
		handleSubmittedFormData(model); // to display the model object data in UI like course ,timings and student
		model.addAttribute("msg", "student saved in db");
		return "index";
	}

	
	
	
	
	// common method // SET MODEL object data which displayed in UI
	private void handleSubmittedFormData(Model model) {
		List<String> coursesList = new ArrayList<>();
		coursesList.add("java");
		coursesList.add("devtools");
		coursesList.add("Aws");
		coursesList.add("python");

		List<String> timingsList = new ArrayList<>();
		timingsList.add("Morning");
		timingsList.add("afternoon");
		timingsList.add("evening");

		// to send the data to UI USE Model object

//		Student student1 = new Student();

		// set courselist with model
		model.addAttribute("courses", coursesList);

		// set timingsList with model
		model.addAttribute("timings", timingsList);

		// set student bind to the form
		model.addAttribute("student", new Student()); // this is require bind form data to this object ...   
	}
	// method to display saved student data

	
	
	
	//////
	
	// method to display stored STUDENT DATA TO user 
	
	@GetMapping("viewStudents")
	public String getStudentsData(Model model) {
		
		// logic to fetch and send 
		
		//get data
		List<StudentEntity> studentsList = stuRepo.findAll();
		
		// send data to UI
		model.addAttribute("students", studentsList);  
		
		return "data";
	}
	
}
