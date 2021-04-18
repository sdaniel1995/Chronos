package com.github.sdaniel;

import java.util.List;

public interface Dao<E> {
    List<E> getAll();
    void insert(E e);
}
