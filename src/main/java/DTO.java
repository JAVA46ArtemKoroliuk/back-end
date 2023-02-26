import java.util.Arrays;

public class DTO {
	public String userName;
	public String password;
	public String experation;
	public String [] rules;
	
public DTO(){
	
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((experation == null) ? 0 : experation.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + Arrays.hashCode(rules);
	result = prime * result + ((userName == null) ? 0 : userName.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DTO other = (DTO) obj;
	if (experation == null) {
		if (other.experation != null)
			return false;
	} else if (!experation.equals(other.experation))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	if (!Arrays.equals(rules, other.rules))
		return false;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	return true;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getExperation() {
	return experation;
}

public void setExperation(String experation) {
	this.experation = experation;
}

public String[] getRules() {
	return rules;
}

public void setRules(String[] rules) {
	this.rules = rules;
}

public DTO(String userName, String password, String experation, String[] rules) {
	super();
	this.userName = userName;
	this.password = password;
	this.experation = experation;
	this.rules = rules;
}


}
