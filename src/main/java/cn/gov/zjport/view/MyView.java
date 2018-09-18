package cn.gov.zjport.view;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


//默认bean的id为首字母小写对应的类名
@Component
public class MyView implements View {

    //告知spring容器，contentType
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().printf("<h2>this is myview!!!!</h2>");

    }
}
