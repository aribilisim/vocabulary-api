package com.omernaci.vocabulary.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omernaci.vocabulary.exception.ResourceNotFoundException;
import com.omernaci.vocabulary.model.Word;
import com.omernaci.vocabulary.repository.WordRepository;

@RestController
@RequestMapping("/api")
public class WordController {
	
	@Autowired
	WordRepository wordRepository;
	
	// Get all words
	@GetMapping("/words")
	public List<Word> getAllWords() {
		return wordRepository.findAll();
	}
	
	// Create new word
	@PostMapping("/words")
	public Word createWord(@Valid @RequestBody Word word) {
		return wordRepository.save(word);
	}
	
	// Get a single word
	@GetMapping("/words/{id}")
	public Word getWordById(@PathVariable(value = "id") Long wordId) {
		return getWordByIdFromRepository(wordId);
	}

	// Update a word
	@PutMapping("/words/{id}")
	public Word updateWord(@PathVariable(value = "id") Long wordId,
						   @Valid @RequestBody Word wordDetails) {
		
		Word word = getWordByIdFromRepository(wordId);
		
		word.setWordEn(wordDetails.getWordEn());
		word.setWordTr(wordDetails.getWordTr());
		word.setSampleSentenceEn(wordDetails.getSampleSentenceEn());
		word.setSampleSentenceTr(wordDetails.getSampleSentenceTr());
		
		Word updatedWord = wordRepository.save(word);
		
		return updatedWord;
	}
	
	// Delete a word
	@DeleteMapping("/words/{id}")
	public ResponseEntity<String> deleteWord(@PathVariable(value = "id") Long wordId) {
		
		wordRepository.delete(getWordByIdFromRepository(wordId));
		
		return ResponseEntity.ok().build();
		
	}
	
	private Word getWordByIdFromRepository(Long wordId) {
		return wordRepository.findById(wordId)
				.orElseThrow(() -> new ResourceNotFoundException("Word", "id", wordId));
	}

}
