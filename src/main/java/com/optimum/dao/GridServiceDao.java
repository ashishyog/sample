package com.optimum.dao;


import com.optimum.domain.Pagination;
import org.bson.Document;

import java.util.List;

public interface GridServiceDao {
    List<Document> getTransactions(Pagination pagination);
    List<Document> getAllTransactions();
}