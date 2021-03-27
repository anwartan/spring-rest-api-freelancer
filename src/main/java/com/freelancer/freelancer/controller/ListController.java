package com.freelancer.freelancer.controller;


import com.freelancer.freelancer.Exception.NotFoundException;
import com.freelancer.freelancer.model.request.list.ListRequest;
import com.freelancer.freelancer.model.response.base.WebResponse;
import com.freelancer.freelancer.model.response.list.ListResponse;
import com.freelancer.freelancer.service.ListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListController extends BaseController {

    private ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping(
            value = "/api/list",
            produces = "application/json",
            consumes = "application/json"
    )
    public WebResponse<ListResponse> createList(@RequestBody ListRequest body) throws NotFoundException  {
        ListResponse listResponse = listService.create(body);
        return sendResponse(listResponse);

    }

    @GetMapping(
            value = "/api/list/all",
            produces = "application/json"
    )
    public WebResponse<List<ListResponse>> getAllList() {
        List<ListResponse> listResponses = listService.getAll();
        return sendResponse(listResponses);

    }
    @GetMapping(
            value = "/api/list/{idList}",
            produces = "application/json"
    )
    public WebResponse<ListResponse> getList(@PathVariable("idList") Integer id) throws NotFoundException {
        ListResponse listResponse = listService.getById(id);
        return sendResponse(listResponse);

    }

    @PutMapping(
            value = "/api/list/{idList}",
            produces = "application/json",
            consumes = "application/json"
    )
    public WebResponse<ListResponse> updateList(@PathVariable("idList") Integer id, @RequestBody ListRequest body) throws NotFoundException {
        ListResponse listResponse = listService.update(body,id);
        return sendResponse(listResponse);

    }

    @DeleteMapping(
            value = "/api/list/{idList}",
            produces = "application/json"
    )
    public WebResponse<ListResponse> deleteList(@PathVariable("idList") Integer id) throws NotFoundException {
        ListResponse listResponse = listService.delete(id);
        return sendResponse(listResponse);

    }
}
