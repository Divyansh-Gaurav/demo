package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Files")
public class File {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "file_id")
private Long fileId;
@Column(name = "name")
private String fileName;
@Column(name = "data")
@Lob
private byte[] fileData;
@Column(name = "type")
private String fileType;

@ManyToOne
@JoinColumn(name = "user_id", insertable = true, updatable = false,nullable = false)
private User user;

public File() {
	super();
}
public File(Long fileId, String fileName, byte[] fileData, String fileType, User user) {
	super();
	this.fileId = fileId;
	this.fileName = fileName;
	this.fileData = fileData;
	this.fileType = fileType;
	this.user = user;
}
public File(String fileName, byte[] fileData, String fileType, User user) {
	super();
	this.fileName = fileName;
	this.fileData = fileData;
	this.fileType = fileType;
	this.user = user;
}
public Long getFileId() {
	return fileId;
}
public void setFileId(Long fileId) {
	this.fileId = fileId;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public byte[] getFileData() {
	return fileData;
}
public void setFileData(byte[] fileData) {
	this.fileData = fileData;
}
public String getFileType() {
	return fileType;
}
public void setFileType(String fileType) {
	this.fileType = fileType;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@Override
public String toString() {
	return "Files [fileId=" + fileId + ", fileName=" + fileName + ", fileData=" + fileData + ", fileType=" + fileType
			+ ", user=" + user + "]";
}


}
