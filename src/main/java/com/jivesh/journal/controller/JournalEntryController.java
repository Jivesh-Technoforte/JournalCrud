package com.jivesh.journal.controller;

import com.jivesh.journal.entity.JournalEntry;
import com.jivesh.journal.repo.JournalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crud")
public class JournalEntryController {

    private final JournalRepo journalRepo;

    @Autowired
    public JournalEntryController(JournalRepo journalRepo) {
        this.journalRepo = journalRepo;
    }

    // Endpoint to create a new JournalEntry
    @PostMapping("")
    public ResponseEntity<JournalEntry> createJournalEntry(@RequestBody JournalEntry journalEntry) {
        try {
            JournalEntry newJournalEntry = journalRepo.save(journalEntry);
            return ResponseEntity.status(HttpStatus.CREATED).body(newJournalEntry);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Endpoint to get all JournalEntries
    @GetMapping("")
    public ResponseEntity <List <JournalEntry>>getAllJournalEntries() {
		/*
		 * List<JournalEntry> journalEntries = journalRepo.findAll(); return new
		 * ResponseEntity <>("hello",HttpStatus.OK) ;
		 */
    	
		  try { 
			  List<JournalEntry> journalEntries = journalRepo.findAll(); 
				/* System.out.print(journalEntries.get(0).getTitle()); */
		  return new ResponseEntity < > (journalEntries, HttpStatus.OK ) ; } 
		  catch (Exception e) { return
		  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); }
		 
    }
}
 
/* jackson *

















/*
 * package com.jivesh.journal.controller;
 * 
 * import java.util.ArrayList; import java.util.HashMap; import java.util.List;
 * import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.bind.annotation.PathVariable;
 * 
 * import com.jivesh.journal.entity.JournalEntry; import
 * com.jivesh.journal.repo.JournalRepo;
 * 
 * @RestController
 * 
 * @RequestMapping("/add") public class JournalEntryController {
 * 
 * 
 * private Map<Long, JournalEntry> journalEntries = new HashMap<>();
 * 
 * 
 * @GetMapping() public List<JournalEntry> getAll() { return new
 * ArrayList<>(journalEntries.values()); }
 * 
 * 
 * @Autowired JournalRepo repo;
 * 
 * 
 * @PostMapping public void addPerson(@RequestBody JournalEntry myEntry ) {
 * repo. save(myEntry); }
 * 
 * 
 * 
 * @GetMapping("id/{myId}") public JournalEntry
 * getJouranalEntryById(@PathVariable Long myId) { return
 * journalEntries.get(myId); }
 * 
 * @DeleteMapping("id/{myId}") public JournalEntry
 * deleteJouranalEntryById(@PathVariable Long myId) { return
 * journalEntries.remove(myId); }
 * 
 * @PutMapping("id/{myId}") public JournalEntry
 * updateJouranalEntryById(@PathVariable Long myId, @RequestBody JournalEntry
 * myEntry) { return journalEntries.put(myId, myEntry); }
 * 
 * jivesh }
 */