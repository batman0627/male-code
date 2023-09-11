package com.male.basic.log.support;

/**
 * <p>
 * 详细描述: 控制台打印颜色枚举
 * </p>
 *
 * @author MingFangXu
 */
public enum Color {
	FR_BLACK(30, "字体-黑色"),
	FR_RED(31, "字体-红色"),
	FR_GREEN(32, "字体-绿色"),
	FR_YELLOW(33, "字体-黄色"),
	FR_BLUE(34, "字体-蓝色"),
	FR_PURPLE(35, "字体-紫色"),
	FR_TIFFANY_BLUE(36, "字体-青蓝"),
	FR_DARK_GREY(37, "字体-浅色"),
	FR_LIGHT_GREY(38, "字体-白色"),
	BG_BLACK(40, "背景-黑色"),
	BG_RED(41, "背景-红色"),
	BG_GREEN(42, "背景-绿色"),
	BG_YELLOW(43, "背景-黄色"),
	BG_BLUE(44, "背景-蓝色"),
	BG_PURPLE(45, "背景-紫色"),
	BG_TIFFANY_BLUE(46, "背景-青蓝"),
	BG_DARK_GREY(47, "背景-浅白"),
	BG_LIGHT_GREY(48, "背景-白色");
	public int k;
	public String v;

	Color(int k, String v) {
		this.k = k;
		this.v = v;
	}
}