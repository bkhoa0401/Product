package com.ecommerce.wProductService.entity.response;

import java.util.List;

import com.ecommerce.wProductService.utils.ERRORCODE;

public class BaseResponse <T> {

    private String errorCode = ERRORCODE.SUCCESS.getErrorCode();
    private String errorMessage = ERRORCODE.SUCCESS.getMessage();
    private int totalCount = 0;
    private T mainResult;

    public BaseResponse() {
    }

    public BaseResponse(T mainResult) {
        if (mainResult instanceof List) {
            setTotalCount(((List<?>) mainResult).size());
        }
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
        if (mainResult instanceof List) {
            setTotalCount(((List<?>) mainResult).size());
        }
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

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
