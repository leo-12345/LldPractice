package com.LowLevelDesign.controller;

import com.LowLevelDesign.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
  @Autowired
  MenuService menuService;
  @GetMapping("/menu")
  public ResponseEntity<String> startOperation(){
    menuService.showMenu();
    return ResponseEntity.ok().body("Successfully shown the menu options.");
  }


}
