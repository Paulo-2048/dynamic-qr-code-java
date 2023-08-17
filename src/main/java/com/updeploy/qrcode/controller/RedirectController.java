package com.updeploy.qrcode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.updeploy.qrcode.service.RedirectService;

@RestController
public class RedirectController {
  
  @Autowired
  private RedirectService redirectService;

  @GetMapping("/{reference}")
  public RedirectView getById(@PathVariable("reference") String reference, RedirectAttributes attributes) throws Exception {
    String redirectUrl = redirectService.getRetirectByReference(reference);

    attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");

    return new RedirectView(redirectUrl);
  }
}
