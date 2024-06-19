/*package com.jivesh.journal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jivesh.journal.entity.JournalEntry;

@RepositoryRestResource
public interface JournalRepo extends JpaRepository<JournalEntry,Long>{

}
*/


package com.jivesh.journal.repo;



import com.jivesh.journal.entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepo extends JpaRepository<JournalEntry, Long> {
    // Custom queries if needed
}

