package com.example.demo3.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo3.model.Request;
import com.example.demo3.model.Systems;
import com.example.demo3.util.DateTimeUtil;
@Service
@Qualifier("ModifySystemNameRequestService")
public class ModifySystemNameRequestService implements ModifyRequestService {
    public void modify(Request request){
        request.setSystemName(Systems.System1);
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
        HttpEntity<Request> httpEntity =new HttpEntity<Request>(request);
        new RestTemplate().exchange("http://localhost:8085/feedback", HttpMethod.POST, 
    httpEntity, new ParameterizedTypeReference<>(){});
           }
}
