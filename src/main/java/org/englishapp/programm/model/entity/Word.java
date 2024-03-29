package org.englishapp.programm.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="words")
@Data
public class Word {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	@Column(name="eng_translate")
	private String engTranslate;

	@Column(name="ukr_translate")
	private String ukrTranslate;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonBackReference
	private Category category;
}











