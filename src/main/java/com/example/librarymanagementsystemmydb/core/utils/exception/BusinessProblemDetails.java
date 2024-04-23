package com.example.librarymanagementsystemmydb.core.utils.exception;

public class BusinessProblemDetails extends ProblemDetails
{
    public BusinessProblemDetails(String detail){
        setDetail(detail);
        setTitle("Business Rule Violation");
        setType("BusinessException");
    }
}
