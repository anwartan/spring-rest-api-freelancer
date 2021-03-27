package com.freelancer.freelancer.service.Impl;

import com.freelancer.freelancer.Exception.NotFoundException;
import com.freelancer.freelancer.component.AuthenticateFacade;
import com.freelancer.freelancer.model.request.list.ListRequest;
import com.freelancer.freelancer.model.response.list.ListResponse;
import com.freelancer.freelancer.repository.ListRepository;
import com.freelancer.freelancer.service.AuthenticateFacadeService;
import com.freelancer.freelancer.service.ListService;
import com.freelancer.freelancer.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @Autowired
    private AuthenticateFacade authenticateFacadeService;

    @Override
    public ListResponse create(ListRequest listRequest) {
        validationUtil.validate(listRequest);
        com.freelancer.freelancer.entity.List list = new com.freelancer.freelancer.entity.List();
        list.setUser(authenticateFacadeService.getAuthenticationUser());
        list.setName(listRequest.getName());
        list.setDescription(listRequest.getDescription());
        list.setCreated_at(new Date());
        list.setUpdated_at(list.getCreated_at());
        listRepository.save(list);
        return list.toResponse();
    }

    @Override
    public ListResponse update(ListRequest listRequest, Integer id) throws NotFoundException {
        com.freelancer.freelancer.entity.List list = findListByIdOrElseThrow(id);

        validationUtil.validate(listRequest);

        list.setName(listRequest.getName());
        list.setDescription(listRequest.getDescription());
        list.setUpdated_at(new Date());
        listRepository.save(list);
        return list.toResponse();

    }

    @Override
    public ListResponse delete(Integer id) throws NotFoundException {
        com.freelancer.freelancer.entity.List list = findListByIdOrElseThrow(id);

        listRepository.delete(list);
        return list.toResponse();
    }

    @Override
    public List<ListResponse> getAll() {
        List<com.freelancer.freelancer.entity.List> lists = listRepository.findAll();
        List<ListResponse> responses = new ArrayList<>();
        for (com.freelancer.freelancer.entity.List item : lists) {
            responses.add(item.toResponse());
        }

        return responses;
    }

    @Override
    public ListResponse getById(Integer id) throws NotFoundException {
        com.freelancer.freelancer.entity.List list = findListByIdOrElseThrow(id);
        return list.toResponse();

    }

    private com.freelancer.freelancer.entity.List findListByIdOrElseThrow(Integer id) throws NotFoundException {
        return listRepository.findById(id).orElseThrow(()->new NotFoundException("List not found"));

    }



}
