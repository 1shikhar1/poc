package com.concept.poc.controller;

import com.concept.poc.model.Request;
import com.concept.poc.model.Response;
import com.concept.poc.model.ResponseData;
import com.concept.poc.model.ResponsePayload;
import com.concept.poc.utils.PocUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poc")
public class PocController {

    @GetMapping("/health")
    public String getHealth() {
        return "Service is up and running!";
    }

    @PostMapping("/factorial")
    public Response getFactorial(@RequestBody Request request) {
        Response response = new Response();
        ResponsePayload responsePayload = new ResponsePayload();
        ResponseData responseData = new ResponseData();

        long res = PocUtils.factorial(request.getRequestPayload().getRequestData().getNumber());

        responseData.setData(String.valueOf(res));
        responsePayload.setResponseData(responseData);
        response.setResponsePayload(responsePayload);
        return response;
    }
}