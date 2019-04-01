package cs1302.list;
import cs1302.listadt.StringList;
import cs1302.listadt.StringList.Node;

/** Represents a {@code LinkedStringList} object that uses nodes to store strings. */
public class LinkedStringList implements StringList {
    StringList.Node list; //list stored as a linked list
    
    /** Creates a LinkedStringList object with an empty node as its first and only node. */
    public LinkedStringList() {
        list = new StringList.Node();
    } //LinkedStringList

    /**
     * Creates a {@code LinkedStringList} object with an empty node as its first node and then
     * appends a copy of the specified list to the end.
     * @param other the list whose strings are to be copied
     */
    public LinkedStringList(StringList other) {
        list = new StringList.Node();
        StringList.Node current = list;
        for(int i = 0; i < other.size(); i++) {
            String s = other.get(i);
            current.setNext(new StringList.Node(s, null));
            current = current.getNext();
        }
    } //LinkedStringList

    /**
     * Returns the number of elements in this list. If this list contains more than 
     * Integer.MAX_VALUE elements, then this method returns Integer.MAX_VALUE.
     * @return the number of elements in this list
     */
    public int size() {
        int size = 0;
        StringList.Node current = list.getNext();
        while (current != null) {
            size++;
            if(size > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            current = current.getNext();
        }
        return size;
    } //size

    /**
     * {@inheritdoc}
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    } //isEmpty

    /**
     * Returns true if this list contains the specified string.
     * More formally, returns true if, and only if, this list contains at least 
     * one element s such that o.equals(s).
     * @param o string whose presence in this list is to be tested
     * @return true if this list contains the specified string
     * @throws NullPointerException if the specified string is null
     * @throws IllegalArgumentException if the specified string is empty
     */
    public boolean contains(String o) {
        boolean contains = false;
        if (o == null) {
            throw new NullPointerException("String is null");
        } else if (o.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else {
            for (int i = 0; i < size(); i++) {
                if(o.equals(get(i))) {
                    contains = true;
                }
            }
        }
        return contains;
    } //contains

    /**
     * Returns true if this list contains the specified string, ignoring case. 
     * More formally, returns true if, and only if, this list contains at least 
     * one element s such that o.equalsIgnoreCase(s).
     * @param o string whose presence in this list is to be tested
     * @return true if this list contains the specified string
     * @throws NullPointerException if the specified string is null
     * @throws IllegalArgumentException if the specified string is empty
     */
    public boolean containsIgnoreCase(String o) {
        boolean contains = false;
        if (o == null) {
            throw new NullPointerException("String is null");
        } else if (o.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else {
            for (int i = 0; i < size(); i++) {
                if(o.equalsIgnoreCase(get(i))) {
                    contains = true;
                }
            }
        }
        return contains;
    } //containsIgnoreCase

    /**
     * Returns true if any string in this list contains the specified substring. 
     * More formally, returns true if, and only if, this list contains at least 
     * one element s such that s.contains(o).
     * @param o substring whose presence in this list is to be tested
     * @return true if this list contains the specified string
     * @throws NullPointerException if the specified substring is null
     * @throws IllegalArgumentException if the specified substring is empty
     */
    public boolean containsSubstring(String o) {
        boolean contains = false;
        if (o == null) {
            throw new NullPointerException("String is null");
        } else if (o.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else {
            for (int i = 0; i < size(); i++) {
                if(o.contains(get(i))) {
                    contains = true;
                }
            }
        }
        return contains;
    } //containsSubstring

    /**
     * Returns an array containing all of the strings in this list in proper 
     * sequence (from first to last element). The returned array will be "safe" 
     * in that no references to it are maintained by this list.
     * In other words, this method must allocate a new array even if this list
     * is backed by an array. The caller is thus free to modify the returned array.
     * @return an array containing all of the strings in this list in proper sequence
     */
    public String[] toArray() {
        String[] array = new String[size()];
        for(int i = 0; i < size(); i++) {
            array[i] = get(i);
        }
        return array;
    } //toArray

    /**
     * Appends the specified string to the end of this list.
     * @param s string to be appended
     * @return true if this list changed as a result of the call; false otherwise
     * @throws NullPointerException if the specified string is null
     * @throws IllegalArgumentException if the specified string is empty
     */
    public boolean add(String s) {
        boolean add = false;
        if (s == null) {
            throw new NullPointerException("String is null");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else {
            StringList.Node current = list;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new StringList.Node(s, null));
            add = true;
        }
        return add;
        } //add
    
    
    /**
     * Appends the strings contained in the specified list to the end of this list, in the order 
     * in which they appear in the specified list.
     * @param sl list whose strings are to be appended
     * @return true if this list changed as a result of the call; false otherwise
     * @throws NullPointerException if the specified list is null
     */
    public boolean add(StringList sl) {
        boolean add = false;
        if (sl == null) {
            throw new NullPointerException("StringList is null");
        } else {
            StringList.Node current = getNode(size());
            for(int i = 0; i < sl.size(); i++) {
                current.setNext(new StringList.Node(sl.get(i), null));
                current = current.getNext();
            }
            add = true;
        }
        return add;
    } //add

    /**
     * Inserts the specified string at the specified position in this list.
     * @param index index at which the specified string is to be inserted
     * @param s string to be inserted
     * @return true if this list changed as a result of the call; false otherwise
     * @throws NullPointerException if the specified string is null
     * @throws IllegalArgumentException if the specified string is empty
     * @throws IndexOutOfBoundsException if the index is out of range 
     * (index {@literal <} 0 || index {@literal >} size())
     */
    public boolean add(int index, String s) {
        boolean add = false;
        if (s == null) {
            throw new NullPointerException("String is null");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            if (index == 0) {
                StringList.Node front = new StringList.Node();
                StringList.Node temp = new StringList.Node(s, list.getNext());
                front.setNext(temp);
                list = front;
            } else if (index == size()) {
                add(s);
            } else {
                StringList.Node front = list.getNext();
                for (int i = 0; i < index - 1; i++) { //sets front to the node before the index node
                    front = front.getNext();
                }
                StringList.Node back = new StringList.Node(s, front.getNext());
                front.setNext(back); //merges the 2 nodes with the added string in between
            }
            add = true;
        }
        return add;
        
    } //add

    /**
     * Inserts the strings contained in the specified list at the specified position in this list, 
     * in the order in which they appear in the specified list.
     * @param index index at which the specified string is to be inserted
     * @param sl list to be inserted
     * @return true if this list changed as a result of the call; false otherwise
     * @throws NullPointerException if the specified list is null
     * @throws IndexOutOfBoundsException if the index is out of range 
     * (index {@literal <} 0 || index {@literal >} size())
     */
    public boolean add(int index, StringList sl) {
        boolean add = false;
        if (sl == null) {
            throw new NullPointerException("StringList is null");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            if (index == size()) {
                add(sl);
            } else {
                StringList.Node front = list.getNext();
                for (int i = 0; i < index - 1; i++) { //sets front to the node before the index node
                    front = front.getNext();
                }
                StringList.Node back = front.getNext(); //sets back to the node currently at index
                for (int i = 0; i < sl.size(); i++) { //adds sl to front
                    front.setNext(new StringList.Node(sl.get(i)));
                    front = front.getNext();
                }
                front.setNext(back); //merges the 2 lists together
                add = true;
            }
        }
        return add;
    } //add

    /**
     * Returns a reference to the index-th node in a linked list
     * @param index the index of the node
     * @return a reference to the index-th node
     */
    private StringList.Node getNode(int index) {
        StringList.Node current;
        if (size() == 0) {
            current = list;
        } else {
            current = list.getNext();
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
        }
        return current;
    } //getNode

    /**
     * Returns the string at the specified position in this list.
     * @param index index of the string to return
     * @return the string at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range 
     * (index {@literal <} 0 || index {@literal >}= size())
     */
    public String get(int index) {
        String string = "";
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            StringList.Node current = list.getNext(); //Skips the first node that is always empty
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            string = current.getStr();
        }
        return string;
    } //get

    /**
     * Replaces the string at the specified position in this list with the specified element.
     * @param index index at which the specified string is to be inserted
     * @param s string to be inserted
     * @return the string previously at the specified position
     * @throws NullPointerException if the specified string is null
     * @throws IllegalArgumentException if the specified string is empty
     * @throws IndexOutOfBoundsException if the index is out of range
     * (index {@literal <} 0 || index {@literal >}= size())
     */
    public String set(int  index, String s) {
        String string = "";
        if (s == null) {
            throw new NullPointerException("String is null");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            StringList.Node current = getNode(index + 1);
            string = current.getStr();
            current.setStr(s);
        }
        return string;
    } //set

     /**
     * Removes the string at the specified position in this list. 
     * Shifts any subsequent elements to the left (subtracts one from their indices). 
     * Returns the string that was removed from the list.
     * @param index index of the string to remove
     * @return the string previously at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     * (index {@literal <} 0 || index {@literal >}= size())
     */
    public String remove(int index) {
        String string = "";
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            StringList.Node front = list.getNext();
            if(index == 0) { //if you want to remove the first element in the list
                string = front.getStr();
                list = front;
            } else {
                for (int i = 0; i < index - 1; i++) { //sets front to the node before the index node
                    front = front.getNext();
                }
                string = front.getNext().getStr();
                //back equals the node after the index node
                StringList.Node back = front.getNext().getNext();
                front.setNext(back); //merges front and back, omitting the index node
            }
        }
        return string;
    } //remove

    /**
     * Returns the index of the first occurrence of the specified string in this list, or -1 if 
     * this list does not contain the string. More formally, returns the lowest index i such that 
     * s.equals(get(i))), or -1 if there is no such index.
     * @param s string to search for
     * @return the index of the first occurrence of the specified string in this list, or -1 if
     * this list does not contain the string
     * @throws NullPointerException if the specified string is null
     * @throws IllegalArgumentException if the specified string is empty
     */
    public int indexOf(String s) {
        int index = -1;
        if (s == null) {
            throw new NullPointerException("String is null");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else {
            for(int i = 0; i < size(); i++) {
                if(s.equals(get(i))) {
                    index = i;
                }
            }
        }
        return index;
    } //indexOf

    /**
     * Returns the index of the first occurrence of the specified string, ignoring case, in this 
     * list, or -1 if this list does not contain the string. More formally, returns the lowest 
     * index i such that s.equalsIgnoreCase(get(i))), or -1 if there is no such index.
     * @param s string to search for
     * @return the index of the first occurrence of the specified string, ignoring case, in this 
     * list, or -1 if this list does not contain the string
     * @throws NullPointerException if the specified string is null
     * @throws IllegalArgumentException if the specified string is empty
     */
    public int indexOfIgnoreCase(String s) {
        int index = -1;
        if (s == null) {
            throw new NullPointerException("String is null");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else {
            for(int i = 0; i < size(); i++) {
                if(s.equalsIgnoreCase(get(i))) {
                    index = i;
                }
            }
        }
        return index;
    } //indexOfIgnoreCase

    /** 
     * Removes all of the stringns from this list. 
     * The list will be empty after this call returns. 
     */
    public void clear() {
        StringList.Node list1 = new StringList.Node();
        list = list1;
    } //clear

    /**
     * Builds and returns a new {@code StringList} from this list without any duplicate strings.
     * @return a new {@code StringList} which contains the first occurance of every string in this 
     * list
     */
    public StringList distinct() {
        StringList list1 = new LinkedStringList();
        StringList.Node current = list.getNext();
        for(int i = 0; i < size(); i++) {
            if(list1.indexOf(current.getStr()) == -1) {
                list1.add(current.getStr());
            }
            current = current.getNext();
        }
        return list1;
    } //distinct

    /**
     * Builds and returns a new {@code StringList} that contains the strings from this list in 
     * reverse order.
     * @return a new {@code StringList} with the strings from this list in reverse order
     */
    public StringList reverse() {
        StringList list1 = new LinkedStringList();
        for(int i = size() - 1; i >= 0; i--) {
            list1.add(get(i));
        }
        return list1;
    } //reverse

    /**
     * Returns a string representation of this list with every string in the sequence separated by 
     * the specified seprator string.
     * @param sep the specified separator string
     * @return string representation of this list with every string in the sequence separated by sep
     */
    public String makeString(String sep) {
        String string = "";
        if(size() != 0) {
            for(int i = 0; i < size() - 1; i++) {
                string = string + get(i) + sep;
            }
            string = string + get(size() - 1);
        }
        return string;
    } //makeString

    /**
     * Builds and returns a new {@code StringList} that contains the strings from this list between
     * the specified {@code fromIndex}, inclusive, and {@code toIndex}, exclusive. If 
     * {@code fromIndex} and {@code toIndex} are in bounds and equal, then the returned list is 
     * empty.
     * @param fromIndex low endpoint (inclusive) of the splice
     * @param toIndex high endpoint (exclusive) of the splice
     * @return a new {@code StringList} with the strings from this list from the specified range
     * @throws IndexOutOfBoundsException for an illegal endpoint index value 
     * (fromIndex {@literal <} 0 || toIndex {@literal >} size() || fromIndex {@literal >} toIndex)
     */
    public StringList splice(int fromIndex, int toIndex) {
        StringList list1 = new LinkedStringList();
        if (fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            for(int i = fromIndex; i < toIndex; i++) {
                list1.add(get(i));
            }
        }
        return list1;       
    } //splice
}
