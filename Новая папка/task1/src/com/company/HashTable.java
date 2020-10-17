package com.company;


public class HashTable<E> implements Collection<E>{
        private int n;
        private int maxIndex;
        public Array<List<E>> values;

        public HashTable(int capacity, int n) {
            this.n = n;
            values = new Array<>(capacity);
            maxIndex = 0;
        }

        @Override
        public void insert(E newValue) {
            // Hash function
            int index = (Integer) newValue % n;

            if (maxIndex < index) {
                maxIndex = index;
            }

            if (values.get(index) == null) {
                values.set(new List<E>(), index);
            }

            List l = (List) values.get(index);
            l.insert(newValue);
            values.set(l, index);
        }

        public Object get(int index) {
            return values.get(index);
        }

        public int getMaxIndex() {
            return maxIndex;
        }
}
