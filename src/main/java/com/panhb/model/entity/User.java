package com.panhb.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.panhb.model.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author panhb
 */
@Entity
@Table(name="user")
@Data
public class User extends BaseEntity {

	@NotNull
	private String username;
	
	@JSONField(serialize=false)
	@NotNull
	private String password;

}
