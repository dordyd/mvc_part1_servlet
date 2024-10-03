package hello.servlet.basic.ResponseHeaderServlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("content-type", "application/json");
        response.setCharacterEncoding("utf-8");
        Cookie cookie = new Cookie("data", "yammy");
        cookie.setMaxAge(100);
        response.addCookie(cookie);
        HelloData helloData = new HelloData();

        //{"id":1, "username": "hello", "age": 20} 를 보내는 것과 같음
        helloData.setId(1L);
        helloData.setUsername("hello");
        helloData.setAge(20);

        String result = objectMapper.writeValueAsString(helloData);

        response.getWriter().write(result);
    }
}
