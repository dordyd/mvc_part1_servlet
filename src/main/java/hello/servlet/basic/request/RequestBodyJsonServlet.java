package hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * JSON 형식 전송
 *
 * content-type -> json
 * message body: {"id": 1, "username":"hello", "age":20}
 */
@WebServlet(name="requestBodyJsonServlet", urlPatterns = "/request-json")
public class RequestBodyJsonServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        HelloData data = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println(data);
        response.getWriter().write(data.toString());
        response.getWriter().write(data.getUsername());

    }
}
