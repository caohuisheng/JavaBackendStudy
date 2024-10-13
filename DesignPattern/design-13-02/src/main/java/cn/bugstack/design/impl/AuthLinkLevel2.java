package cn.bugstack.design.impl;

import cn.bugstack.design.AuthInfo;
import cn.bugstack.design.AuthLink;
import cn.bugstack.design.AuthService;

import java.text.ParseException;
import java.util.Date;

/**
 * Author: chs
 * Description: 二级审核节点
 * CreateTime: 2024-10-13
 */
public class AuthLinkLevel2 extends AuthLink {

    private Date beginDate = sdf.parse("2024-10-10 00:00:00");
    private Date endDate = sdf.parse("2024-10-20 23:59:59");

    public AuthLinkLevel2(String authUserId, String authUserName) throws ParseException {
        super(authUserId, authUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(authUserId, orderId);
        if(date == null) {
            return new AuthInfo("0001",orderId, authUserName);
        }
        //查询下级节点并开始审核
        AuthLink nextAuthLink = next();
        //如果下级节点为空,则审核完成直接返回
        if(null == nextAuthLink) {
            return new AuthInfo("0000",orderId, authUserName);
        }
        //如果不在一级节点审核时间范围内,则审核完成直接返回
        if(authDate.before(beginDate) || authDate.after(endDate)){
            return new AuthInfo("0000",orderId, authUserName);
        }

        //下级节点审核
        return nextAuthLink.doAuth(uId, orderId, authDate);
    }
}
