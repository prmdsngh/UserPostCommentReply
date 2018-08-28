package com.pramod.templates;

import java.io.Serializable;

import lombok.Data;

@Data
public class ErrorTemplate implements Serializable{

    private static final long serialVersionUID = -7339790043828169476L;

    private String code;
    private String field;
    private String message;

}
