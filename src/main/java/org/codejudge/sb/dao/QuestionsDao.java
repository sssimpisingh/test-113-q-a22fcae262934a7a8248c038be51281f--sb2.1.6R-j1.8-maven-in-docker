package org.codejudge.sb.dao;

import java.util.List;

import org.codejudge.sb.model.Questions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface QuestionsDao extends CrudRepository<Questions, Integer> {

	List<Questions> findAllByQuiz(int quizid);

}
