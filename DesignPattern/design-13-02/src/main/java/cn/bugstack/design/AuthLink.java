package cn.bugstack.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: chs
 * Description: 审核节点抽象类
 * CreateTime: 2024-10-13
 */
public abstract class AuthLink {

    protected Logger log = LoggerFactory.getLogger(AuthLink.class);

    protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected String authUserId;    //审核人id
    protected String authUserName;  //审核人姓名
    private AuthLink next;          //下一个审核节点

    public AuthLink(String authUserId, String authUserName){
        this.authUserId = authUserId;
        this.authUserName = authUserName;
    }

    public AuthLink next(){
        return next;
    }

    public AuthLink appendNext(AuthLink next){
        this.next = next;
        return next;
    }

    /**
     *
     * @param uId
     * @param orderId
     * @param authDate
     * @return
     */
    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);

}
