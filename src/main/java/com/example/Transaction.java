package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	public Transaction() {
		super();
    }
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
    private String mailId;
    private String status;
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

   


    
}
