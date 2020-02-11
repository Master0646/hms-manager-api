package com.wentao.hmsmanager.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {

    public static void response(HttpServletResponse response, ApiResponse apiResponse) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(apiResponse);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

}
