package com.freelancer.freelancer.service.Impl;

import com.freelancer.freelancer.Exception.NotFoundException;
import com.freelancer.freelancer.entity.Category;
import com.freelancer.freelancer.entity.Skill;
import com.freelancer.freelancer.model.request.skill.SkillRequest;
import com.freelancer.freelancer.model.response.skill.SkillResponse;
import com.freelancer.freelancer.repository.CategoryRepository;
import com.freelancer.freelancer.repository.SkillRepository;
import com.freelancer.freelancer.service.SkillService;
import com.freelancer.freelancer.validation.ValidationUtil;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private SkillRepository skillRepository;
    private ValidationUtil validationUtil;
    private CategoryRepository categoryRepository;

    public SkillServiceImpl(SkillRepository skillRepository,CategoryRepository categoryRepository ,ValidationUtil validationUtil) {
        this.skillRepository = skillRepository;
        this.validationUtil = validationUtil;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public SkillResponse create(SkillRequest skillRequest) throws NotFoundException {
        validationUtil.validate(skillRequest);
        Category category = categoryRepository.findById(skillRequest.getCategory_id()).orElseThrow(NotFoundException::new);
        Skill skill = new Skill();
        skill.setName(skillRequest.getName());
        skill.setCategory(category);
        skill.setCreated_at(new Date());
        skill.setUpdated_at(skill.getCreated_at());
        skillRepository.save(skill);
        return skill.toResponse();

    }

    @Override
    public SkillResponse update(SkillRequest skillRequest, Integer id) throws NotFoundException {
        Skill skill = findSkillByIdOrElseThrow(id);

        validationUtil.validate(skillRequest);

        skill.setName(skillRequest.getName());
        skill.setUpdated_at(new Date());
        skillRepository.save(skill);
        return skill.toResponse();
    }

    @Override
    public SkillResponse delete(Integer id) throws NotFoundException {
        Skill skill = findSkillByIdOrElseThrow(id);
        skillRepository.delete(skill);
        return skill.toResponse();
    }

    @Override
    public List<SkillResponse> getAll() {
        List<Skill> skills = skillRepository.findAll();
        List<SkillResponse> responses = new ArrayList<>();
        for (Skill item : skills) {
            responses.add(item.toResponse());
        }

        return responses;
    }

    @Override
    public SkillResponse getById(Integer id) throws NotFoundException {
        Skill skill = findSkillByIdOrElseThrow(id);
        return skill.toResponse();
    }

    private Skill findSkillByIdOrElseThrow(Integer id) throws NotFoundException {
        return skillRepository.findById(id).orElseThrow(NotFoundException::new);

    }



}
