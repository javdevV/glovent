package tn.edu.glovent.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Thread implements Serializable{

	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Id
	private Integer threadId;
	private Forum ParentForum;
	private User CommentingUser;
	private String title;
	private String threadContent;

	
	public Thread(){
		System.out.println("thread constructor fired : zero-argument [DEV][OK]");
	}
		public Thread(String title,String content){
			this.title=title;
			this.threadContent=content;
			System.out.println("Thread entitled:\""+this.title+"\" has been successfully appended to the discussion. [OK]\n");
		}
	public Forum getParentForum() {
		return ParentForum;
	}
	public void setParentForum(Forum parentForum) {
		ParentForum = parentForum;
	}
	public User getCommentingUser() {
		return CommentingUser;
	}
	public void setCommentingUser(User commentingUser) {
		CommentingUser = commentingUser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Object getThreadContent() {
		return threadContent;
	}
	public void setThreadContent(String threadContent) {
		this.threadContent = threadContent;
	}
	
	
}
