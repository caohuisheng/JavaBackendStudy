package cn.bugstack.design;

import cn.bugstack.design.model.aggregate.TreeRich;
import cn.bugstack.design.model.vo.EngineResult;
import cn.bugstack.design.model.vo.TreeNode;
import cn.bugstack.design.model.vo.TreeNodeLink;
import cn.bugstack.design.model.vo.TreeRoot;
import cn.bugstack.design.service.engine.IEngine;
import cn.bugstack.design.service.engine.impl.TreeEngineHandle;
import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-09
 */
public class ApiTest {

    private TreeRich treeRich;

    /*
     1
     /\
    2  3
   /\  /\
  4 5 6  7
     */
    @Before
    public void init(){
        //节点：1
        TreeNode treeNode_1 = new TreeNode();
        treeNode_1.setTreeId(10001L);
        treeNode_1.setTreeNodeId(1L);
        treeNode_1.setNodeType(1);
        treeNode_1.setNodeValue(null);
        treeNode_1.setRuleKey("userGender");
        treeNode_1.setRuleDesc("用户性别[男/女]");
        //链接：1->2
        TreeNodeLink treeNodeLink_2 = new TreeNodeLink();
        treeNodeLink_2.setNodeIdFrom(1L);
        treeNodeLink_2.setNodeIdTo(2L);
        treeNodeLink_2.setRuleLimitType(1);
        treeNodeLink_2.setRuleLimitValue("man");
        //链接：1->3
        TreeNodeLink treeNodeLink_3 = new TreeNodeLink();
        treeNodeLink_3.setNodeIdFrom(1L);
        treeNodeLink_3.setNodeIdTo(3L);
        treeNodeLink_3.setRuleLimitType(1);
        treeNodeLink_3.setRuleLimitValue("woman");
        treeNode_1.setTreeNodeLinkList(new ArrayList<TreeNodeLink>(){{
            add(treeNodeLink_2);
            add(treeNodeLink_3);
        }});

        //节点：2
        TreeNode treeNode_2 = new TreeNode();
        treeNode_2.setTreeId(10001L);
        treeNode_2.setTreeNodeId(2L);
        treeNode_2.setNodeType(1);
        treeNode_2.setNodeValue(null);
        treeNode_2.setRuleKey("userAge");
        treeNode_2.setRuleDesc("用户年龄");
        //链接：2->4
        TreeNodeLink treeNodeLink_4 = new TreeNodeLink();
        treeNodeLink_4.setNodeIdFrom(2L);
        treeNodeLink_4.setNodeIdTo(4L);
        treeNodeLink_4.setRuleLimitType(4);
        treeNodeLink_4.setRuleLimitValue("25");
        //链接：2->5
        TreeNodeLink treeNodeLink_5 = new TreeNodeLink();
        treeNodeLink_5.setNodeIdFrom(2L);
        treeNodeLink_5.setNodeIdTo(5L);
        treeNodeLink_5.setRuleLimitType(5);
        treeNodeLink_5.setRuleLimitValue("25");
        treeNode_2.setTreeNodeLinkList(new ArrayList<TreeNodeLink>(){{
            add(treeNodeLink_4);
            add(treeNodeLink_5);
        }});

        //节点：3
        TreeNode treeNode_3 = new TreeNode();
        treeNode_3.setTreeId(10001L);
        treeNode_3.setTreeNodeId(3L);
        treeNode_3.setNodeType(1);
        treeNode_3.setNodeValue(null);
        treeNode_3.setRuleKey("userAge");
        treeNode_3.setRuleDesc("用户年龄");
        //链接：3->6
        TreeNodeLink treeNodeLink_6 = new TreeNodeLink();
        treeNodeLink_6.setNodeIdFrom(3L);
        treeNodeLink_6.setNodeIdTo(6L);
        treeNodeLink_6.setRuleLimitType(4);
        treeNodeLink_6.setRuleLimitValue("25");
        //链接：3->7
        TreeNodeLink treeNodeLink_7 = new TreeNodeLink();
        treeNodeLink_7.setNodeIdFrom(3L);
        treeNodeLink_7.setNodeIdTo(7L);
        treeNodeLink_7.setRuleLimitType(5);
        treeNodeLink_7.setRuleLimitValue("25");
        treeNode_3.setTreeNodeLinkList(new ArrayList<TreeNodeLink>(){{
            add(treeNodeLink_6);
            add(treeNodeLink_7);
        }});

        //节点：4
        TreeNode treeNode_4 = new TreeNode();
        treeNode_4.setTreeId(10001L);
        treeNode_4.setTreeNodeId(4L);
        treeNode_4.setNodeType(2);
        treeNode_4.setNodeValue("果实A");
        //节点：5
        TreeNode treeNode_5 = new TreeNode();
        treeNode_5.setTreeId(10001L);
        treeNode_5.setTreeNodeId(5L);
        treeNode_5.setNodeType(2);
        treeNode_5.setNodeValue("果实B");
        //节点：6
        TreeNode treeNode_6 = new TreeNode();
        treeNode_6.setTreeId(10001L);
        treeNode_6.setTreeNodeId(6L);
        treeNode_6.setNodeType(2);
        treeNode_6.setNodeValue("果实C");
        //节点：7
        TreeNode treeNode_7 = new TreeNode();
        treeNode_7.setTreeId(10001L);
        treeNode_7.setTreeNodeId(7L);
        treeNode_7.setNodeType(2);
        treeNode_7.setNodeValue("果实D");

        TreeRoot treeRoot = new TreeRoot();
        treeRoot.setTreeId(10001L);
        treeRoot.setTreeRootNodeId(1L);
        treeRoot.setTreeName("规则决策树");
        Map<Long,TreeNode> treeNodeMap = new HashMap<Long,TreeNode>(){{
           put(1L,treeNode_1);
           put(2L,treeNode_2);
           put(3L,treeNode_3);
           put(4L,treeNode_4);
           put(5L,treeNode_5);
           put(6L,treeNode_6);
           put(7L,treeNode_7);
        }};
        treeRich = new TreeRich(treeRoot, treeNodeMap);
    }

    @Test
    public void test_tree(){
        System.out.println("规则树结构信息：" + JSON.toJSONString(treeRich));

        IEngine engine = new TreeEngineHandle();
        Map<String,String> decisionMatter = new HashMap<>();
        decisionMatter.put("gender","man");
        decisionMatter.put("age","35");

        EngineResult result = engine.process(10001L, "chs", treeRich, decisionMatter);
        System.out.println("测试结果：" + JSON.toJSONString(result));
    }

}
