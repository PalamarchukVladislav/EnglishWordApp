package org.englishapp.programm.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="words")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Word {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@Column(name="eng_translate")
	private String engTranslate;

	@Column(name="ukr_translate")
	private String ukrTranslate;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
}











