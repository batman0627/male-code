package com.male.basic.log.support;

/**
 *
 * <p>
 *  详细描述: 控制台打印颜色枚举
 * </p>
 *
 * @author MingFangXu

 */
public enum Style {

		CLOSE(0, "关闭所有属性"),

		BOLD(1, "字体加粗"),

		NORMAL(2, "字体正常"),

		ITALICS(3, "字体斜体"),

		UNDERLINE(4, "字体下划线"),
		FLICKER(5, "字体闪烁"),
		BACK_DISPLAY(7, "反显"),
		BLANKING(8, "消隐");

		public int k;
		public String v;

		Style(int k, String v) {
			this.k = k;
			this.v = v;
		}
}