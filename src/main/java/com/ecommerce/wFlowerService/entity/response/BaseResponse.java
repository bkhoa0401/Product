package com.ecommerce.wFlowerService.entity.response;

import com.ecommerce.wFlowerService.utils.ERRORCODE;

public class BaseResponse <T> {

    private String errorCode = ERRORCODE.SUCCESS.getErrorCode();
    private String errorMessage = ERRORCODE.SUCCESS.getMessage();
    private T mainResult;

    public BaseResponse() {
    }

    public BaseResponse(T mainResult) {
        this.mainResult = mainResult;
    }

    public BaseResponse(ERRORCODE error) {
        setErrorCode(error.getErrorCode());
        setErrorMessage(error.getMessage());
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        if (errorMessage == null) {
            return ERRORCODE.getMsgByCode(getErrorCode());
        }
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getMainResult() {
        return mainResult;
    }

    public void setMainResult(T mainResult) {
        this.mainResult = mainResult;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", mainResult=" + mainResult +
                '}';
    }
}
