package com.optimum.daoImpl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.optimum.dao.GridServiceDao;
import com.optimum.domain.Pagination;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashishyog on 14-06-2019.
 */
@Component
public class GridServiceDaoImpl implements GridServiceDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Document> getTransactions(Pagination pagination) {
        List<Document> list = new ArrayList<Document>();
        final MongoCollection transactions = mongoTemplate.getCollection("transactions");
        int pageNumber = pagination.getPageNumber();
        int pageSize = pagination.getPageSize();
        MongoCursor cursor = transactions.find().skip(pageSize * (pageNumber - 1)).limit(pageSize).iterator();
        try {
            while (cursor.hasNext()) {
                Document document = (Document) cursor.next();
                list.add(document);
                System.out.println(document.toJson());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            cursor.close();
            return list;
        }
    }

    @Override
    public List<Document> getAllTransactions() {
        List<Document> list = new ArrayList<Document>();
        final MongoCollection transactions = mongoTemplate.getCollection("transactions");
        MongoCursor cursor = transactions.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document document = (Document) cursor.next();
                list.add(document);
                System.out.println(document.toJson());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            cursor.close();
            return list;
        }
    }
}
