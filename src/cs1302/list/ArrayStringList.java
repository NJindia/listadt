package cs1302.list;
import cs1302.listadt.StringList;
import java.lang.*;

/** Represents an {@code ArrayStringList} object that uses an array to store strings. */
public class ArrayStringList implements StringList {
    private String[] list; //list stored as an array

    /** Creates an {@code ArrayStringList} object and initializes list to be an array of size 0 */
    public ArrayStringList() {
        list = new String[0];
    } //ArrayStringList

    /**
     * Creates an {@code ArrayStringList} object and copies all strings from a specified list.
     * @param other the list whose strings are to be copied
     */
    public ArrayStringList(StringList other) {
        list = new String[other.size()];
        for(int i = 0; i < other.size(); i++) {
            list[i] = other.get(i);
        }
    } //ArrayStringList

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
            throw new IndexOutOfBoundsException("Index is out of range");
        } else {
            String[] list1 = new String[size() + 1];
            int i = 0;
            for(int n = 0; n < index; n++) {
                list1[n] = list[n];
                i++;
            }
            list1[i] = s;
            for(int n = index + 1; n < list1.length; n++) {
                list1[n] = list[n - 1];
            }
            list = list1;
            add = true;
        }
        return add;
    } //add
    
    /**
     * Inserts the strings contained in the specified list at the specified position in this list, 
     * in the order in which they appear in the specified list.
     * @param index index at which the specified string is to be inserted
     * @param sl string to be inserted
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
            throw new IndexOutOfBoundsException("Index is out of range");
        } else {
            String[] list1 = new String[size() + sl.size()];
            int i = 0;
            for(int n = 0; n < index; n++) {
                list1[n] = list[n];
                i++;
            }
            for(int n = 0; n < sl.size(); n++) {
                list1[i] = sl.get(n);
                i++;
            }
            for(int n = index; n < size(); n++) {
                list1[i] = list[n];
                i++;
            }
            list = list1;
            add = true;
        }
        return add;
    } //add
    
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
            String[] list1 = new String[size() + 1];
            for(int i = 0; i < size(); i++) {
                list1[i] = list[i];
            }
            list1[list1.length - 1] = s;
            list = list1;
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
            String[] list1 = new String[this.size() + sl.size()];
            int i = 0;
            for(int n = 0; n < size(); n++) {
                list1[n] = list[n];
                i++;
            }
            for (int n = 0; n < sl.size(); n++) {
                list1[i] = sl.get(n);
                i++;
            }
            list = list1;
            add = true;
        }
        return add;
    } //add
    
    /** 
     * Removes all of the stringns from this list. 
     * The list will be empty after this call returns. 
     */
    public void clear() {
        String[] newList = new String[0];
        list = newList;
    } //clear

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
            for(String s : list) {
                if (o.equals(s)) {
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
            for(String s : list) {
                if (o.equalsIgnoreCase(s)) {
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
            for(String s : list) {
                if (s.contains(o)) {
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
        for(int i  = 0; i < size(); i++) {
            array[i] = list[i];
        }
        return array;
    } //toArray

    /**
     * Returns the number of elements in this list. If this list contains more than 
     * Integer.MAX_VALUE elements, then this method returns Integer.MAX_VALUE.
     * @return the number of elements in this list
     */
    public int size() {
        if(list.length > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return list.length;
    } //size

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        if(size() == 0) {
            return true;
        } else {
            return false;
        }
    } //isEmpty

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
            string = list[index];
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
    public String set(int index, String s) {
        String string = "";
        if (s == null) {
            throw new NullPointerException("String is null");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            string = list[index];
            list[index] = s;
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
             string = list[index];
             String[] list1 = new String[size() - 1];
             for(int i = 0; i < index; i++) {
                 list1[i] = list[i];
             }
             for (int i = index + 1; i < list.length; i++) {
                 list1[i-1] = list[i];
             }
             list = list1;
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
        if (s == null) {
            throw new NullPointerException("String is null");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else {
            int index = 0;
            for (String string : list) {
                if(s.equals(string)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
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
        if (s == null) {
            throw new NullPointerException("String is null");
        } else if (s.equals("")) {
            throw new IllegalArgumentException("String is empty");
        } else {
            int index = 0;
            for (String string : list) {
                if(s.equalsIgnoreCase(string)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    } //indexOfIgnoreCase

    /**
     * Builds and returns a new {@code StringList} from this list without any duplicate strings.
     * @return a new {@code StringList} which contains the first occurance of every string in this 
     * list
     */
    public StringList distinct() {
        StringList list1 = new ArrayStringList();
        for(String string : list) {
            if(list1.indexOf(string) == -1) {
                list1.add(string);
            }
        }
        return list1;
    } //distinct

    /**
     * Builds and returns a new {@code StringList} that contains the strings from this list in 
     * reverse order.
     * @return a new {@code StringList} with the strings from this list in reverse order
     */
    public StringList reverse() {
        StringList list1 = new ArrayStringList();
        for(int i = size() - 1; i >= 0; i--) {
            list1.add(list[i]);
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
                string = string + list[i] + sep;
            }
            string += list[list.length - 1];
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
     * (fromIndex {@literal <} 0 || toIndex {@literal >} size || fromIndex {@literal >} toIndex)
     */
    public StringList splice(int fromIndex, int toIndex) {
        StringList list1 = new ArrayStringList();
        if(fromIndex < 0 || toIndex > size() || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("Illegal endpoint index value");
        } else {
            for(int i = fromIndex; i < toIndex; i++) {
                list1.add(list[i]);
            }
        }
        return list1;
    } //splice
}
