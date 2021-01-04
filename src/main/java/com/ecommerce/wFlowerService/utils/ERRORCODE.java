package com.ecommerce.wFlowerService.utils;

import java.util.HashMap;
import java.util.Map;

public enum ERRORCODE {

    SUCCESS("F000", "Success"),
    FAIL("F001", "Fail"),
    NORECORD("F002", "No record"),
    USERNOTFOUND("F003","User not found"),
    PASSWORDNOTMATHCED("F004","Password not matched"),
    USERNAMEORPASSWORDNOTCORRECT("F005", "UserName or Password not correct");

    static Map<String, String> mapCodeMsg;

    static {
        mapCodeMsg = new HashMap<>();
        for(ERRORCODE err : values()) {
            mapCodeMsg.put(err.getErrorCode(),err.getMessage());
        }
    }

    public static String getMsgByCode(String code) {
        return mapCodeMsg.get(code);
    }

    private String errorCode;
    private String message;

    ERRORCODE(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
