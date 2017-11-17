/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prograavanzada.proyecto.maven;

/**
 *
 * @author diego
 */
public class DynamicStack<E> implements Stack<E>{

	/**
	 * Inner class
	 * @author tuxtor
	 *
	 * @param <E>
	 */
	private static class Node<E>{
		private E element; //Valor
		private Node<E> next; //Puntero en la lista
		public Node(E element, Node<E> next) {
			super();
			this.element = element;
			this.next = next;
		}
		public E getElement() {
			return element;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	private Node<E> head = null;
	private Node<E> tail = null;
	
	private int size = 0;
	
	public int size() {return size;}
	
	public boolean isEmpty() { return size == 0;}
	
	private E first() {
		if (isEmpty()) return null;
		return head.getElement();
	}
	
	private E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	private void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0) tail = head;
		size++;
	}
	
	private void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if(isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}
	
	private E removeFirst() {
		if (isEmpty()) return null;
		E response = head.getElement();
		head = head.getNext( );
		size--;
		if(size == 0) tail = null;
		return response;
	}

	@Override
	public void push(E e) {
		this.addFirst(e);
		
	}

	@Override
	public E top() {
		
		return this.first();
	}

	@Override
	public E pop() {
		
		return this.removeFirst();
	}


	
}

