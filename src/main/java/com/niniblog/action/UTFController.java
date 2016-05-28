package com.niniblog.action;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Yang on 2016/5/28.
 */
@RestController
public class UTFController {

    @RequestMapping(value = "/utf")
    public String home()
    {
        return "’‚æÕ «∞Æ";
    }
}
