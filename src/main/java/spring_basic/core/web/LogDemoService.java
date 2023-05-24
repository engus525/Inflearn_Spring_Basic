package spring_basic.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import spring_basic.core.common.Mylogger;

@Service
@RequiredArgsConstructor
public class LogDemoService
{
    private final ObjectProvider<Mylogger> myloggerProvider;

    public void logic(String id)
    {
        Mylogger mylogger = myloggerProvider.getObject();
        mylogger.log("service id = " + id);
    }
}
