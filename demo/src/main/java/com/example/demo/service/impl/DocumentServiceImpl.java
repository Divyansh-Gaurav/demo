package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Documents;
import com.example.demo.repository.DocRepository;
import com.example.demo.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	DocRepository docRepo;

	@Override
	public Documents saveFile(MultipartFile file) {
		try {
			Documents doc = new Documents(file.getOriginalFilename(), file.getContentType(), file.getBytes());
			return docRepo.save(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Optional<Documents> getDoc(Long id) {		
		return docRepo.findById(id);
	}

}
