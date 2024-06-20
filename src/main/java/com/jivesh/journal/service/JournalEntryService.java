package com.jivesh.journal.service;

import com.jivesh.journal.entity.JournalEntry;
import com.jivesh.journal.repo.JournalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    private final JournalRepo journalRepo;

    @Autowired
    public JournalEntryService(JournalRepo journalRepo) {
        this.journalRepo = journalRepo;
    }

    // Service method to create a new JournalEntry
    public JournalEntry createJournalEntry(JournalEntry journalEntry) {
        return journalRepo.save(journalEntry);
    }

    // Service method to get all JournalEntries
    public List<JournalEntry> getAllJournalEntries() {
        return journalRepo.findAll();
    }

    // Service method to get a JournalEntry by ID
    public Optional<JournalEntry> getJournalEntryById(Long id) {
        return journalRepo.findById(id);
    }

    // Service method to update a JournalEntry
    public JournalEntry updateJournalEntry(Long id, JournalEntry journalEntry) {
        if (journalRepo.existsById(id)) {
            journalEntry.setId(id); // Ensure the ID matches the entity being updated
            return journalRepo.save(journalEntry);
        }
        return null; // or throw exception indicating not found
    }

    // Service method to delete a JournalEntry
    public void deleteJournalEntry(Long id) {
        journalRepo.deleteById(id);
    }
}
