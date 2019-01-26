package persistance.domain;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id
	private String userName;
	private String pwd;
	
	@OneToMany(mappedBy="userName", cascade=CascadeType.ALL)
	private List<Test> tets = new ArrayList<>();;


	public Account() {
		
	}
	public Account(String userName, String pwd) {
		this.userName = userName;
		this.pwd = pwd;
		}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


}
