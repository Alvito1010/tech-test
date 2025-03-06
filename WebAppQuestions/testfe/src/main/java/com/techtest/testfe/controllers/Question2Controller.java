package com.techtest.testfe.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.techtest.testfe.models.NegaraView;
import com.techtest.testfe.models.ProvinsiView;
import com.techtest.testfe.models.KotaView;

import java.util.List;

@Controller
@RequestMapping("/question2")
public class Question2Controller {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${application.api.url}")
    private String apiUrl;

    @GetMapping("")
    public ModelAndView question2() {
        ModelAndView view = new ModelAndView("/question2");

        try {
            ResponseEntity<NegaraView[]> response = restTemplate.getForEntity(apiUrl + "/negara", NegaraView[].class);

            if (response.getStatusCode() == HttpStatus.OK) {
                view.addObject("negaraList", List.of(response.getBody()));
            } else {
                throw new Exception(response.getStatusCode() + ": " + response.getBody());
            }
        } catch (Exception e) {
            view.addObject("errorMsg", e.getMessage());
        }

        return view;
    }

    @GetMapping("/provinsi/{negaraId}")
    @ResponseBody
    public ResponseEntity<List<ProvinsiView>> getProvinsiByNegara(@PathVariable Long negaraId) {
        try {
            ResponseEntity<ProvinsiView[]> response = restTemplate.getForEntity(apiUrl + "/provinsi/negaraid/" + negaraId, ProvinsiView[].class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok(List.of(response.getBody()));
            } else {
                throw new Exception(response.getStatusCode() + ": " + response.getBody());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/kota/{provinsiId}")
    @ResponseBody
    public ResponseEntity<List<KotaView>> getKotaByProvinsi(@PathVariable Long provinsiId) {
        try {
            ResponseEntity<KotaView[]> response = restTemplate.getForEntity(apiUrl + "/kota/provinsiid/" + provinsiId, KotaView[].class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok(List.of(response.getBody()));
            } else {
                throw new Exception(response.getStatusCode() + ": " + response.getBody());
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
