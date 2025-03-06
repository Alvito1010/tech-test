package com.techtest.testfe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.techtest.testfe.models.NegaraView;
import com.techtest.testfe.models.PelajaranView;

@Controller
@RequestMapping("/question3")
public class Question3Controller {
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${application.api.url}")
    private String apiUrl;

    @GetMapping("")
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

    @PostMapping("/create")
    ResponseEntity<?> create(@ModelAttribute PelajaranView pelajaran) {
        ResponseEntity<PelajaranView> apiResponse = null;

        try {
            apiResponse = restTemplate.postForEntity(apiUrl +"/pelajaran", pelajaran, PelajaranView.class);

            if(apiResponse.getStatusCode() == HttpStatus.CREATED) {
                return new ResponseEntity<PelajaranView>(apiResponse.getBody(), HttpStatus.CREATED);
            }
            else{
                throw new Exception(apiResponse.getStatusCode().toString() + ": " + apiResponse.getBody());
            }
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView view = new ModelAndView("/pelajaranDetail");

        ResponseEntity<PelajaranView> apiResponse = null;

        try {
            apiResponse = restTemplate.getForEntity(apiUrl+"/pelajaran/id/"+id, PelajaranView.class);
            
            if (apiResponse.getStatusCode() == HttpStatus.OK){
                PelajaranView data = apiResponse.getBody();
                view.addObject("pelajaran", data);
            } else {
                throw new Exception(apiResponse.getStatusCode().toString()+": "+apiResponse.getBody());
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            view.addObject("errorMsg", e.getMessage());
        }
        
        view.addObject("Pelajaran Detail");

        return view;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
    ModelAndView view = new ModelAndView("/pelajaranEdit");

    ResponseEntity<PelajaranView> apiResponse = null;

    try {
        apiResponse = restTemplate.getForEntity(apiUrl + "/pelajaran/id/" + id, PelajaranView.class);

        if (apiResponse.getStatusCode() == HttpStatus.OK) {
            PelajaranView pelajaran = apiResponse.getBody();
            view.addObject("title", "Edit Pelajaran");
            view.addObject("pelajaran", pelajaran);
        } else {
            throw new Exception("Error: " + apiResponse.getStatusCode());
        }
    } catch (Exception e) {
        view.addObject("errorMsg", e.getMessage());
    }

    return view;
}

    @PostMapping("/update")
    public ResponseEntity update(@ModelAttribute PelajaranView pelajaran) throws Exception {
        //TODO: process POST request
        ResponseEntity<PelajaranView> apiResponse = null;
        
        try {
            restTemplate.put(apiUrl+"/pelajaran", pelajaran);
            apiResponse = restTemplate.getForEntity(apiUrl+"/pelajaran/id/"+pelajaran.getId(), PelajaranView.class);

            if(apiResponse.getStatusCode()==HttpStatus.OK){
                return new ResponseEntity<PelajaranView>(apiResponse.getBody(), HttpStatus.OK);
            } else {

                throw new Exception(apiResponse.getStatusCode().toString() +": " +apiResponse.getBody());
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

     @PostMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        ResponseEntity<PelajaranView> apiResponse = null;
        PelajaranView pelajaran = new PelajaranView();

        pelajaran.setId(id);

        try {
            // restTemplate.delete(apiUrl + "/delete/" + id + "/" + userId);
            apiResponse = restTemplate.exchange(
                apiUrl + "/pelajaran/delete/" + id,
                HttpMethod.DELETE,
                new HttpEntity<PelajaranView>(pelajaran),
                PelajaranView.class
            );

            if (apiResponse.getStatusCode() == HttpStatus.OK) {
                return new ResponseEntity<PelajaranView>(apiResponse.getBody(), HttpStatus.OK);
            }
            else {
                throw new Exception(apiResponse.getStatusCode().toString() + ": " +  apiResponse.getBody().toString());
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
