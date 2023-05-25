package spring_basic.core.web;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring_basic.core.common.Mylogger;

@Controller
@RequiredArgsConstructor
public class LogDemoController
{
    private final LogDemoService logDemoService;
    private final Mylogger mylogger;

    @RequestMapping("log-demo")
    @ResponseBody//View 화면이 없이 문자만 반환하고싶을때
    public String logDemo(HttpServletRequest request) throws InterruptedException
    {
        String requestURL = request.getRequestURL().toString();
        mylogger.setRequestURL(requestURL);

        mylogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
