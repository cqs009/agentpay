package com.touchme.agentpay.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * entity
 * @author liyy
 * 2019-12-05
 */
@Data
public class User {
	@TableField("id")
	private Integer id;
		/**
		 * 名称
		 */
	@TableField("name")
	private String name;

}
