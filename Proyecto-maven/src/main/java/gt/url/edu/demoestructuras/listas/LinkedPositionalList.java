/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.url.edu.demoestructuras.listas;

/**
 *
 * @author diego
 * @param <E>
 */
public class LinkedPositionalList<E> implements PositionalList<E>{

    /**
     * 
     * 
     * @param p
     * @param q 
     * recive 2 posiciones y las intercambia 
     */
    public void swap(Position<E> p, Position<E> q) {
       if (isEmpty()){
           System.out.println("esta vacia");
       }
       else{
           Position<E> tmp1= p;
            Position<E> tmp2=q;
            addBefore(tmp1,q.getElement());
            addBefore(tmp2,p.getElement());
            remove(p);
            remove(q);
            
           
           
       }
    }
    /**
     * 
     * nodo el cual recibe un elemento
     * @param <E> 
     */
    
   private static class Node<E> implements Position<E> {
		private E element;
		private Node<E> prev;// Anterior
		private Node<E> next;// Siguiente
                 /**
                  * 
                  * constructor del nodo
                  * @param e
                  * @param p
                  * @param n 
                  */
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
                /**
                 * obtiene el elemento del nodo 
                 * @return
                 * @throws IllegalStateException 
                 */

		public E getElement() throws IllegalStateException {
			if (next == null) // Nodo no valido
				throw new IllegalStateException("Posicion invalida");
			return element;
		}
                /**
                 * 
                 * asigna elemento al nodo
                 * @param e 
                 */
		
		public void setElement(E e) {
			element = e;
		}
                    /**
                     * 
                     * obtiene el nodo anterior 
                     * @return 
                     */
		public Node<E> getPrev() {
			return prev;
		}
                        /**
                         * asigna el nodo anterior
                         * @param prev 
                         */
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}
                /**
                 * 
                 * obtirne el nodo siguiente
                 * @return 
                 */

		public Node<E> getNext() {
			return next;
		}
                 /**
                  * asigna el nodo siguente 
                  * @param next 
                  */
		public void setNext(Node<E> next) {
			this.next = next;
		}

	}

	private Node<E> header = null;// Referencia
	private Node<E> trailer = null;
	private int size = 0;

	public LinkedPositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	// Metodos internos
	/**
	 * Valida si una posicion contiene un nodo y el nodo existe
	 */
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("P invalido");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getNext() == null)
			throw new IllegalArgumentException("p ya no se encuentra en la lista");
		return node;
	}
	
	/**
	 * "Empaca" un nodo como posicion a menos que sea header o trailer
	 */
	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null; // do not expose user to the sentinels
		return node;
	}

	// ---

	public int size() {return size;}

	public boolean isEmpty() {return size == 0;}

	public Position<E> first( ) {
		return position(header.getNext());
	}

	public Position<E> last( ) {
		return position(trailer.getPrev());
	}
	
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
           
		Node<E> newest = new Node<>(e, pred, succ);
		succ.setPrev(newest);
                pred.setNext(newest);
		size++;
		return newest;
	}
	
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}
	
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}
	
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{ 
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}
              
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}
	
   @Override
        /**
         * 
         * elimina el elemento de la lista 
         */
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
		return answer;
	}
}

