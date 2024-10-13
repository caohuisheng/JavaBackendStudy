package cn.bugstack.design;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-13
 */
public class AuthController {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 查询当前审核节点信息
     * @param uId 审核人id
     * @param orderId 订单id
     * @param authDate 审核日期
     * @return 当前审核节点信息
     */
    public AuthInfo doAuth(String uId, String orderId, Date authDate) throws ParseException {
        /**
         * 10.10-10.20:需要三二一级审批
         * 10.01-10.30:需要三二级审批
         * 其它时间:需要三级审批
         */
        //三级审批
        Date date = AuthService.queryAuthInfo("100013", orderId);
        if(null == date) return new AuthInfo("0001", orderId,"张总");

        //二级审批
        if(authDate.after(sdf.parse("2024-10-01 00:00:00")) && authDate.before(sdf.parse("2024-10-30 23:59:59"))){
            date = AuthService.queryAuthInfo("100012", orderId);
            if(null == date) return new AuthInfo("0001", orderId, "刘总");
        }

        //一级审批
        if(authDate.after(sdf.parse("2024-10-10 00:00:00")) && authDate.before(sdf.parse("2024-10-20 00:00:00"))){
            date = AuthService.queryAuthInfo("100011", orderId);
            if(null == date) return new AuthInfo("0001", orderId, "李总");
        }

        return new AuthInfo("0001",orderId, null);
    }

}
