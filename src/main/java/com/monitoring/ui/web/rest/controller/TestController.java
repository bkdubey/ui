package com.monitoring.ui.web.rest.controller;

//import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
//mport com.couchbase.client.deps.com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.couchbase.client.deps.com.fasterxml.jackson.databind.ObjectMapper;
//import com.couchbase.client.deps.com.fasterxml.jackson.databind.SerializationFeature;

import com.monitoring.ui.domain.ListResult;
import com.monitoring.ui.web.rest.service.Command;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/api/v2")

public class TestController {

    public  static ListResult commandResult;
    //@GetMapping( "/getString")

    @CrossOrigin
    @RequestMapping(value = "/getString", method = RequestMethod.GET)
    public ResponseEntity<String> greeting(@RequestParam(value = "command", defaultValue = "World") String name) {
        List ar = new ArrayList<>();
        ar.add("hello");
        ar.add(1);
        //return JSONObject.quote(ar.toString());
        // JSONObject.
        // return Command.execute("ls").toString();
       /* List<JSONObject> entities = new ArrayList<JSONObject>();
        entities.add(Command.execute("ls"));
       JSONObject js= Command.execute("ls");
        //System.out.println("validate value " + entities.toString());
        System.out.println("validate value " + js);
        System.out.println("validate value are" + js.toString());*/
        String result=Command.execute(name).toString();
        System.out.println("result is "+result);
        //ListResult ls = ;
        // return new ResponseEntity<Object>(entities, HttpStatus.OK);
        //return new ResponseEntity(Command.execute("ls"),HttpStatus.OK);
       // return  Command.execute("ls");
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String Tesy(@RequestParam(value = "command", defaultValue = "World") String name) {
        String result=Command.execute(name).toString();
        System.out.println("result is "+result);
        return result;

    }

    @GetMapping(value = "/test2", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> getByAxePro(@PathVariable String codecomp) {
        Map<String, String> map = new HashMap<>();
        map.put("cce0","frityyy");
        return ResponseEntity.status(HttpStatus.OK).body(map);

    }

   /* static{
        commandResult= new ListResult();
    }*/
    /*@Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);}
*/
}


