package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{

        private SortedIntLinkedList delegatedList;
        private int totalAdded;
    
        public DelegationSortedIntList() {
            this.delegatedList = new SortedIntLinkedList();  
            this.totalAdded = 0;  
        }
    
        @Override
        public boolean add(int num) {

            if (delegatedList.add(num)) {
                totalAdded++;  
                return true;
            }
            return false;
        }

        @Override
        public boolean addAll(IntegerList list) {

            boolean success = false;

            for (int i = 0; i < list.size(); i++)
            {
                success |= this.add(list.get(i));
            }

            return success;
        }
    
        @Override
        public int get(int index) {
            return delegatedList.get(index); 
        }
    
        @Override
        public boolean remove(int num) {
            return delegatedList.remove(num);  
        }
    
        @Override
        public boolean removeAll(IntegerList list) {
            return delegatedList.removeAll(list);  
        }
    
        @Override
        public int size() {
            return delegatedList.size();  
        }
    
        public int getTotalAdded() {
            return totalAdded;
        }
    }
