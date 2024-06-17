package com.jivesh.journal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jivesh.journal.entity.JournalEntry;

@RestController
@RequestMapping("/crud")
public class JournalEntryController {
	
	private Map<Long, JournalEntry> journalEntries= new HashMap<>();
	
	@GetMapping()
	public List<JournalEntry> getAll(){
		return new ArrayList<>(journalEntries.values());
		}
 @PutMapping()
	public boolean createEntry(@RequestBody JournalEntry myEntry) {
		journalEntries.put(myEntry.getId(),myEntry);
		return true;
	}
	
}
