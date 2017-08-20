package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mail {
    @Id
	private String mailId;
    
	private long id;

	public Mail(String mailId, long id) {
		super();
		this.mailId = mailId;
		this.id = id;
	}
    
    public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	public long getId() {
			return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Mail() {
		super();
    }

}
