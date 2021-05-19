package com.ecommerce.wProductService.entity.request;

public class LoginRequest {
    private String loginID;
    private String password;

    @Override
    public String toString() {
        return "LoginRequest{" +
                "loginID='" + loginID + '\''+
                '}';
    }

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
