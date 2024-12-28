package com.library.spring_boot_library.model.requestModels;

public class AdminQuestionRequest {

    private Long id;

    private String response;

    public Long getId() {
        return id;
    }

    public AdminQuestionRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public String getResponse() {
        return response;
    }

    public AdminQuestionRequest setResponse(String response) {
        this.response = response;
        return this;
    }
}
