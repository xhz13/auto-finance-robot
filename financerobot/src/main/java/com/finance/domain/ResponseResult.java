package com.finance.domain;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import com.finance.enums.AppHttpCodeEnum;
//一个接口需要过滤掉返回值为null的字段，即值为null的字段不返回，可以在实体类中增加如下注解
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T>implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    public ResponseResult() {
        this.code = AppHttpCodeEnum.SUCCESS.getCode();
        this.msg = AppHttpCodeEnum.SUCCESS.getMsg();
    }

    
    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResponseResult(Integer code,  T data){
        this.code = code;
        this.data = data;
    }
    public static ResponseResult errorResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }
    public static ResponseResult errorResult(AppHttpCodeEnum enums) {
        return setAppHttpCodeEnum(enums,enums.getMsg());
    }
    public static ResponseResult errorResult(AppHttpCodeEnum enums,String msg) {
        return setAppHttpCodeEnum(enums,msg);
    }
    public static ResponseResult successResult(int code,String msg) {
        ResponseResult result = new ResponseResult();
        return result.success(code,null,msg);
    }
    public static ResponseResult successResult(Object data) {
        ResponseResult result = setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS,AppHttpCodeEnum.SUCCESS.getMsg());
        if(data != null){
            result.setData(data);
        }
        return result;
    }
    public static ResponseResult successResult() {
        return setAppHttpCodeEnum(AppHttpCodeEnum.SUCCESS);
    }
    public static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums){
        return successResult(enums.getCode(),enums.getMsg());
    }
    private static ResponseResult setAppHttpCodeEnum(AppHttpCodeEnum enums,String msg){
        return successResult(enums.getCode(),msg);
    }
    public  ResponseResult<?> error(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }
    public ResponseResult<?> success(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        return this;
    }
    public ResponseResult<?> success(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }
    public ResponseResult<?> success(T data) {
        this.data = data;
        return this;
    }
    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public T getData() {
        return data;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setData(T data) {
        this.data = data;
    }
}
