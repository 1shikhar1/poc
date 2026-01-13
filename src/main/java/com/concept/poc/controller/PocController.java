package com.concept.poc.controller;

import com.concept.poc.model.Request;
import com.concept.poc.model.Response;
import com.concept.poc.model.ResponseData;
import com.concept.poc.model.ResponsePayload;
import com.concept.poc.utils.PocUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poc")
public class PocController {

    private static final Logger log = LoggerFactory.getLogger(PocController.class);

    @GetMapping("/health")
    public String getHealth() {
        log.info("Received health check request");
        return "Service is up and running!";
    }

    @PostMapping("/factorial")
    public Response getFactorial(@RequestBody Request request) {
        log.info("Received factorial request for number: {}", request.getRequestPayload().getRequestData().getNumber());
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