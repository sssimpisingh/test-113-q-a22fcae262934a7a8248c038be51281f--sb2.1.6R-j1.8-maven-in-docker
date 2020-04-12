package org.codejudge.sb.controller;

import java.util.List;
import java.util.Optional;

import org.codejudge.sb.dao.QuestionsDao;
import org.codejudge.sb.dao.QuizDao;
import org.codejudge.sb.model.Questions;
import org.codejudge.sb.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")
public class AppController {

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionsDao questionsDao;

	@ApiOperation("get quiz by quiz id api")
	@GetMapping("quiz/{quiz_id}")
	public ResponseEntity<?> getquizById(@PathVariable int quiz_id) {
		Optional<Quiz> result = quizDao.findById(quiz_id);
		if (!result.isPresent())
			return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
		else {
			Quiz quiz = quizDao.findById(quiz_id).get();
			return new ResponseEntity<Quiz>(quiz, HttpStatus.OK);
		}
	}

	@ApiOperation("create new quiz api")
	@PostMapping("quiz/")
	public ResponseEntity<?> addquizs(@RequestBody Quiz quiz) {
		Quiz savequiz = quizDao.save(quiz);
		return new ResponseEntity<Quiz>(savequiz, HttpStatus.CREATED);
	}

	@ApiOperation("get questions by questionId api")
	@GetMapping("questions/{question_id}")
	public ResponseEntity<?> getQuestionsById(@PathVariable int question_id) {
		Optional<Questions> result = questionsDao.findById(question_id);
		if (!result.isPresent()) {
			return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
		} else {
			Questions questions = result.get();
			return new ResponseEntity<Questions>(questions, HttpStatus.OK);
		}
	}

	@ApiOperation("create new questions api")
	@PostMapping("questions/")
	public ResponseEntity<?> addQuestions(@RequestBody Questions questions) {
		Questions saveQuestions = questionsDao.save(questions);
		return new ResponseEntity<Questions>(saveQuestions, HttpStatus.CREATED);
	}

	@ApiOperation("get questions by questionId api")
	@GetMapping("quiz-questions/{quiz_id}")
	public ResponseEntity<?> getQuestionsByQuizId(@PathVariable("quiz_id") int quizid) {
		List<Questions> questions = questionsDao.findAllByQuiz(quizid);
		if (questions.isEmpty())
			return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Questions>>(questions, HttpStatus.OK);

	}

}
