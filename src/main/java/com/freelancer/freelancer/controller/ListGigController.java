package com.freelancer.freelancer.controller;

import com.freelancer.freelancer.Exception.NotFoundException;
import com.freelancer.freelancer.model.request.listgig.ListGigRequest;
import com.freelancer.freelancer.model.response.base.WebResponse;
import com.freelancer.freelancer.model.response.list.ListResponse;
import com.freelancer.freelancer.model.response.listgig.ListGigResponse;
import com.freelancer.freelancer.service.ListGigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListGigController extends BaseController {
    private ListGigService listGigService;

    public ListGigController(ListGigService listGigService) {
        this.listGigService = listGigService;
    }

    @PostMapping(
            value = "/api/listgig",
            produces = "application/json",
            consumes = "application/json"
    )
    public WebResponse<ListGigResponse> createListGig(@RequestBody ListGigRequest body)throws NotFoundException {
        ListGigResponse listGigResponse = listGigService.create(body);
        return sendResponse(listGigResponse);

    }

    @GetMapping(
            value = "/api/listgig/all",
            produces = "application/json"
    )
    public WebResponse<List<ListGigResponse>> getAllList() {
        List<ListGigResponse> listGigResponses = listGigService.getAll();
        return sendResponse(listGigResponses);

    }


}
