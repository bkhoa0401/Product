package com.ecommerce.wFlowerService.service;

import com.ecommerce.wFlowerService.entity.Branch;

import java.util.List;

public interface IBranchService {

    List<Branch> getBranches();
    void addNewBranch(Branch branch);
    void updateBranch(Branch branch);
}
