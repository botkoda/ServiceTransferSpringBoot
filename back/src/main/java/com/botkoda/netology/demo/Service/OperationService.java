package com.botkoda.netology.demo.Service;

import com.botkoda.netology.demo.Operation;
import com.botkoda.netology.demo.Repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class OperationService {
    OperationRepository operationRepository;

    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public Map<String, String> addOperation(Operation operation) {
        final Map<String, String> map = new HashMap<>();
        final Operation save = operationRepository.save(operation);
        map.put("operationId", "" + save.getOperationId());
        map.put("code", "" + save.getCode());
        return map;

    }

}
