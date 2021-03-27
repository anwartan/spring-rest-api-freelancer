package com.freelancer.freelancer.controller;

import com.freelancer.freelancer.Exception.NotFoundException;
import com.freelancer.freelancer.model.request.skill.SkillRequest;
import com.freelancer.freelancer.model.response.base.WebResponse;
import com.freelancer.freelancer.model.response.skill.SkillResponse;
import com.freelancer.freelancer.service.SkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SkillController extends BaseController {

    private SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping(
            value = "/api/skill",
            produces = "application/json",
            consumes = "application/json"
    )
    public WebResponse<SkillResponse> createSkill(@RequestBody SkillRequest body)throws NotFoundException  {
        SkillResponse skillResponse = skillService.create(body);
        return sendResponse(skillResponse);

    }

    @GetMapping(
            value = "/api/skill/all",
            produces = "application/json"
    )
    public WebResponse<List<SkillResponse>> getAllSkill() {
        List<SkillResponse> skillResponses = skillService.getAll();
        return sendResponse(skillResponses);

    }
    @GetMapping(
            value = "/api/skill/{idSkill}",
            produces = "application/json"
    )
    public WebResponse<SkillResponse> getSkill(@PathVariable("idSkill") Integer id) throws NotFoundException {
        SkillResponse skillResponse = skillService.getById(id);
        return sendResponse(skillResponse);

    }

    @PutMapping(
            value = "/api/skill/{idSkill}",
            produces = "application/json",
            consumes = "application/json"
    )
    public WebResponse<SkillResponse> updateSkill(@PathVariable("idSkill") Integer id, @RequestBody SkillRequest body) throws NotFoundException {
        SkillResponse skillResponse = skillService.update(body,id);
        return sendResponse(skillResponse);

    }

    @DeleteMapping(
            value = "/api/skill/{idSkill}",
            produces = "application/json"
    )
    public WebResponse<SkillResponse> deleteSkill(@PathVariable("idSkill") Integer id) throws NotFoundException {
        SkillResponse skillResponse = skillService.delete(id);
        return sendResponse(skillResponse);

    }
}
