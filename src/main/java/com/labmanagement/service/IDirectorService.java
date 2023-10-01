package com.labmanagement.service;

import com.labmanagement.model.dao.DirectorDTO;
import com.labmanagement.model.entity.Director;

import java.util.List;

public interface IDirectorService {
	List<DirectorDTO> getAllDirectors();

	DirectorDTO getDirectorById(Long id);

	DirectorDTO saveDirector(Director director);

	void deleteDirector(Long id);

	DirectorDTO updateDirector(Long id, Director director);
}
