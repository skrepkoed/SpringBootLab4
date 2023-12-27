package com.example.demo4.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {
    @NotBlank
    @Size(max = 32)
    private String uid;
    @NotBlank
    @Size(max = 32)
    private String operationUid;
    private Systems systemName;
    @NotBlank
    private String  systemTime;
    private String source;
    @Min(1)
    @Max(100000)
    private int communicationId;
    private int templateId;
    private int productCode;
    private int smsCode;

    public String toString(){
        return "{"+
        "uid='"+uid+"\'"+
        "operationUid'"+operationUid+"\'"+
        "systemName'"+systemName+"\'"+
        "systemTime'"+operationUid+"\'"+
        "source'"+source+"\'"+
        "communicationId'"+communicationId+"\'"+
        "templateId'"+templateId+"\'"+
        "productCode'"+productCode+"\'"+
        "smsCode'"+smsCode+"\'"+
        "}";
    }
    public void setSystemName(Systems systems){
        this.systemName=systems;
    }
}
