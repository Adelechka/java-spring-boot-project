package ru.itis.reddit.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//@Controller
//public class MyErrorController implements ErrorController {
//
//    @RequestMapping("/error")
//    @ResponseBody
//    public String handleError(HttpServletRequest request, Model model) {
//        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
//        model.addAttribute("statusCode", request.getAttribute("javax.servlet.error.status_code"));
//        model.addAttribute("exception", exception == null ? "N/A" : exception.getMessage());
//        return "error";
//    }
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
//}
