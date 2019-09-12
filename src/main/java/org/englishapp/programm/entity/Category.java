package org.englishapp.programm.entity;

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

	@OneToMany(mappedBy = "category",
			cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Word> words;

	public void addWord(Word word){

		if (words == null){
			words = new ArrayList<>();
		}

		words.add(word);

		word.setCategory(this);
	}
}











