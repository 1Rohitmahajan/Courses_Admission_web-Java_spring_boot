package com.springrest.springrest.controller;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.Courseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@CrossOrigin("*")
@RestController     //Rest controller mean Rest service data sendjson format and xml
public class MyController {
	@Autowired
	private Courseservice  courseService;
	
	@GetMapping("/home")
	public String home()
	{
		return "this is home site";
	}
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
		
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return this.courseService.addCourse(course);
	}
	 
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course)
	{
		return this.courseService.updateCourse(course);
	}
	
	
    @DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
    	 try
    	 {
    		 this.courseService.deleteCourse(Long.parseLong(courseId));
    		 return new ResponseEntity<>(HttpStatus.OK);
    		 
    	 }
    	 catch (Exception e) {
    		 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    		 
    	 }
		
	}
	
	
}









