package tn.edu.glovent.persistence;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
	private int idUser;
	private String fName;
	private String lName;
	private String login;
	private String pwd;
	//private String asociation;
	private String email;
	private int age;
	private String adress;
	private String image;
	private boolean AccountState;
	@ManyToMany(mappedBy="listeP")
	private List<Event> listeE ;
	
	
	@OneToMany(mappedBy="MyUser")
	private List<Complaint> MyComplaints;
	
	
	
	
	@ManyToMany(mappedBy="listUsers")
	private List<Organization> listOrganization ;
	
	
	
	
	
	
	
	
	
	
	public User() {
		super();
	}
	public User(int idUser, String fName, String lName, String login, String pwd, String asociation, String email,
			int age, String adress, String image, boolean accountState, List<Event> listeE) {
		super();
		this.idUser = idUser;
		this.fName = fName;
		this.lName = lName;
		this.login = login;
		this.pwd = pwd;
		
		this.email = email;
		this.age = age;
		this.adress = adress;
		this.image = image;
		AccountState = accountState;
		this.listeE = listeE;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isAccountState() {
		return AccountState;
	}
	public void setAccountState(boolean accountState) {
		AccountState = accountState;
	}
	public List<Event> getListeE() {
		return listeE;
	}
	public void setListeE(List<Event> listeE) {
		this.listeE = listeE;
	}
	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + ", login=" + login + ", pwd=" + pwd + ", email=" + email
				+ ", age=" + age + ", adress=" + adress + ", image=" + image + ", AccountState=" + AccountState
				+ ", listeE=" + listeE + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
}