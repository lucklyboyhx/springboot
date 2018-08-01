package com.example.MySpringBoot.conveter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.example.MySpringBoot.dto.PosItemLogDTO;
import com.example.MySpringBoot.model.PosItemLog;


public class PosItemLogConveter {

    public static PosItemLogDTO createDTO(PosItemLog model) {
        if (model == null) {
            return null;
        }
        PosItemLogDTO dto = new PosItemLogDTO();
        BeanUtils.copyProperties(model, dto);

        return dto;
    }

    public static PosItemLog createModel(PosItemLogDTO dto) {
        if (dto == null) {
            return null;
        }
        PosItemLog model = new PosItemLog();
        BeanUtils.copyProperties(dto, model);

        return model;
    }

    public static Collection<PosItemLog> createModels(Collection<PosItemLogDTO> dtos) {
        if (dtos == null) {
            return null;
        }
        List<PosItemLog> list = new ArrayList<PosItemLog>();
        Iterator<PosItemLogDTO> iterator = dtos.iterator();
        while (iterator.hasNext()) {
            PosItemLogDTO dto = iterator.next();
            PosItemLog model = createModel(dto);
            list.add(model);
        }
        return list;
    }

    public static Collection<PosItemLogDTO> createDTOs(Collection<PosItemLog> models) {
        if (models == null) {
            return null;
        }
        List<PosItemLogDTO> list = new ArrayList<PosItemLogDTO>();
        Iterator<PosItemLog> iterator = models.iterator();
        while (iterator.hasNext()) {
            PosItemLog model = iterator.next();
            PosItemLogDTO dto = createDTO(model);
            list.add(dto);
        }
        return list;
    }
}
