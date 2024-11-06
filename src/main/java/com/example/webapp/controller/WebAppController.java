package com.example.webapp.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

import com.example.webapp.model.Employee;
import com.example.webapp.model.Shirt;

//@RestController
@Controller
public class WebAppController {
	
	
	
	@GetMapping (value="/list")
	
	public List<Employee> lists() {
		Employee e1 = new Employee("Ananth",100);
		Employee e2 = new Employee("Siran",101);
		
		ArrayList<Employee> emp=new ArrayList<>();
		emp.add(e1);
		emp.add(e2);
		return emp.stream().collect(Collectors.toList());
		
	}
	
	@GetMapping (value="/get")
	public String getword() {
		return "sample.html";
	}
	
	
	
	@GetMapping(value="/add")
    public int getnum() {
		int a = 10;
		int b = 20;
		return a+b;
	}
	
	@GetMapping(value="/getName/{a}")
	public String name(@PathVariable String a) {
		return a;
	}
	
	@GetMapping(value="/find/{num1}/{num2}")
	public int finds(@PathVariable int num1,@PathVariable int num2) {
		if(num1>num2) {
			return num1;
		}else {
			return num2;
		}
	}
	
	@GetMapping(value="/prime/{num1}/{num2}")
	public int counts (@PathVariable int num1, @PathVariable int num2) {
		
		int count=0;
		for(int i=num1;i<=num2;i++) {
			boolean isPrime=true;
			for(int j=2;j<=i/2;j++) {
				if(i%j==0) {
		          isPrime=false;
				}
			}
		if(isPrime==true) {
			count=count+1;
		}
		}
		return count;	
	}
	
	@GetMapping (value="/getShirt")
	public Shirt getDetails(@RequestBody Shirt s) {
		return s;
	}
	
	@GetMapping (value="/getShirts")
	public String getDetail(@RequestBody Shirt v) {
		return v.getFabric();
	}
	
	@GetMapping (value="/discount")
	public Shirt dis(@RequestBody Shirt v) {
		if(v.getisChecked()==true) {
			v.setPrice(v.getPrice()-v.getPrice()*5/100);
		}else {
			v.setPrice(v.getPrice()+v.getPrice()*5/100);
		}
		return v;
	}
	
	@GetMapping (value="/Shirts")
	public List<Shirt> getDetails(@RequestBody List<Shirt> s) {
		return  s;
	}
	
	@GetMapping (value="/Shirts1")
	public Shirt getShirt1(@RequestBody List<Shirt> s) {
		return  s.get(1);
	}
	
	@GetMapping (value="/ShirtsName")
	public List <String> getShirtName(@RequestBody List<Shirt> s) {
		return  s.stream().map(x->x.getBrand()).sorted().collect(Collectors.toList());
	}
	
	@GetMapping (value="/ShirtsMax")
	public int getShirt2nd(@RequestBody List<Shirt> s) {
		return  s.stream().map(x->x.getPrice()).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
	}
	
	@GetMapping(value="/getAccess")
	public String getThis(@RequestParam String name,@RequestParam String password) {
		if(name.equals("Nisha")&& password.equals("Nisha123")) {
			return "Accessed successfully";
		}else {
			return "Access denied";
		}
	}
}
