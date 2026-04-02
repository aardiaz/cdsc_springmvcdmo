package com.cdsc.spirngmvcdemo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import com.cdsc.spirngmvcdemo.model.Employee;
import com.cdsc.spirngmvcdemo.model.Post;
import com.cdsc.spirngmvcdemo.repository.PostRepository;
import com.cdsc.spirngmvcdemo.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/api/emp/list")
	public List<Employee> getEmployee() {
		
		return empService.getAllEmps();
	}
	
	@PostMapping("/api/emp/add")
	public String saveEmployee(@RequestBody  Employee emp) {
		
		empService.addEmp(emp);
		return "added Success";
	}
	
	@GetMapping("/api/emp/{id}")
	public Employee  getOneEmployee(@PathVariable("id") long id) {
		
		return empService.getEmpById(id);
	}
	
	@PutMapping("/api/emp/update")
	public String updateEmployee(@RequestBody  Employee emp) {
		
		empService.updateEmp(emp);
		return "update success";
	}
	
	@DeleteMapping("/api/emp/delete/{id}")
	public String deleteEmployee(@PathVariable("id") long id) {

		 empService.deleteEmp(id);
		 
		return "delete success";
	}
	
	@Autowired
	private PostRepository postRepo;
	
	@GetMapping("/api/emp/load")
	public String getLoadPosts() {
		
		RestTemplate temp = new RestTemplate();	
		Post[]   posts = temp.getForObject("https://jsonplaceholder.typicode.com/posts", Post[].class);
		
		postRepo.saveAll(List.of(posts));
		
		return "data loaded success";
	}
	
	@GetMapping("/api/emp/posts")
	public ResponseEntity<List<Post>> getPosts(@RequestParam(defaultValue = "0", value = "pageNo") int pageNo,@RequestParam(defaultValue = "20", value = "pageSize") int pageSize) {

		Pageable  pageable = PageRequest.of(pageNo, pageSize);
		
		List<Post> posts = postRepo.findAll(pageable).getContent();

		return ResponseEntity.ok(posts);
	}

}
