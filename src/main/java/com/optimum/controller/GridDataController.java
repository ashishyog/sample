package com.optimum.controller;

import com.optimum.domain.Pagination;
import com.optimum.domain.Transaction;
import com.optimum.service.GridService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/grid")
public class GridDataController {
    @Autowired
    private GridService gridService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/dataByPage", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,List<Document>> getGridDataByPage(@RequestBody Pagination pagination) {
        Map<String,List<Document>> map = new HashMap<String,List<Document>>();
        map.put("data", gridService.getGridDataByPage(pagination));
        return map;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/data/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String,List<Document>> getGridData() {
        Map<String,List<Document>> map = new HashMap<String,List<Document>>();
        map.put("data", gridService.getGridData());
        return map;
    }
}