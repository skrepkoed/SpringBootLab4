package com.example.demo4.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo4.model.Response;
@Service
@Qualifier("ModifyOperationUidResponseService")
public class ModifyOperationUidResponseService implements ModifyResponseService {
    public Response modify(Response response){
        UUID uuid=UUID.randomUUID();
        response.setOperationUid(uuid.toString());   
        return response;
    }
}
