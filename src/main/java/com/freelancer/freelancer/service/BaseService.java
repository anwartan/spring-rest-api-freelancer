package com.freelancer.freelancer.service;

import com.freelancer.freelancer.Exception.NotFoundException;

import java.util.List;

public interface BaseService<T,S> {

    T create(S s) throws NotFoundException;

    T update(S s,Integer id) throws NotFoundException;

    T delete(Integer id) throws NotFoundException;

    List<T> getAll();

    T getById(Integer id) throws NotFoundException;


}
