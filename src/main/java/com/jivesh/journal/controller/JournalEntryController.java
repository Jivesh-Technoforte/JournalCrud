package com.jivesh.journal.controller;

import com.jivesh.journal.entity.JournalEntry;
import com.jivesh.journal.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crud")
public class JournalEntryController {

    JournalEntryService journalEntryService;

    @Autowired
    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    // create a new JournalEntry
    @PostMapping("")
    public ResponseEntity<JournalEntry> createJournalEntry(@RequestBody JournalEntry journalEntry) {
        JournalEntry newJournalEntry = journalEntryService.createJournalEntry(journalEntry);
        return  ResponseEntity.status(HttpStatus.CREATED).body(newJournalEntry);
    }

    // get all JournalEntries
    @GetMapping("")
    public ResponseEntity<List<JournalEntry>> getAllJournalEntries() {
        List<JournalEntry> journalEntries = journalEntryService.getAllJournalEntries();
        return ResponseEntity.ok(journalEntries);
    }

    // get a JournalEntry by ID
    @GetMapping("/{id}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable Long id) {
        Optional<JournalEntry> journalEntry = journalEntryService.getJournalEntryById(id);
        return journalEntry.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // update a JournalEntry
    @PutMapping("/{id}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable Long id, @RequestBody JournalEntry journalEntry) {
        JournalEntry updatedJournalEntry = journalEntryService.updateJournalEntry(id, journalEntry);
        return updatedJournalEntry != null ?
                ResponseEntity.ok(updatedJournalEntry) :
                ResponseEntity.notFound().build();
    }

    // delete a JournalEntry
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJournalEntry(@PathVariable Long id) {
        journalEntryService.deleteJournalEntry(id);
        return ResponseEntity.noContent().build();
    }
}



