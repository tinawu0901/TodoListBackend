package com.tinawu.todolist.Enumeration;

public enum MessageErrorCode {
    TODO0("TODO0","恭喜成功"),
    TODO1("TODO1","該代辦事項不存在，請確認"),
    TOD99("TDO99","系統發生錯誤");

    private String errorCode;
    private String erroMessage;
    MessageErrorCode(final String errorCode, final  String erroMessage){
        this.errorCode = errorCode;
        this.erroMessage=erroMessage;
    }

    public String getErrorCode(){
        return errorCode;
    }
    public String getErroMessage(){
        return erroMessage;
    }
}
