package impl;

import java.util.ArrayList;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class  IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private final ArrayList<T> arrayList;

    public IterableWithPolicyImpl(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }

}
