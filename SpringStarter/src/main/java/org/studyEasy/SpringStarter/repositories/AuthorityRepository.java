package org.studyEasy.SpringStarter.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studyEasy.SpringStarter.Models.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    
}
