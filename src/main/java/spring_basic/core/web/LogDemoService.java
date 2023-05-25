package spring_basic.core.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import spring_basic.core.common.Mylogger;

@Service
@RequiredArgsConstructor
public class LogDemoService
{
    private final Mylogger mylogger;

    public void logic(String id)
    {
        mylogger.log("service id = " + id);
    }
}
