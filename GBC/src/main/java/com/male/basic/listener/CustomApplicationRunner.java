package com.male.basic.listener;

import com.male.basic.log.Logger;
import com.male.basic.annotation.TakeTime;
import com.male.basic.config.AppProperties;
import com.male.basic.log.support.Color;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;



/**
 * <p>
 * 详细描述: 自定义监听器打印项目信息
 * </p>
 *
 * @author MingFangXu
 */
@Slf4j
@Component
public class CustomApplicationRunner implements ApplicationRunner {
	private final AppProperties appProperties;

	public CustomApplicationRunner(AppProperties appProperties) {
		this.appProperties = appProperties;
	}


	@TakeTime(caption = "项目信息打印耗时")
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("\r\n\r\n==========================================\n"
						+ "项目名称：{}\n"
						+ "项目描述：{}\n"
						+ "------------------------------------------\n"
						+ "编译版本：{}\n"
						+ "编译时间：{}\n"
						+ "------------------------------------------\n"
						+ "项目作者：{}\n"
						+ "联系电话：{}\n"
						+ "联系邮箱：{}\n"
						+ "==========================================\r\n",
				appProperties.getAppName(),
				appProperties.getDescription(),
				appProperties.getVersion(),
				appProperties.getBuildTime(),
				appProperties.getAuthor(),
				appProperties.getPhone(),
				appProperties.getEmail()
		);
		Logger.info("测试", Color.FR_RED);
	}
}
