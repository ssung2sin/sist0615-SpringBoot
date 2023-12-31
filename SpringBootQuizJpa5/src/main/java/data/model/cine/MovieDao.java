package data.model.cine;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {
	
	@Autowired
	MovieDaoInter movie;
	
	public Long getCountMovies() {
		return movie.count();
	}
	
	public void insertMovie(MovieDto dto) {
		movie.save(dto);
	}
	
	public List<MovieDto> getAllMovies() {
		return movie.findAll();
	}
	
	public MovieDto getMovie(Long num) {
		return movie.getReferenceById(num);
	}

}
