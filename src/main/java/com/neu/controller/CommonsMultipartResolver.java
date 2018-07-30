package com.neu.controller;

import javax.servlet.http.HttpServletRequest;

public class CommonsMultipartResolver extends org.springframework.web.multipart.commons.CommonsMultipartResolver {
    public boolean isMultipart(HttpServletRequest request)
    {
        String url = request.getRequestURI();
        if (url != null && url.contains("ue/jsp"))
        {
            return false;
        }
        else
        {
            return super.isMultipart(request);
        }
    }
}
