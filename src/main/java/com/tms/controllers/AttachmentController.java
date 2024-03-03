package com.tms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tms.entities.Attachment;
import com.tms.repositories.AttachmentRepository;
import com.tms.response.AppResponse;


@RestController
@RequestMapping("/api/attachments")
public class AttachmentController {

	
	@Autowired
	AttachmentRepository repo;
	
	
	@PostMapping("/post")
	public ResponseEntity<AppResponse> addAttachment(@RequestBody  Attachment attachment) {
		repo.save(attachment);
		AppResponse resp = new AppResponse("POSTSUCCESS", "Attachment Added"); 
		return new ResponseEntity<AppResponse>(resp,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Attachment>> getAllAttachment() {
		List<Attachment> list  = repo.findAll();
		return new ResponseEntity<List<Attachment>>(list,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public Attachment getAttachment(@PathVariable int id) {
		return repo.findById(id).get();
	}
	
}
