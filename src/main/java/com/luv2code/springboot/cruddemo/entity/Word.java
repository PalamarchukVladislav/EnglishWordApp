package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.*;

@Entity
@Table(name="words")
public class Word {

	// define fields

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="english_translate")
	private String englishTranslate;

	@Column(name="ukrainian_translate")
	private String ukrainianTranslate;

	@Column(name="category_id")
	private String categoryId;


	// define constructors

	public Word() {

	}

	public Word(String englishTranslate, String ukrainianTranslate, String categoryId) {
		this.englishTranslate = englishTranslate;
		this.ukrainianTranslate = ukrainianTranslate;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnglishTranslate() {
		return englishTranslate;
	}

	public void setEnglishTranslate(String englishTranslate) {
		this.englishTranslate = englishTranslate;
	}

	public String getUkrainianTranslate() {
		return ukrainianTranslate;
	}

	public void setUkrainianTranslate(String ukrainianTranslate) {
		this.ukrainianTranslate = ukrainianTranslate;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Word{" +
				"id=" + id +
				", englishTranslate='" + englishTranslate + '\'' +
				", ukrainianTranslate='" + ukrainianTranslate + '\'' +
				", categoryId='" + categoryId + '\'' +
				'}';
	}
}











