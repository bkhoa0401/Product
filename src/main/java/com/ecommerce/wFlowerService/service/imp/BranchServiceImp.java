package com.ecommerce.wFlowerService.service.imp;

import com.ecommerce.wFlowerService.entity.Branch;
import com.ecommerce.wFlowerService.repository.IBranchRepository;
import com.ecommerce.wFlowerService.service.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImp implements IBranchService {

    @Autowired
    IBranchRepository iBranchRepository;

    @Override
    public List<Branch> getBranches() {
        return iBranchRepository.findBranchesByEnable("T");
    }

    @Override
    public void addNewBranch(Branch branch) {
        iBranchRepository.save(branch);
    }

    @Override
    public void updateBranch(Branch branch) {
        Branch findBranchIsExist = iBranchRepository.getOne(branch.getId());

        if (findBranchIsExist != null) {
            findBranchIsExist.setName(branch.getName());
            findBranchIsExist.setEnable(branch.getEnable());

            iBranchRepository.save(findBranchIsExist);
        }
    }
}
