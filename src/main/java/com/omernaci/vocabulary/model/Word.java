package com.omernaci.vocabulary.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TBL_WORDS")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
					allowGetters = true)
public class Word implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	@NotEmpty
	private String wordEn;
	
	@Column
	@NotEmpty
	private String wordTr;
	
	@Column
	@NotEmpty
	private String sampleSentenceEn;
	
	@Column
	@NotEmpty
	private String sampleSentenceTr;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWordEn() {
		return wordEn;
	}

	public void setWordEn(String wordEn) {
		this.wordEn = wordEn;
	}

	public String getWordTr() {
		return wordTr;
	}

	public void setWordTr(String wordTr) {
		this.wordTr = wordTr;
	}

	public String getSampleSentenceEn() {
		return sampleSentenceEn;
	}

	public void setSampleSentenceEn(String sampleSentenceEn) {
		this.sampleSentenceEn = sampleSentenceEn;
	}

	public String getSampleSentenceTr() {
		return sampleSentenceTr;
	}

	public void setSampleSentenceTr(String sampleSentenceTr) {
		this.sampleSentenceTr = sampleSentenceTr;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}