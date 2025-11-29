package org.studyEasy.SpringStarter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.studyEasy.SpringStarter.Models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    
    
}
