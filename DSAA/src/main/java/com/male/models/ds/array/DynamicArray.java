package com.male.models.ds.array;


/**
 * <p>
 * 详细描述: 动态数组
 * </p>
 *
 * @author MingFangXu
 */
public class DynamicArray<E> extends StaticArray<E> {

	private int capacity;

	public DynamicArray() {
		super(5);
		this.capacity = 5;
	}

	public DynamicArray(int capacity) {
		super(capacity);
		this.capacity = capacity;
	}

	@Override
	public void add(int index, E element) {
		// 扩容
		checkAndGrow();
		super.add(index, element);
	}

	/**
	 * 扩容
	 */
	private void checkAndGrow() {
		if (size() == capacity) {
			// 进行扩容, 1.5 1.618 2
			capacity += capacity >> 1;
			// 创建新的数组
			E[] newElemData = (E[]) new Object[capacity];
			// 新的容量赋值
			setCapacity(capacity);
			System.arraycopy(getElemData(), 0,
					newElemData, 0, size());
			setElemData(newElemData);
		}

	}
}
