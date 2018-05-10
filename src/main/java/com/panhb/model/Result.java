package com.panhb.model;

import com.alibaba.fastjson.JSON;
import com.panhb.Constants;
import com.panhb.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author panhb
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> extends BaseModel {

	private static final String MSG_SUCCESS = "操作成功";
	private static final String MSG_ERROR = "操作失败";

	/**
	 * 返回码
	 */
	private int code;

	/**
	 * 提示信息
	 */
	private String msg;

	/**
	 * 详细信息
	 */
	private T data;

	public static Result succ() {
		return Result.succ(MSG_SUCCESS);
	}

	public static Result succ(String msg) {
		return Result.succ(msg, null);
	}

	public static <T> Result<T> succData(T data) {
		return Result.succ(MSG_SUCCESS, data);
	}

	public static <T> Result<T> succ(String msg, T data){
		return new Result<>(Constants.SUCCESS, msg, data);
	}

	public static Result err() {
		return Result.err(MSG_ERROR);
	}

	public static Result err(String msg) {
		return Result.err(msg, null);
	}

	public static <T> Result<T> errData(T data) {
		return Result.err(MSG_ERROR, data);
	}

	public static <T> Result<T> err(String msg, T data){
		return new Result<>(Constants.ERROR, msg, data);
	}

	public static void main(String[] args) {
		System.out.println(JSON.toJSONString(Result.succ()));
		System.out.println(JSON.toJSONString(Result.succ("123")));
		System.out.println(JSON.toJSONString(Result.succData(123L)));
		System.out.println(JSON.toJSONString(Result.succ("123",123L)));

		System.out.println(JSON.toJSONString(Result.err()));
		System.out.println(JSON.toJSONString(Result.err("123")));
		System.out.println(JSON.toJSONString(Result.errData(123L)));
		System.out.println(JSON.toJSONString(Result.err("123",123L)));
	}

}
