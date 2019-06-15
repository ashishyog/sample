package com.optimum.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by ashishyog on 14-06-2019.
 */
@AllArgsConstructor
@Getter
@Setter
public class Pagination {
    int pageNumber;
    int pageSize;
}
