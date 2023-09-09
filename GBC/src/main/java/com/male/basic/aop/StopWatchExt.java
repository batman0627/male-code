package com.male.basic.aop;

import org.slf4j.Logger;
import org.springframework.util.StopWatch;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 详细描述: StopWatch 扩展
 * </p>
 *
 * @author MingFangXu
 */
public class StopWatchExt extends StopWatch {

	public StopWatchExt() {

	}

	public StopWatchExt(String id) {
		super(id);
	}

	public void print(Logger log, TimeUnit timeUnit, boolean enabled) {
		if (log.isDebugEnabled()) {
			log.debug(print(timeUnit));
		} else {
			if (enabled) {
				log.info(print(timeUnit));
			}
		}
	}

	private String print(TimeUnit timeUnit) {
		String total;
		String task;
		switch (timeUnit) {
			case NANOSECONDS:
				total = getTotalTimeNanos() + " ns";
				task = getTaskInfo()[0].getTimeNanos() + " ns";
				break;
			case MICROSECONDS:
				total = TimeUnit.NANOSECONDS.toMicros(getTotalTimeNanos()) + " us";
				task = TimeUnit.NANOSECONDS.toMicros(getTaskInfo()[0].getTimeNanos()) + " us";
				break;
			case SECONDS:
				total = getTotalTimeSeconds() + " s";
				task = getTaskInfo()[0].getTimeSeconds() + " s";
				break;
			case MILLISECONDS:
			default:
				total = getTotalTimeMillis() + " ms";
				task = getTaskInfo()[0].getTimeMillis() + " ms";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("StopWatch '")
				.append(getId())
				.append("': running time = ")
				.append(total)
				.append("; [")
				.append(getTaskInfo()[0].getTaskName())
				.append("] took ")
				.append(task);
		return sb.toString();
	}

}
