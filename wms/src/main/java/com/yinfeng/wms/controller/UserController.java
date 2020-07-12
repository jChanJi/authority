package com.yinfeng.wms.controller;

import com.yinfeng.wms.domain.User;
import com.yinfeng.wms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jonas
 * @time 2020 07 11 10 55
 * @description: wms
 */
@RestController
public class UserController {

    @Resource
    UserService userService;
    @GetMapping("role")
    public User getUserInfoByName(String name){
        return  userService.getUserInfoByName(name);
    }


    @RequestMapping("/login")
    public String login(User user) {
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                user.getName(),
                user.getPassword()
        );
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return "没有权限";
        }
        return "login success";
    }
    /**
     * 注解验角色和权限
     */
   /* @RequiresRoles("user")
    @RequiresPermissions("query")*/
   @RequiresRoles("admin")
   @RequiresPermissions("modify")
    @RequestMapping("/index")
    public String index() {
        return "index!";
    }
}
