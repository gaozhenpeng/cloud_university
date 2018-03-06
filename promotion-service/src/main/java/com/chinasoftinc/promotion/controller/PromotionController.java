package com.chinasoftinc.promotion.controller;

import io.servicecomb.provider.rest.common.RestSchema;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.core.MediaType;

/**
 * Created by VerRan.Liu on 2017/12/21.
 */
@RestSchema(schemaId = "test")
@RequestMapping(path = "/promotion", produces = MediaType.TEXT_PLAIN)
public class PromotionController {
    @ResponseBody
    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET)
    public String add(@PathVariable String name) {
        return "hello" + name;
    }
}
