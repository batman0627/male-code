package com.male.basic.log.support;

/**
 * <p>
 * 详细描述: 颜色格式化
 * </p>
 *
 * @author MingFangXu
 */
public class Formats {

	public static String format(String message, Color color, Style style) {
		StringBuffer sb = new StringBuffer();
		/**
		 * 格式："\033[控制码数字;颜色数字m输出内容\033[0m"
		 */
		sb.append("\033[")
				.append(style.k)
				.append(";")
				.append(color.k)
				.append("m")
				.append(message)
				.append("\033[0m");
		return sb.toString();
		//StringBuffer sb = new StringBuffer();
		///**
		// * 格式："\33[颜色数字;控制码数字m 输出内容\033[0m"
		// */
		//sb.append("\33[")
		//		.append(color.k)
		//		.append(";")
		//		.append(style.k)
		//		.append("m")
		//		.append(message)
		//		.append("\033[0m");
		//return sb.toString();
	}


}
