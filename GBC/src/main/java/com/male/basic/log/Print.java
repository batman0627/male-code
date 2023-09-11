package com.male.basic.log;


import com.male.basic.log.support.Color;
import com.male.basic.log.support.Style;

import java.util.HashMap;
import java.util.Map;

import static com.male.basic.log.support.Formats.format;

/**
 * <p>
 * 详细描述: 颜色打印工具类
 * </p>
 *
 * @author MingFangXu
 */
public class Print {

	public static void printf(String format, Object... args) {
		printf(format, Color.FR_RED, args);
	}

	public static void printf(String format, Color color, Object... args) {
		printf(format, color, Style.NORMAL, args);
	}

	public static void printf(String format, Color color, Style style, Object... args) {
		String message = String.format(format, args);
		System.out.printf(format(message, color, style));
	}

	public static void print(String message) {
		print(message, Color.FR_RED);
	}

	public static void print(String message, Color color) {
		print(message, color, Style.NORMAL);
	}

	public static void print(String message, Color color, Style style) {
		System.out.print(format(message, color, style));
	}

	public static void println(String message) {
		println(message, Color.FR_RED);
	}

	public static void println(String message, Color color) {
		println(message, color, Style.NORMAL);
	}

	public static void println(String message, Color color, Style style) {
		System.out.println(format(message, color, style));
	}
	public static void main(String[] args) {
		/**
		 * IDEA控制台输出彩色字体和彩色背景
		 * 格式："\33[颜色数字;控制码数字;输出内容\033[0m"
		 * 格式："\033[控制码数字;颜色数字+m;输出内容\033[0m"
		 * 说明：
		 *      %n：换行符
		 * ****************************************
		 * ANSI控制码:
		 *   \033[0m   关闭所有属性
		 *   \033[1m   字体加粗
		 *   \033[2m   字体正常
		 *   \033[3m   字体斜体
		 *   \033[4m   字体下划线
		 *   \033[5m   闪烁
		 *   \033[7m   反显
		 *   \033[8m   消隐
		 *   \033[30m   --   \033[37m   设置前景色（字体颜色）
		 *   \033[40m   --   \033[47m   设置背景色（背景颜色）
		 *   \033[nA   光标上移n行
		 *   \033[nB   光标下移n行
		 *   \033[nC   光标右移n行
		 *   \033[nD   光标左移n行
		 */
		Map<String, String> map = new HashMap<>();
		map.put("黑色", "30");
		map.put("红色", "31");
		map.put("绿色", "32");
		map.put("黄色", "33");
		map.put("蓝色", "34");
		map.put("紫红色", "35");
		map.put("青蓝色", "36");
		map.put("浅色", "37");
		map.put("白色", "38");

		for (String key : map.keySet()) {
			print("\033[1;" + map.get(key) + "m" + map.get(key) + "=" + key + "\033[0m ");
		}
		System.out.println();
		for (String key : map.keySet()) {
			print("\033[2;" + map.get(key) + "m" + map.get(key) + "=" + key + "\033[0m ");
		}
		System.out.println();
		for (String key : map.keySet()) {
			print("\033[3;" + map.get(key) + "m" + map.get(key) + "=" + key + "\033[0m ");
		}
		System.out.println();
		for (String key : map.keySet()) {
			print("\033[4;" + map.get(key) + "m" + map.get(key) + "=" + key + "\033[0m ");
		}
		System.out.println();
		for (String key : map.keySet()) {
			print("\033[5;" + map.get(key) + "m" + map.get(key) + "=" + key + "\033[0m ");
		}

		System.out.println();
		for (String key : map.keySet()) {
			print("\033[7;" + map.get(key) + "m" + map.get(key) + "=" + key + "\033[0m ");
		}

		System.out.println();
		for (String key : map.keySet()) {
			print("\033[8;" + map.get(key) + "m" + map.get(key) + "=" + key + "\033[0m ");
		}

		System.out.println();
		for (String key : map.keySet()) {
			print("\33[" + map.get(key) + ";8m" + map.get(key) + "=" + key + "\33[0m ");
		}

	}
}
