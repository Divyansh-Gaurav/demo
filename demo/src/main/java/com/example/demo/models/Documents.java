package com.example.demo.models;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "document")
public class Documents {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long docId;
	@Column(name = "doc_name")
	private String docName;
	@Column(name = "doc_type")
	private String docType;
	@Lob
	private byte[] data;
	public Documents(Long docId, String docName, String docType, byte[] data) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.docType = docType;
		this.data = data;
	}
	public Documents(String docName, String docType, byte[] data) {
		super();
		this.docName = docName;
		this.docType = docType;
		this.data = data;
	}
	public Documents() {
		super();
	}
	public Long getDocId() {
		return docId;
	}
	public void setDocId(Long docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Documents [docId=" + docId + ", docName=" + docName + ", docType=" + docType + ", data="
				+ Arrays.toString(data) + "]";
	}
	
}
