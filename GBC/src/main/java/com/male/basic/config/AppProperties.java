package com.male.basic.config;

import com.male.basic.constant.AppConstant;
import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * 详细描述: 应用属性
 * </p>
 *
 * @author MingFangXu
 */
@Data
@SpringBootConfiguration
@ConfigurationProperties(prefix = AppConstant.APP_PREFIX)
public class AppProperties {
	/**
	 * 作者
	 */
	private String author = "MingFangXu";
	/**
	 * 联系邮箱
	 */
	private String email = "mfx18426417887@sina.com";
	/**
	 * 联系电话
	 */
	private String phone = "18426417887";
	/**
	 * 应用名称
	 */
	private String appName = System.getProperty("spring.application.name");
	/**
	 * 应用版本
	 */
	private String version;
	/**
	 * 应用描述
	 */
	private String description;
	/**
	 * 应用构建实践
	 */
	private String buildTime;
	/**
	 * 是否开启 stopWatch log 打印
	 */
	private boolean stopWatchLogEnabled;

}
