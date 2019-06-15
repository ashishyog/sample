package com.optimum.service;


import com.optimum.domain.Pagination;
import org.bson.Document;

import java.util.List;

public interface GridService {
    List<Document> getGridDataByPage(Pagination pagination);

    List<Document> getGridData();

}