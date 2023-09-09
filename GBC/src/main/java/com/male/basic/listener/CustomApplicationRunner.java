package com.male.basic.listener;

import com.male.basic.config.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

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


	@Override
	public void run(ApplicationArguments args) throws Exception {
		TimeUnit.SECONDS.sleep(1);
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
	}
}
