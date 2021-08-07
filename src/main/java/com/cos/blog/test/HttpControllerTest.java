package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가요청 -> 응답(html 파일)
// @Controller

// 사용자가 요청 -> 응답 (data)
@RestController
public class HttpControllerTest {
	
	// http://localhost:8080/http/get (select) - query string
	@GetMapping("/http/get")
	public String getTest(@RequestParam String id ) { // id=1
		return "get 요청: " + id;
	}
	
	@GetMapping("/http/get2")
	public String getTest2(Member m ) { // id=1&username=ljm123&password=123456&email=ssar@nate.com
		return "get 요청: " + m.getId()  + ", " + m.getUsername() + ",  " + m.getPassword() + ",  " + m.getEmail();
	}
	
	// http://localhost:8080/http/post (insert)  - x-www-form-urlencoded 형식
	@PostMapping("/http/post")
	public String postTest(Member m) {
		return "post 요청 : " + m.getId()  + ", " + m.getUsername() + ",  " + m.getPassword() + ",  " + m.getEmail();
	}

	// http://localhost:8080/http/post2 (insert) -  raw (text) 형식  - mime type이 text/plain 이다
	@PostMapping("/http/post2")
	public String postTest2(@RequestBody String text) {
		return "post 요청 : " + text;
	}
	
	// http://localhost:8080/http/post3 (insert) - raw (text) 형식 - mime type이 application/json 이다
	@PostMapping("/http/post3")
	public String postTest3(@RequestBody Member m) { // MessageConvert (스프링부트) 가 json 매핑해준다
		return "post 요청 : " + m.getId()  + ", " + m.getUsername() + ",  " + m.getPassword() + ",  " + m.getEmail();
	}
	
	// http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : "+ m.getId()  + ", " + m.getUsername() + ",  " + m.getPassword() + ",  " + m.getEmail();
	}
	// http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest(@RequestBody Member m) {
		return "delete 요청: " + m.getId()  + ", " + m.getUsername() + ",  " + m.getPassword() + ",  " + m.getEmail();
	}
}
 