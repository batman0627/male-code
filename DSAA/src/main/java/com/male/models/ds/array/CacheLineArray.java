package com.male.models.ds.array;


/**
 * <p>
 * 详细描述: 缓存行和局部性原理
 * cpu 读取内存（速度慢）数据后，会将其放入高速缓存（速度快）当中，
 * 如果后来的计算再用到此数据，在缓存中能读到的话，就不必读内存了缓
 * 存的最小存储单位是缓存行（cache line），一般是 64 bytes，一
 * 次读的数据少了不划算啊，因此最少读 64 bytes 填满一个缓存行，因
 * 此读入某个数据时也会读取其临近的数据，这就是所谓空间局部性
 * </p>
 *
 * @author MingFangXu
 */
public class CacheLineArray {

	private static void ij(int[][] array, int rows, int cols) {
		long sum = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				sum += array[i][j];
			}
		}
	}

	private static void ji(int[][] array, int rows, int cols) {
		long start = System.currentTimeMillis();
		long sum = 0;
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				sum += array[j][i];
			}
		}
	}

	private static void takeTimePrint(int[][] array, int rows, int cols, boolean flag) {
		long start = System.currentTimeMillis();
		String desc;
		if (flag) {
			desc = "先行后列：";
			ij(array, rows, cols);
		} else {
			desc = "先列后行：";
			ji(array, rows, cols);
		}

		long end = System.currentTimeMillis();
		System.out.println(String.format("%s %d ms", desc, end - start));
	}

	public static void main(String[] args) {
		int rows = 1_000_000;
		int cols = 14;
		int[][] array = new int[rows][cols];
		takeTimePrint(array, rows, cols, true);
		takeTimePrint(array, rows, cols, false);
	}


}