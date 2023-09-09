package com.male.models.ds.array;


/**
 * <p>
 * 详细描述: 静态数组
 * </p>
 *
 * @author MingFangXu
 */
public class StaticArray<E> extends AbstractArray<E> {
	/**
	 * 元素个数
	 */
	private int size;
	/**
	 * 容量
	 */
	private int capacity;
	/**
	 * 存储元素的数组缓冲区
	 */
	private E[] elemData;

	public StaticArray(int capacity) {
		this.capacity = capacity;
		this.elemData = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E element) {
		return findElemIndex(element) > -1;
	}

	@Override
	public void add(int index, E element) {
		// 容量检查
		checkCapacity(index);
		// 从头开始添加时需要往后移动
		if (index == 0 || index == size) {
			// 1. 源数组
			// 2. 源索引
			// 3. 目标数组
			// 4. 目标索引
			// 5. 拷贝长度
			System.arraycopy(elemData,
					index,
					elemData,
					index + 1,
					size - index);
			size++;
		} else {
			checkIndex(index - 1);
		}
		//if (index > size) {
		//	size++;
		//}
		elemData[index] = element;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return elemData[index];
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		// 0 1 2 3 4 5  3
		// 0 1 2 4 5
		E removed = elemData[index];
		System.arraycopy(elemData,
				index + 1,
				elemData,
				index,
				size - index - 1);
		size--;
		return removed;
	}

	@Override
	public E removeFirst(E element) {
		int elemIndex = findElemIndex(element);
		return remove(elemIndex);
	}

	@Override
	public void removeAll(E element) {
		do {
			removeFirst(element);
		}while (contains(element));
	}

	/**
	 * 通过值查询索引
	 *
	 * @param element
	 * @return
	 */
	public int findElemIndex(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (null == elemData[i]) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elemData[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * 检查索引
	 *
	 * @param index
	 */
	private void checkIndex(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(String.format("index %d out of bounds", index));
		}
	}

	private void checkCapacity(int index) {
		if (index < 0 || index > capacity) {
			throw new IndexOutOfBoundsException(String.format("index %d insufficient capacity", index));
		}
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public E[] getElemData() {
		return elemData;
	}

	public void setElemData(E[] elemData) {
		this.elemData = elemData;
	}

	//@Override
	//public int hashCode() {
	//	final Object[] es = elemData;
	//	if (size() > es.length) {
	//		throw new ConcurrentModificationException();
	//	}
	//	int hashCode = 1;
	//	for (int i = 0; i < size(); i++) {
	//		Object e = es[i];
	//		hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
	//	}
	//	return hashCode;
	//}
	//
	//@Override
	//public boolean equals(Object obj) {
	//	if (obj == this) {
	//		return true;
	//	}
	//	if (!(obj instanceof Array<?>)) {
	//		return false;
	//	}
	//	boolean equal = (obj.getClass() == StaticArray.class)
	//			? equalsArrayList((StaticArray<?>) obj)
	//			: equalsRange((Array<?>) obj, 0, size);
	//
	//	return equal;
	//}
	//
	//private boolean equalsArrayList(StaticArray<?> other) {
	//	final int s = size;
	//	boolean equal;
	//	if (equal = (s == other.size)) {
	//		final Object[] otherEs = other.elemData;
	//		final Object[] es = elemData;
	//		if (s > es.length || s > otherEs.length) {
	//			throw new ConcurrentModificationException();
	//		}
	//		for (int i = 0; i < s; i++) {
	//			if (!Objects.equals(es[i], otherEs[i])) {
	//				equal = false;
	//				break;
	//			}
	//		}
	//	}
	//	return equal;
	//}
	//
	//private boolean equalsRange(Array<?> other, int from, int to) {
	//	final Object[] es = elemData;
	//	if (to > es.length) {
	//		throw new ConcurrentModificationException();
	//	}
	//	var oit = other.iterator();
	//	for (; from < to; from++) {
	//		if (!oit.hasNext() || !Objects.equals(es[from], oit.next())) {
	//			return false;
	//		}
	//	}
	//	return !oit.hasNext();
	//}
}
