package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @GetMapping("/")
    public String pos(Model model) {
        posService.add("PD1", 2);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total", posService.getTotal());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model,
                      @RequestParam String productId,
                      @RequestParam(required = false, defaultValue = "1") int amount) {
        posService.add(productId, amount);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total", posService.getTotal());
        return "index";
    }

    @GetMapping("/remove")
    public String remove(Model model, @RequestParam String productId) {
        posService.remove(productId);
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total", posService.getTotal());
        return "index";
    }

    @GetMapping("/clear")
    public String clear(Model model) {
        posService.newCart();
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total", posService.getTotal());
        return "index";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        posService.checkout();
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total", posService.getTotal());
        return "index";
    }

}
