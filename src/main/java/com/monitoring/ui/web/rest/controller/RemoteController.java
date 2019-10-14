package com.monitoring.ui.web.rest.controller;

//import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
//mport com.couchbase.client.deps.com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
//import com.couchbase.client.deps.com.fasterxml.jackson.databind.SerializationFeature;
import com.monitoring.ui.domain.ListResult;
import com.monitoring.ui.web.rest.service.Command;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1")

public class RemoteController {

    public  static ListResult commandResult;
    //@GetMapping( "/getString")

    @RequestMapping(value = "/getString", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JSONObject>> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        List ar = new ArrayList<>();
        ar.add("hello");
        ar.add(1);
        //return JSONObject.quote(ar.toString());
        // JSONObject.
        // return Command.execute("ls").toString();
        List<JSONObject> entities = new ArrayList<JSONObject>();
        entities.add(Command.execute("ls"));
        //System.out.println("validate value " + entities.toString());
        System.out.println("validate value " + commandResult.getResult());
        System.out.println("validate value are" + commandResult.getResult().toString());

        //ListResult ls = ;
        // return new ResponseEntity<Object>(entities, HttpStatus.OK);
        return new ResponseEntity(commandResult.getResult(),HttpStatus.OK);

    }

   /* static{
        commandResult= new ListResult();
    }*/
    /*@Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);}
*/
}


 class StringResponse {

    public String response;

    public StringResponse(String s) {
        this.response = s;
    }

    // get/set omitted...
}

