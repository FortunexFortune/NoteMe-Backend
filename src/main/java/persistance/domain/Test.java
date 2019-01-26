package persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Test {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long testID;
	private String speedTest;
	private String userName;
	
	public Test(){
	}
	
	public Test(String speedTest) {
		this.speedTest = speedTest;
		
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getSpeedTest() {
		return speedTest;
	}
	public void setSpeedTest(String speedTest) {
		this.speedTest = speedTest;
	}

}
