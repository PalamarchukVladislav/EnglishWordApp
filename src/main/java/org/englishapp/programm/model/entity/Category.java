package org.englishapp.programm.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="category_name")
	private String categoryName;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private List<Word> words = new ArrayList<>();


	public void addWord(final Word word){

		words.add(word);

		word.setCategory(this);
	}

}











