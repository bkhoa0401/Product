package com.ecommerce.wProductService.entity.request;

public class ResetPasswordRequest {
    private String username;

    @Override
    public String toString() {
        return "ResetPasswordRequest{" +
                "username='" + username + '\'' +
                '}';
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
}
