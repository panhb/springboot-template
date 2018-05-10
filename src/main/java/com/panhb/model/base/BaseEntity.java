package com.panhb.model.base;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author panhb
 */
@MappedSuperclass
@Data
public class BaseEntity extends BaseModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

}
