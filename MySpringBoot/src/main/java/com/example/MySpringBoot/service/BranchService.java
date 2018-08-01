package com.example.MySpringBoot.service;

import java.util.List;

import com.example.MySpringBoot.model.Branch;

/**
 * 城市业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface BranchService {

    List<Branch> list(List<Integer> branchNums);

}
