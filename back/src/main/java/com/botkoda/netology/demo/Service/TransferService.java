package com.botkoda.netology.demo.Service;

import com.botkoda.netology.demo.Repository.TransferRepository;
import com.botkoda.netology.demo.Transfer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TransferService {
    TransferRepository transferRepository;

    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;

    }

    public Map<String,String> addTransfer(Transfer transfer) {
        final Map<String,String> map=new HashMap<>();
        final Transfer save = transferRepository.save(transfer);
        map.put("operationId",""+save.getId());
        return map;
    }
}
