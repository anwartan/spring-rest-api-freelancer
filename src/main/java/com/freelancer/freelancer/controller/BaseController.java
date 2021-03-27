package com.freelancer.freelancer.controller;

import com.freelancer.freelancer.model.response.base.WebResponse;

public class BaseController {

    <T> WebResponse<T> sendResponse(T data){
        WebResponse<T> webResponse = new WebResponse<>();
        webResponse.setStatus("success");
        webResponse.setCode(200);
        webResponse.setData(data);
        return webResponse;

    }
}
