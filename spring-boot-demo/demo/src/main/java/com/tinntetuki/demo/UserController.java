package com.tinntetuki.demo;

import com.tinntetuki.intf.MyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 一句话描述
 *
 * @author tinntetuki
 * @since 2020/7/20
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(HttpServletRequest request, @PathVariable Integer id) {
        //创建一个user,不走数据库只是为了分析springmvc源码
        User user = User.builder()
                .id(id)
                .age(ThreadLocalRandom.current().nextInt(30))
                .name("zzz" + id)
                .address("成都市").build();

        return user;
    }

    @RequestMapping(value = "/condition",method = RequestMethod.GET)
    public User getByNameOrAge(@RequestParam String name, @RequestParam Integer age) {
        User user = User.builder().name(name).age(age).address("成都市").id(2).build();
        return user;
    }

    @PostMapping
    public Integer saveUser(@RequestBody User user) {

        Integer id = user.getName().hashCode() - user.getAge().hashCode();

        return id > 0 ? id : -id;
    }

}
