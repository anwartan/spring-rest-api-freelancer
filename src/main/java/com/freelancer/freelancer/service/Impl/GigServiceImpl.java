package com.freelancer.freelancer.service.Impl;

import com.freelancer.freelancer.Exception.NotFoundException;
import com.freelancer.freelancer.entity.Category;
import com.freelancer.freelancer.entity.Gig;
import com.freelancer.freelancer.model.request.gig.GigRequest;
import com.freelancer.freelancer.model.response.gig.GigResponse;
import com.freelancer.freelancer.repository.CategoryRepository;
import com.freelancer.freelancer.repository.GigRepository;
import com.freelancer.freelancer.service.GigService;
import com.freelancer.freelancer.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GigServiceImpl implements GigService {
    private GigRepository gigRepository;
    private ValidationUtil validationUtil;
    @Autowired
    private CategoryRepository categoryRepository;
    public GigServiceImpl(GigRepository gigRepository, ValidationUtil validationUtil) {
        this.gigRepository = gigRepository;
        this.validationUtil = validationUtil;
    }


    @Override
    public GigResponse create(GigRequest gigRequest)throws  NotFoundException {
        validationUtil.validate(gigRequest);
        Category category = categoryRepository.findById(gigRequest.getCategory_id()).orElseThrow(NotFoundException::new);
        Gig gig = new Gig();
        gig.setCategory(category);
        gig.setName(gigRequest.getName());
        gig.setCreated_at(new Date());
        gig.setUpdated_at(gig.getCreated_at());
        gigRepository.save(gig);
        return gig.toResponseWithCategory();

    }

    @Override
    public GigResponse update(GigRequest gigRequest, Integer id) throws NotFoundException {
        Gig gig = findGigByIdOrElseThrow(id);

        validationUtil.validate(gigRequest);

        gig.setName(gigRequest.getName());
        gig.setUpdated_at(new Date());
        gigRepository.save(gig);
        return gig.toResponseWithCategory();
    }

    @Override
    public GigResponse delete(Integer id) throws NotFoundException {
        Gig gig = findGigByIdOrElseThrow(id);
        gigRepository.delete(gig);
        return gig.toResponseWithCategory();
    }

    @Override
    public List<GigResponse> getAll() {
        List<Gig> gigs = gigRepository.findAll();
        List<GigResponse> responses = new ArrayList<>();
        for (Gig item : gigs) {
            responses.add(item.toResponseWithCategory());
        }

        return responses;
    }

    @Override
    public GigResponse getById(Integer id) throws NotFoundException {
        Gig gig = findGigByIdOrElseThrow(id);
        return gig.toResponseWithCategory();
    }

    private Gig findGigByIdOrElseThrow(Integer id) throws NotFoundException {
        return gigRepository.findById(id).orElseThrow(NotFoundException::new);

    }



}
