/*
 * package com.jivesh.journal.entity;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.stereotype.Indexed;
 * 
 * import io.micrometer.common.lang.NonNull; import jakarta.annotation.Nonnull;
 * import jakarta.persistence.Entity; import jakarta.persistence.Id; import
 * lombok.Data;
 * 
 * @Data
 * 
 * @Entity public class user {
 * 
 * @Id private long id;
 * 
 * @NonNull private String username;
 * 
 * @Nonnull private String password ;
 * 
 * @DBRef private List <JournalEntry> journalEntries = new ArrayList<>();
 * 
 * 
 * }
 */