package com.spring.productservice.service.impl;

import com.spring.productservice.service.CustomService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
public class CustomServiceImpl <T,ID>implements CustomService<T, ID> {
private final JpaRepository<T, ID> jpaRepository;
    @Override
    public List<T> getAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Page<T> getPageableList(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }

    @Override
    public T getById(ID id) {
        return jpaRepository.getById(id);
    }

    @Override
    public T save(T t) {
        return jpaRepository.save(t);
    }

    @Override
    public List<T> saveAll(List<T> ts) {
        return jpaRepository.saveAll(ts);
    }

    @Override
    public void delete(T t) {
        jpaRepository.delete(t);
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public List<T> getAllByIds(List<ID> ids) {
        return jpaRepository.findAllById(ids);
    }

    @Override
    public void batchDelete(List<T> ts) {
        jpaRepository.deleteInBatch(ts);
    }

    @Override
    public void deleteAll(List<T> ts) {
        jpaRepository.deleteAll(ts);
    }
}
