package com.example.MySpringBoot.conveter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.example.MySpringBoot.dto.BranchDTO;
import com.example.MySpringBoot.model.Branch;


public class BranchConveter {

    public static BranchDTO createDTO(Branch model) {
        if (model == null) {
            return null;
        }
        BranchDTO dto = new BranchDTO();
        BeanUtils.copyProperties(model, dto);

        return dto;
    }

    public static Branch createModel(BranchDTO dto) {
        if (dto == null) {
            return null;
        }
        Branch model = new Branch();
        BeanUtils.copyProperties(dto, model);

        return model;
    }

    public static Collection<Branch> createModels(Collection<BranchDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        List<Branch> list = new ArrayList<Branch>();
        Iterator<BranchDTO> iterator = dtos.iterator();
        while (iterator.hasNext()) {
            BranchDTO dto = iterator.next();
            Branch model = createModel(dto);
            list.add(model);
        }
        return list;
    }

    public static Collection<BranchDTO> createDTOs(Collection<Branch> models) {
        if (models == null) {
            return null;
        }
        List<BranchDTO> list = new ArrayList<BranchDTO>();
        Iterator<Branch> iterator = models.iterator();
        while (iterator.hasNext()) {
            Branch model = iterator.next();
            BranchDTO dto = createDTO(model);
            list.add(dto);
        }
        return list;
    }
}
