package impl;

import java.util.Iterator;
import java.util.List;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class  IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private final List<T> arrayList;
    private Predicate<T> internalPredicate;

    public IterableWithPolicyImpl(final T[] array) {
        this(array, (i) -> true);
    }

    public IterableWithPolicyImpl(final T[] array, Predicate<T> predicate) {
        this.arrayList = List.of(array);
        this.internalPredicate = predicate;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorWithPolicy();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.internalPredicate = filter;
    }

    class IteratorWithPolicy implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            for (int i = index; i < arrayList.size(); i++) {
                if (internalPredicate.test(arrayList.get(i))) {
                    index = i;
                    return true;
                }
            }
            return false;
        }


        @Override
        public T next() {
            return arrayList.get(index++);
        }
    
        
    }

}
