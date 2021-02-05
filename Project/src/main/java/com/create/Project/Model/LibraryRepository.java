package com.create.Project.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.create.Project.Entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{

}
