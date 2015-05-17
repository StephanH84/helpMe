package com.stephan.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "QUESTIONS")
public class Question extends NamedEntity {

    @Column(name = "text")
	private String text;

    @Column(name = "votes")
	private Integer votes;
	
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
          name="Question_Category",
          joinColumns=@JoinColumn(name="questionId")
    )
    private Set<Category> categories = new HashSet<Category>();

    @OneToOne
    @JoinColumn(name = "userId")
    private User author;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
          name="Question_Answer",
          joinColumns=@JoinColumn(name="questionId")
    )
    private Set<Answer> answers = new HashSet<Answer>();
    
    @Column(name = "birth_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private DateTime date;
    
	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

    
	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

    
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}	
}
