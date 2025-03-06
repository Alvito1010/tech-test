package com.techtest.testfe.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.techtest.testfe.models.KotaView;
import com.techtest.testfe.models.PagingView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/question1")
public class Question1Controller {
    // HTTP Client
    private RestTemplate restTemplate = new RestTemplate();
    
    // API Url
    @Value("${application.api.url}")
    private String apiUrl;

    @Value("${application.page.size}")
    private Integer pageSize;


    @GetMapping("")
    public ModelAndView question1(Integer currPageSize, Integer pageNumber) {
        ModelAndView view = new ModelAndView("/question1");

        ResponseEntity <PagingView> apiResponse = null;

        currPageSize = (currPageSize != null) ? currPageSize : pageSize;
        pageNumber = (pageNumber!= null) ? pageNumber : 0;

        try {
            apiResponse = restTemplate.getForEntity(apiUrl+"/kota/paginated/"+pageNumber+"/"+currPageSize, PagingView.class);

            if (apiResponse.getStatusCode() == HttpStatus.OK){
                PagingView data = apiResponse.getBody();
                view.addObject("kota", data);
            } else {
                throw new Exception(apiResponse.getStatusCode().toString()+": "+apiResponse.getBody());

            }
        } catch (Exception e) {
            // TODO: handle exception
            view.addObject("errorMsg", e.getMessage());
        }

        view.addObject("currPageSize", currPageSize);

        return view;
    }
}
