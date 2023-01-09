package application;

public class User {
	private String name;
	private String ABPath;
	private String OwnPath;
	private String SolPath;
	
	public User(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getABPath() {
		return this.ABPath;
	}
	
	public void setABPath(String newABPath) {
		this.ABPath = newABPath;
	}
	
	public String getOwnPath() {
		return this.OwnPath;
	}
	
	public void setOwnPath(String newNOwnPath) {
		this.OwnPath = newNOwnPath;
	}
	
	public String getSolPath() {
		return this.SolPath;
	}
	
	public void setSolPath(String newSolPath) {
		this.SolPath = newSolPath;
	}
}
