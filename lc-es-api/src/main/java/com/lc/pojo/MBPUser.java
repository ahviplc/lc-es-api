package com.lc.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.util.Date;

@Data // 该注解使用在类上，该注解会提供getter、setter、equals、canEqual、hashCode、toString方法。
@AllArgsConstructor // 该注解使用在类上，该注解提供一个全参数的构造方法，默认不提供无参构造。
@NoArgsConstructor // 该注解使用在类上，该注解提供一个无参构造
//@Getter // 在使用该注解时，会默认生成一个无参构造。和对应的getter方法 该注解使用在类或者属性上，该注解可以使用在类上也可以使用在属性上。生成的getter遵循布尔属性的约定。例如：boolean类型的sex,getter方法为isSex而不是getSex
//@Setter // 在使用该注解时，会默认生成一个无参构造。和对应的setter方法 该注解使用在类或者属性上，该注解可以使用在类上也可以使用在属性上。生成的getter遵循布尔属性的约定。例如：boolean类型的sex,getter方法为isSex而不是getSex
public class MBPUser {
    // 对应数据库中的主键 (uuid、自增id、雪花算法、redis、zookeeper！)  @TableId(type = IdType.AUTO)
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Version //乐观锁Version注解
    private Integer version;

    @TableLogic //逻辑删除
    private Integer deleted;

    // 字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
