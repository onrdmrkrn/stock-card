package core;

public class CoreFields {
	
	
	private String userName = "root";
	private String password ="123456789h";
	private String url = "jdbc:mysql://localhost:3306/stock_control?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	

	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}

	public String getUrl() {
		return url;
	}


	
}
