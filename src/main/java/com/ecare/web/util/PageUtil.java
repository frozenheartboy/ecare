package com.ecare.web.util;

import com.ecare.web.vo.PageVo;

/**
 * Created by L on 2016/7/14.
 */
public class PageUtil {
    private static PageVo page;

    private PageUtil() {
    }
    public static synchronized PageVo getPage(Integer pageStart, Integer pageSize) {
        if (page == null)
            page = new PageVo();
        page.setPageSize(pageSize);
        page.setPageStart(pageStart * pageSize);
        return page;
    }

}
