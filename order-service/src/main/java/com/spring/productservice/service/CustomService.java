package com.spring.productservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomService<T, ID> {
    List<T> getAll();
    Page<T> getPageableList(Pageable pageable);
    T getById(ID id);
    T save(T t);
    List<T> saveAll(List<T> tList);
    void delete(T t);
    void deleteById(ID id);
    List<T> getAllByIds(List<ID> ids);
    void batchDelete(List<T> tList);
    void deleteAll(List<T> tList);
}
