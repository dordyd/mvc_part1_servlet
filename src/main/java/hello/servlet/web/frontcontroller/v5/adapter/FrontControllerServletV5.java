//package hello.servlet.web.frontcontroller.v5.adapter;
//
//import hello.servlet.web.frontcontroller.ModelView;
//import hello.servlet.web.frontcontroller.MyView;
//import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
//import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
//import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
//import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
//public class FrontControllerServletV5 extends HttpServlet {
//
//    private final Map<String, Object> handlerMappingMap = new HashMap<>();
//    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();
//
//    public FrontControllerServletV5() {
//        initHandlerMappingMap();
//        initHandlerAdapters();
//    }
//
//    private void initHandlerMappingMap(){
//        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
//        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
//        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
//    }
//
//    private void initHandlerAdapters(){
//        handlerAdapters.add(new ControllerV3HandlerAdapter());
//    }
//
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Object handler = getHandler(request);
//        if (handler == null) {
//            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//            return; }
//        MyHandlerAdapter adapter = getHandlerAdapter(handler);
//        ModelView mv = adapter.handle(request, response, handler);
//        MyView view = viewResolver(mv.getViewName());
//        view.render(mv.getModel(), request, response);
//    }
//}
