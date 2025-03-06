package com.techtest.testfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.techtest.testfe.models.NegaraView;
import com.techtest.testfe.models.PelajaranView;

@Controller
public class Question3Controller {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${application.api.url}")
    private String apiUrl;

    @GetMapping("/question3")
    public ModelAndView question3() {
        ModelAndView view = new ModelAndView("/question3");

        try {
            ResponseEntity<PelajaranView[]> response = restTemplate.getForEntity(apiUrl + "/pelajaran", PelajaranView[].class);

            if (response.getStatusCode() == HttpStatus.OK) {
                view.addObject("pelajaran", response.getBody());
            } else {
                throw new Exception(response.getStatusCode() + ": " + response.getBody());
            }
        } catch (Exception e) {
            view.addObject("errorMsg", e.getMessage());
        }

        return view;
    }
}
