package com.male.web.vo;

/**
 * <p>
 * 详细描述: Tomcat测试VO对象
 * </p>
 *
 * @author MingFangXu
 */
public class TomcatVO {

	private String context;
	private Integer version;

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "TomcatVO{" +
				"context='" + context + '\'' +
				", version=" + version +
				'}';
	}
}
