package com.freelancer.freelancer.controller;

import com.freelancer.freelancer.Exception.NotFoundException;
import com.freelancer.freelancer.model.request.gig.GigRequest;
import com.freelancer.freelancer.model.response.base.WebResponse;
import com.freelancer.freelancer.model.response.gig.GigResponse;
import com.freelancer.freelancer.service.GigService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GigController extends BaseController {

    private GigService gigService;

    public GigController(GigService gigService) {
        this.gigService = gigService;
    }

    @PostMapping(
            value = "/api/gig",
            produces = "application/json",
            consumes = "application/json"
    )
    public WebResponse<GigResponse> createGig(@RequestBody GigRequest body)throws NotFoundException  {
        GigResponse gigResponse = gigService.create(body);
        return sendResponse(gigResponse);

    }

    @GetMapping(
            value = "/api/gig/all",
            produces = "application/json"
    )
    public WebResponse<List<GigResponse>> getAllList() {
        List<GigResponse> gigResponses = gigService.getAll();
        return sendResponse(gigResponses);

    }
    @GetMapping(
            value = "/api/gig/{idGig}",
            produces = "application/json"
    )
    public WebResponse<GigResponse> getList(@PathVariable("idGig") Integer id) throws NotFoundException {
        GigResponse gigResponse = gigService.getById(id);
        return sendResponse(gigResponse);

    }

    @PutMapping(
            value = "/api/gig/{idGig}",
            produces = "application/json",
            consumes = "application/json"
    )
    public WebResponse<GigResponse> updateList(@PathVariable("idGig") Integer id, @RequestBody GigRequest body) throws NotFoundException {
        GigResponse gigResponse = gigService.update(body,id);
        return sendResponse(gigResponse);

    }

    @DeleteMapping(
            value = "/api/gig/{idGig}",
            produces = "application/json"
    )
    public WebResponse<GigResponse> deleteList(@PathVariable("idGig") Integer id) throws NotFoundException {
        GigResponse gigResponse = gigService.delete(id);
        return sendResponse(gigResponse);

    }

}
