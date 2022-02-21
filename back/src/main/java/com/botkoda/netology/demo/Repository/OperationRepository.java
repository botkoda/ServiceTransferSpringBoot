package com.botkoda.netology.demo.Repository;

import com.botkoda.netology.demo.Operation;
import org.springframework.data.repository.CrudRepository;

public interface OperationRepository  extends CrudRepository<Operation,Long> {
}
