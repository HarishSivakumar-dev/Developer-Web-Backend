package com.harish.developer.app.v1.model;

import java.util.List;

import com.harish.developer.app.v1.dtos.Recipient;
import com.harish.developer.app.v1.dtos.ReplyTo;
import com.harish.developer.app.v1.dtos.Sender;

public class SenderModel
{
	private Sender sender;
	private List<Recipient> to;
	private ReplyTo replyTo;
	private String subject;
	private String textContent;
	
	public Sender getSender() {
		return sender;
	}
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	public List<Recipient> getTo() {
		return to;
	}
	public void setTo(List<Recipient> to) {
		this.to = to;
	}
	public ReplyTo getReplyTo() {
		return replyTo;
	}
	public void setReplyTo(ReplyTo replyTo) {
		this.replyTo = replyTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTextContent() {
		return textContent;
	}
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	
}
