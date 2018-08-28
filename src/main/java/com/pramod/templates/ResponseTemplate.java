package com.pramod.templates;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate implements Serializable{

    private static final long serialVersionUID = 7864676590658699144L;

    private String code;
    private Object data;
    private String message;
    private List<ErrorTemplate> errors;

}