package com.botkoda.netology.demo.Controller;

import com.botkoda.netology.demo.Exception.MyClientErrorException;
import com.botkoda.netology.demo.Exception.MyServerErrorException;
import com.botkoda.netology.demo.Operation;
import com.botkoda.netology.demo.Service.OperationService;
import com.botkoda.netology.demo.Service.TransferService;
import com.botkoda.netology.demo.Transfer;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class Controller {
    TransferService transferService;
    OperationService operationService;

    public Controller(TransferService transferService, OperationService operationService) {
        this.transferService = transferService;
        this.operationService = operationService;
    }

    @PostMapping("/transfer")
    public Map<String, String> postTransfer(@RequestBody Transfer transfer) {
        try {
            return transferService.addTransfer(transfer);
        } catch (IllegalArgumentException ex) {
            throw new MyClientErrorException("Error input data");
        } catch (RuntimeException ex) {
            throw new MyServerErrorException("Error transaction");
        }
    }


    @PostMapping("/confirmOperation")
    public Map<String, String> postOperation(@RequestBody Operation operation) {
        try {
            return operationService.addOperation(operation);
        } catch (IllegalArgumentException ex) {
            throw new MyClientErrorException("Error input data");
        } catch (RuntimeException ex) {
            throw new MyServerErrorException("Error confirmation");
        }
    }
}
