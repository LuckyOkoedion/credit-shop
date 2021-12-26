package com.example.LuckyOkoedionspringmvccreditshop.services;

import java.util.List;

public interface ICrudService<T> {
     List<T> getAll();

     T create(T theObj);

     T getOneById(Long id);

     T updateStudent(T theObj);

    void destroy(Long id);
}
