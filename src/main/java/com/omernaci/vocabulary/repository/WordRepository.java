package com.omernaci.vocabulary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omernaci.vocabulary.model.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

}
