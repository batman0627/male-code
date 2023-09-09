package com.male.models.ds.array;

import java.util.stream.Stream;

/**
 * <p>
 * 详细描述: 数组接口
 * </p>
 *
 * @author MingFangXu
 */
public interface Array<E> extends Iterable<E> {

	/**
	 * 获取数组长度
	 *
	 * @return 数组长度
	 */
	int size();

	/**
	 * 是否为空
	 *
	 * @return 空返回 true，否则返回 false
	 */
	boolean isEmpty();

	/**
	 * 是否存在此元素
	 *
	 * @param element 待添加元素
	 * @return 是返回 true，否则返回 false
	 */
	boolean contains(E element);

	/**
	 * 指定索引添加元素
	 *
	 * @param index   索引
	 * @param element 待添加元素
	 */
	void add(int index, E element);

	/**
	 * 从头添加元素
	 *
	 * @param element 待添加元素
	 */
	void addFirst(E element);

	/**
	 * 从尾添加元素
	 *
	 * @param element 待添加元素
	 */
	void addLast(E element);

	/**
	 * 获取元素
	 *
	 * @param index 待获取元素索引
	 * @return 元素
	 */
	E get(int index);

	/**
	 * 通过索引删除元素
	 *
	 * @param index 待删除索引
	 * @return 被删除的元素
	 */
	E remove(int index);

	/**
	 * 从头删除元素
	 *
	 * @return 被删除的元素
	 */
	E removeFirst();

	/**
	 * 从尾删除元素
	 *
	 * @return 被删除的元素
	 */
	E removeLast();

	/**
	 * 如果存在删除第一个
	 *
	 * @param element 待删除元素
	 * @return 被删除的元素
	 */
	E removeFirst(E element);

	/**
	 * 如果存在删除所有
	 *
	 * @param element 待删除元素
	 */
	void removeAll(E element);

	/**
	 * 返回一个连续的 流 以这个集合作为它的来源
	 *
	 * @return 流
	 */
	Stream<E> stream();


}
