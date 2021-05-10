package com.ecommerce.wProductService.service;

import java.util.List;

import com.ecommerce.wProductService.entity.Branch;

public interface IBranchService {

    List<Branch> getBranches();
    void addNewBranch(Branch branch);
    void updateBranch(Branch branch);
}
