package com.male.basic.log;

import com.male.basic.log.support.Color;
import com.male.basic.log.support.Style;
import org.slf4j.LoggerFactory;

import static com.male.basic.log.support.Formats.format;


/**
 * <p>
 * 详细描述: 日志包装
 * </p>
 *
 * @author MingFangXu
 */
public final class Logger {

	/**
	 * 当前日志类名
	 */
	private final static String LOG_CLASS_NAME = Logger.class.getName();

	private Logger() {
	}

	/**
	 * 获取最原始被调用的堆栈信息
	 */
	private static StackTraceElement getCaller() {

		// 获取堆栈信息
		StackTraceElement[] traceElements = Thread.currentThread()
				.getStackTrace();
		if (null == traceElements) {
			return null;
		}

		// 最原始被调用的堆栈信息
		StackTraceElement caller = null;

		// 循环遍历到日志类标识
		boolean isEachLogFlag = false;

		// 遍历堆栈信息，获取出最原始被调用的方法信息
		// 当前日志类的堆栈信息完了就是调用该日志类对象信息
		for (StackTraceElement element : traceElements) {
			// 遍历到日志类
			if (element.getClassName().equals(LOG_CLASS_NAME)) {
				isEachLogFlag = true;
			}

			// 下一个非日志类的堆栈，就是最原始被调用的方法
			if (isEachLogFlag) {
				//关键: 实际场景需要通过断点来判断是否是自己想要打印的路径
				if (!element.getClassName().equals(LOG_CLASS_NAME)) {
					caller = element;
					break;
				}
			}
		}

		return caller;
	}

	/**
	 * 自动匹配请求类名，生成logger对象
	 */
	private static org.slf4j.Logger log() {
		// 最原始被调用的堆栈对象
		StackTraceElement caller = getCaller();
		// 空堆栈处理
		if (caller == null) {
			return LoggerFactory.getLogger(Logger.class);
		}

		// 取出被调用对象的类名，并构造一个Logger对象返回
		return LoggerFactory.getLogger(caller.getClassName());
	}

	/**
	 * info 封装 原样输出
	 *
	 * @param message 日志输出字符串
	 */
	public static void info(String message) {
		log().info(message);
	}

	/**
	 * info 封装
	 *
	 * @param message 日志输出字符串
	 * @param color   字体或者背景颜色
	 */
	public static void info(String message, Color color) {
		log().info(format(message, Color.FR_RED, Style.NORMAL));
	}

	/**
	 * info 封装
	 *
	 * @param message 日志输出字符串
	 * @param color   字体或者背景颜色
	 * @param style   字体样式
	 */
	public static void info(String message, Color color, Style style) {
		log().info(format(message, color, style));
	}

	/**
	 * debug 封装 原样输出
	 *
	 * @param message 日志输出字符串
	 */
	public static void debug(String message) {
		log().debug(message);
	}

	/**
	 * debug 封装
	 *
	 * @param message 日志输出字符串
	 * @param color   字体或者背景颜色
	 */
	public static void debug(String message, Color color) {
		log().debug(format(message, color, Style.NORMAL));
	}

	/**
	 * debug 封装
	 *
	 * @param message 日志输出字符串
	 * @param color   字体或者背景颜色
	 * @param style   字体样式
	 */
	public static void debug(String message, Color color, Style style) {
		log().debug(format(message, color, style));
	}

}

