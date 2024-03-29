package org.englishapp.programm.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
@Data
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="category_name")
	private String categoryName;

	@OneToMany(mappedBy = "category")
	@JsonManagedReference
	private List<Word> words = new ArrayList<>();


//	public void addWord(final Word word){
//
//		words.add(word);
//
//		word.setCategory(this);
//	}

}











