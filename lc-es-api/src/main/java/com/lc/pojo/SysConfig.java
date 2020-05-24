package com.lc.pojo;

import com.baomidou.mybatisplus.annotation.TableName;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * SysConfig
 * </p>
 *
 * @author LC
 * @since 2020-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("SYS_CONFIG")
public class SysConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("SC_ORG_ID")
    private String scOrgId;

    @TableField("KEY_NAME")
    private String keyName;

    @TableField("KEY_VALUE")
    private String keyValue;

}
