package com.esc.springcinema.captcha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecaptchaController {
    @ResponseBody
    @RequestMapping(value = "/robot", method = RequestMethod.POST)
    public int VerifyRecaptcha(@RequestParam("recaptcha") String recaptcha) {
        VerifyRecaptcha.setSecretKey("6LdXh54jAAAAACcpuTDar5spEXCGvIGhdUzj722e");

        try {
            if(VerifyRecaptcha.verify(recaptcha)) {
                return  0;
            }
            else return 1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return  -1;
        }
    }
}
