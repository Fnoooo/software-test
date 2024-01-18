package com.actsys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @desc:
 * @author: Ping
 * @date: 2023/12/12 9:43
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO {
    private Integer id;
    private String name;

    public static List<CategoryVO> categoryVOList() {
        return List.of(new CategoryVO(1, "分类1"),
                    new CategoryVO(2, "分类2"),
                    new CategoryVO(3, "分类3"));
    }

}
