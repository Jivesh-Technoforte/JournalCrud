package com.jivesh.journal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "journal_entries")
public class JournalEntry {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    
    @Column(nullable = false)
    private String title;
    
   
    @Column(nullable = false)
    private String content;



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	/*
	 * public long getId() { return id; } public void setId(long id) { this.id = id;
	 * } public String getTitle() { return title; } public void setTitle(String
	 * title) { this.title = title; } public String getContent() { return content; }
	 * public void setContent(String content) { this.content = content; }
	 */
	 

}
