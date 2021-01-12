package com.example.demo.service;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Documents;

public interface DocumentService {
 Documents saveFile(MultipartFile file);
 Optional<Documents> getDoc(Long id);
}
