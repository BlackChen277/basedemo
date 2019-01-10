package com.black.demo.enums;

import com.black.demo.constants.CommonConstants;
import java.util.HashSet;

public enum ReturnCodeEnum {


    RESTFUL_SUCCESS(CommonConstants.RESPONSE_SUCCESS_CODE, "成功"),

    RESTFUL_REQUEST_OBJECT_INVALID(CommonConstants.RESPONSE_CLIENT_ERROR_CODE, "参数验证失败"),

    RESTFU_FAIL(CommonConstants.RESPONSE_SERVER_ERROR_CODE, "处理失败，未知异常"),
	
    PARAM_VALIDATION_SUCCESS(600, "参数校验成功"),

    ;

	private int value;

	private String desc;

	private ReturnCodeEnum(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int value() {
		return value;
	}

	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc){
		this.desc = desc;
	}

	private static HashSet<Integer> hashSet;

	static {
		hashSet = new HashSet<Integer>();
		hashSet.clear();
		for (ReturnCodeEnum returnStatus : ReturnCodeEnum.values()) {
			hashSet.add(returnStatus.value());
		}
	}

	public static boolean isDefined(int value) {
		if (hashSet.contains(value)) {
			return true;
		}
		return false;
	}

}
