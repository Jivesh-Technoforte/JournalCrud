package com.jivesh.journal.service;

import com.jivesh.journal.entity.JournalEntry;
import com.jivesh.journal.repo.JournalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    private  JournalRepo journalRepo;

    @Autowired
    public JournalEntryService(JournalRepo journalRepo) {
        this.journalRepo = journalRepo;
    }

    // constructor
    public JournalEntry createJournalEntry(JournalEntry journalEntry) {
        return journalRepo.save(journalEntry);
    }

    // get all JournalEntries
    public List<JournalEntry> getAllJournalEntries() {
        return journalRepo.findAll();
    }

    // get a JournalEntry by ID
    public Optional<JournalEntry> getJournalEntryById(Long id) {
        return journalRepo.findById(id);
    }

    // update a JournalEntry
    public JournalEntry updateJournalEntry(Long id, JournalEntry journalEntry) {
        if (journalRepo.existsById(id)) {
            journalEntry.setId(id); // Ensure the ID matches the entity being updated
            return journalRepo.save(journalEntry);
        }
        return null; // throws exception indicating not found
    }

    // delete a JournalEntry
    public void deleteJournalEntry(Long id) {
        journalRepo.deleteById(id);
    }
}
