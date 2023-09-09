package com.male.models.ds.array;


import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * <p>
 * 详细描述: 数组抽象类
 * </p>
 *
 * @author MingFangXu
 */
public abstract class AbstractArray<E> implements Array<E> {
	/**
	 * 获取数组长度
	 *
	 * @return 数组长度
	 */
	@Override
	public abstract int size();

	/**
	 * 是否为空
	 *
	 * @return 空返回 true，否则返回 false
	 */
	@Override
	public abstract boolean isEmpty();

	/**
	 * 是否存在此元素
	 *
	 * @param element 待添加元素
	 * @return 是返回 true，否则返回 false
	 */
	@Override
	public abstract boolean contains(E element);

	/**
	 * 指定索引添加元素
	 *
	 * @param index   索引
	 * @param element 待添加元素
	 */
	@Override
	public abstract void add(int index, E element);

	@Override
	public void addFirst(E element) {
		add(0, element);
	}

	@Override
	public void addLast(E element) {
		add(size(), element);
	}

	/**
	 * 获取元素
	 *
	 * @param index 待获取元素索引
	 * @return 元素
	 */
	@Override
	public abstract E get(int index);

	/**
	 * 通过索引删除元素
	 *
	 * @param index 待删除索引
	 * @return 被删除的元素
	 */
	@Override
	public abstract E remove(int index);

	@Override
	public E removeFirst() {
		return remove(0);
	}

	@Override
	public E removeLast() {
		return remove(size() - 1);
	}

	/**
	 * 如果存在删除第一个
	 *
	 * @param element 待删除元素
	 * @return 被删除的元素
	 */
	@Override
	public abstract E removeFirst(E element);

	/**
	 * 如果存在删除所有
	 *
	 * @param element 待删除元素
	 * @return 被删除的元素
	 */
	@Override
	public abstract void removeAll(E element);

	/**
	 * 遍历方法1 stream 遍历
	 *
	 * @return 流 流式遍历
	 */
	@Override
	public Stream<E> stream() {
		return StreamSupport.stream(spliterator(), false);
	}

	/**
	 * 遍历方法2 - 迭代器遍历
	 *
	 * @return 迭代器
	 */
	@Override
	public Iterator<E> iterator() {
		return new Iterator<>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index < size();
			}

			@Override
			public E next() {
				return get(index++);
			}
		};
	}

	/**
	 * 遍历方法3 - forEach 函数5式遍历
	 */
	@Override
	public void forEach(Consumer<? super E> action) {
		for (int i = 0; i < size(); i++) {
			action.accept(get(i));
		}
	}

	@Override
	public Spliterator<E> spliterator() {
		return Spliterators.spliteratorUnknownSize(iterator(), 0);
	}


}
