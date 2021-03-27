package com.freelancer.freelancer.service.Impl;

import com.freelancer.freelancer.Exception.NotFoundException;
import com.freelancer.freelancer.entity.Gig;
import com.freelancer.freelancer.entity.ListGig;
import com.freelancer.freelancer.model.request.listgig.ListGigRequest;
import com.freelancer.freelancer.model.response.listgig.ListGigResponse;
import com.freelancer.freelancer.repository.GigRepository;
import com.freelancer.freelancer.repository.ListGigRepository;
import com.freelancer.freelancer.repository.ListRepository;
import com.freelancer.freelancer.service.ListGigService;
import com.freelancer.freelancer.validation.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ListGigServiceImpl implements ListGigService {

    private ListGigRepository listGigRepository;
    private ValidationUtil validationUtil;
    private ListRepository listRepository;
    private GigRepository gigRepository;

    public ListGigServiceImpl(ListGigRepository listGigRepository, ValidationUtil validationUtil, ListRepository listRepository, GigRepository gigRepository) {
        this.listGigRepository = listGigRepository;
        this.validationUtil = validationUtil;
        this.listRepository = listRepository;
        this.gigRepository = gigRepository;
    }

    @Override
    public ListGigResponse create(ListGigRequest listGigRequest) throws NotFoundException {
        validationUtil.validate(listGigRequest);
        com.freelancer.freelancer.entity.List list = listRepository.findById(listGigRequest.getListId()).orElseThrow(NotFoundException::new);
        Gig gig = gigRepository.findById(listGigRequest.getGigId()).orElseThrow(NotFoundException::new);
        ListGig listGig = new ListGig();
        listGig.setGig(gig);
        listGig.setList(list);
        listGig.setCreated_at(new Date());
        listGig.setUpdated_at(listGig.getCreated_at());
        listGigRepository.save(listGig);
        return listGig.toResponse();
    }

    @Override
    public ListGigResponse update(ListGigRequest listGigRequest, Integer id) {
        validationUtil.validate(listGigRequest);
        ListGig listGig = listGigRepository.getOne(id);
        com.freelancer.freelancer.entity.List list = listRepository.getOne(listGig.getList().getId());
        Gig gig = gigRepository.getOne(listGig.getList().getId());
        listGig.setList(list);
        listGig.setGig(gig);
        listGigRepository.save(listGig);
        return listGig.toResponse();
    }

    @Override
    public ListGigResponse delete(Integer id)  {
        return null;
    }

    @Override
    public List<ListGigResponse> getAll() {

        List<ListGig> listGigs = listGigRepository.findAll();
        List<ListGigResponse> listGigResponses = new ArrayList<>();

        for (ListGig listgig: listGigs) {
            listGigResponses.add(listgig.toResponse());
        }
        return listGigResponses;
    }

    @Override
    public ListGigResponse getById(Integer id) {
         return  listGigRepository.getOne(id).toResponse();
    }


}
