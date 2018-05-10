package com.panhb.model.form;

import com.panhb.model.base.BaseModel;
import lombok.Data;

/**
 * @author panhb
 */
@Data
public class PageForm extends BaseModel {

    private Integer pageSize;
    private Integer pageNum;

    public Integer getPageSize() {
        if(pageSize == null){
            pageSize = 10;
        }
        return pageSize;
    }

    public Integer getPageNum() {
        if(pageNum == null){
            pageNum = 0;
        }
        return pageNum;
    }
}
