package org.codejudge.sb.dao;

import org.codejudge.sb.model.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface QuizDao extends CrudRepository<Quiz, Integer>{

}
