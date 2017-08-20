package com.example;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

    @Id
	private long id;
	private String name;

	@OneToMany
	private List<Mail> mail;

	public Department() {
		super();
	}

	public Department(long id, String name, List<Mail> mail) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Mail> getMail() {
		return mail;
	}

	public void setMail(List<Mail> mail) {
		this.mail = mail;
	}

	public boolean hasSkill(Mail skill) {
		for (Mail containedSkill: getMail()) {
			if (containedSkill.getMailId() == skill.getMailId()) {
				return true;
			}
		}
		return false;
	}

}
