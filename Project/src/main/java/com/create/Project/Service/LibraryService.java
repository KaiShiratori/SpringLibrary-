package com.create.Project.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.create.Project.Entity.Library;
import com.create.Project.Model.LibraryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LibraryService {

	@Autowired
	private final LibraryRepository libraryRepository;

	public List<Library> findAll() {
		return libraryRepository.findAll();
	}

	public Library save(String name, String status, Date startdate) {
		return libraryRepository.save(Library.newLibrary(name, status, startdate));
	}

	public void save(Library request) {
		libraryRepository.save(request);
	}

	public Library findbyid(Long id) {
		Optional<Library> lib = libraryRepository.findById(id);
		return lib.get();
	}

	public void delete(Library request) {
		libraryRepository.delete(request);
	}

	public void delete(Long id) {
		libraryRepository.deleteById(id);
	}

}
