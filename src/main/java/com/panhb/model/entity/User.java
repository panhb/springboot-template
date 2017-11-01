package com.panhb.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.panhb.model.base.BaseModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author panhb
 */
@Entity
@Table(name="user")
public class User extends BaseModel {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String username;
	
	@JSONField(serialize=false)
	@NotNull
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
