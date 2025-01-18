package com.shev8987.spring.demo.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * Статичный справочник ролей пользователей
 */
@AllArgsConstructor
@Getter
public enum RoleEnum {
    ADMIN(1L, "ADMIN"),
    EMPLOYEE(2L, "EMPLOYEE"),
    USER(3L, "USER");

    private final Long id;
    private final String name;

    public static RoleEnum resolve(Long id) {
        for (RoleEnum value : values()) {
            if (Objects.equals(value.getId(), id)) {
                return value;
            }
        }

        return null;
    }
}
