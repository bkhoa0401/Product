package com.ecommerce.wProductService.entity.response;

public class LoginResponse<T> extends BaseResponse{
    public LoginResponse(T mainResult){
       super(mainResult);
    }
    
    public LoginResponse() {
		super();
	}
    
	private String token;
    
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
  
}
