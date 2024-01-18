package com.actsys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: Ping
 * @date: 2023/12/9 17:07
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private Integer id;
    private String name;
    private String url;
    private String description;
    private String icon;
    private Integer parentId;
    private List<Permission> children ;

    public static List<Permission> MenuTree() {
        List<Permission> permissions = new ArrayList<>() ;
        Permission p1 = new Permission(1,
                    "活动管理", "#activities",
                  "活动管理", "fa fa-cog", 0, null ) ;
        Permission p1_1 = new Permission(2,
                "活动列表", "#activities/list",
                "活动管理", "fa fa-cog", 1, null ) ;
        Permission p1_2 = new Permission(3,
                "新增活动", "#activities/add",
                "新增活动", "fa fa-cog", 1, null ) ;
        p1.setChildren(List.of(p1_1, p1_2));

        Permission p2 = new Permission(4,
                "用户管理", "#users",
                "用户管理", "fa fa-address-boo", 0, null ) ;

        Permission p3 = new Permission(5,
                "分类管理", "#categories",
                "分类管理", "fa fa-dedent", 0, null ) ;

        Permission p3_1 = new Permission(6,
                "分类列表", "#categories/list",
                "分类列表", "fa fa-cog", 5, null ) ;
        Permission p3_2 = new Permission(7,
                "新增分类", "#categories/add",
                "新增分类", "fa fa-cog", 5, null ) ;
        p3.setChildren(List.of(p3_1, p3_2));


        permissions.add(p1);
        permissions.add(p2);
        permissions.add(p3);
        return permissions;
    }
}
