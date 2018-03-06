package com.tingyu.listenler;

import com.tingyu.common.ICodeConstants;
import com.tingyu.utils.UUIDUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by tingyu on 2017/4/8.
 * 在修改实体类时(inset*，update*),自动补全ID、最后修改时间、是否有效等字段
 */
@Service
public class EntityModifyBefore {
    private Log log = LogFactory.getLog(EntityModifyBefore.class);

    public void completeEntity(Object record){
        Class classType = record.getClass();
        Field[] fields = classType.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                switch (field.getName()){
                    case "cId":{
                        // ID 为空时表示为新增，因此自动生成一个有序UUID
                        if(null == field.get(record) || StringUtils.isBlank(field.get(record).toString())){
                            field.set(record, UUIDUtil.generateUUIDString());
                        }
                        break;
                    }
                    case "dtLastModifyTime":{
                            // 只要更新数据库时，都需要修改最后修改时间
                            field.set(record,new Date());
                        break;
                    }
                    case "nValid":{
                        if (null == field.get(record)){
                            field.set(record, ICodeConstants.CODE_VALUE_YES);
                        }
                        break;
                    }
                    default:break;
                }
            }
        } catch (IllegalAccessException e) {
            log.error("自动补全ID、最后修改时间、是否有效等字段失败!",e);
        }
    }
}
