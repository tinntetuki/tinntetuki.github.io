package com.tinntetuki.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 一句话描述
 *
 * @author tinntetuki
 * @since 2020/7/20
 */
@Data
@Builder
@AllArgsConstructor
public class User {
    private Integer id;

    private String name;

    private Integer age;

    private String address;

    public User() {

    }
}
