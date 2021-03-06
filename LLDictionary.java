package coen352.ch4.dictionary;

/** Dictionary implemented by using linked-based list. */

public class LLDictionary<Key,E>implements ADTDictionary<Key, E> {
	
	
	private LList<KVpair<Key,E>>list; // to store dictionary
	
	//The implementation will be very similar to that of the array-based list dictionary
	
	/**constructors*/
	
	LLDictionary(int size){
		this(); //->ignore the size
	}

	public LLDictionary() {
		list =  new LList<KVpair<Key,E>>() ; 
	}
	
	
	
	/** Reinitialize the dictionary list*/
	public void clear() {
		list.clear();
	}
	
	
	
	/**Insert an element: append to list*/
	public void insert(Key k, E e) {
		KVpair<Key,E> temp = new KVpair<Key,E>(k,e);
		list.append(temp);
	}

	/**Use sequential search to find the element to remove*/
	public E remove(Key k) {
		E temp = find(k);
		if (temp != null) 
			list.remove();
		return temp;
	}
	
	/**remove the last element*/
	public E removeAny() {
		if (size() != 0) {
			  list.moveToEnd();
			  list.prev();
			  KVpair<Key,E> e = list.remove();
			  return e.value();
			}
			else 
				return null;
	}

	
	/** Find k using a sequential search
	 @return Record with key value k*/
	 
	public E find(Key k) {
		for(list.moveToStart(); list.currPos() < list.length(); list.next()) {
			  KVpair<Key,E> temp = list.getValue();
			  if (k == temp.key())
			    return temp.value();
			}
			return null; // "k" does not appear in dictionary
	}

	/**@return List size*/
	public int size() {
		return list.length(); 
	}
	
	// function to search through the list
	public E search(int pos) {
		list.moveToPos(pos);
		if (list !=null)
		return list.getValue().value();
		return list.getValue().value();

	}

}
