package webadv.s16202234.entity;

import javax.validation.constraints.Pattern;

public class User {
	@Pattern(regexp="[a-z]{3}",message="������3����ĸ")
	private String account;
	@Pattern(regexp="[0-9|]{6}",message="������6λ����")
	private String password;	
	public String getAccount() {
		return account;
	}	
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}
