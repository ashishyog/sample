package com.optimum.serviceImpl;

import com.optimum.dao.GridServiceDao;
import com.optimum.domain.Pagination;
import com.optimum.service.GridService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashishyog on 14-06-2019.
 */
@Service
public class GridServiceImpl implements GridService {
    @Autowired
    private GridServiceDao gridDao;

    @Override
    public List<Document> getGridDataByPage(Pagination pagination) {
        List<Document> list = new ArrayList<Document>();
        list.addAll(gridDao.getTransactions(pagination));
        return list;
    }

    @Override
    public List<Document> getGridData() {
        List<Document> list = new ArrayList<Document>();
        list.addAll(gridDao.getAllTransactions());
        return list;
    }
}
