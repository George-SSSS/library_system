package cn.edu.whu.library.modules.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class HomeController {

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        //从 SecurityContextHolder 中得到 Authentication 对象，进而获取权限列表，传到前端
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<GrantedAuthority> authorityCollection = (Collection<GrantedAuthority>) authentication.getAuthorities();
        model.addAttribute("authorities", authorityCollection.toString());
        model.addAttribute("username", authentication.getName());
        return "index";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
