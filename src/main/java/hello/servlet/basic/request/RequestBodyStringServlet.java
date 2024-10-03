package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String messageBody1 = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8); // stream 을 UTF-8 형식에 맞춰 string형으로 반환
        String messageBody2 = inputStream.toString(); // -> stream 객체의 주소값을 반환
        System.out.println("messageBody1 = " + messageBody1);
        System.out.println("messageBody2 = " + messageBody2);

    }
}
