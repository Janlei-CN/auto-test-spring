package com.janlei.ctrl;

import com.janlei.annotation.Idempotent;
import com.janlei.util.TokenUtis;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
public class TokenController {

    @Autowired
    TokenUtis tokenUtis;

    @GetMapping("/token")
    public ResultPage getToken() throws JSONException {
        String token = tokenUtis.generateToken();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token",token);
        return ResultPage.sucess(CodeMsg.SUCESS,jsonObject);
    }

    @Idempotent
    @GetMapping("/test")
    public ResultPage testIdempotent(){
        return ResultPage.sucess(CodeMsg.SUCESS,"校验成功");
    }
}