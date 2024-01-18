package com.actsys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @desc:
 * @author: Ping
 * @date: 2023/12/12 9:26
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResultVO {

    private List rows ;
    private long total ;

    public static PageResultVO returnPageResult(List rows, long total) {
        return new PageResultVO(rows, total);
    }
}
