package com.jivesh.journal.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class JournalEntry {
	@Id
	private long id ;
	
	private String title ;
	
	private String content ;
	
	
	/*
	 * public long getId() { return id; } public void setId(long id) { this.id = id;
	 * } public String getTitle() { return title; } public void setTitle(String
	 * title) { this.title = title; } public String getContent() { return content; }
	 * public void setContent(String content) { this.content = content; }
	 */
	 

}
