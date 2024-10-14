package cn.bugstack.design.group;

import cn.bugstack.design.lang.Collection;
import cn.bugstack.design.lang.Iterator;

import java.util.*;

/**
 * Author: chs
 * Description: 组织结构
 * CreateTime: 2024-10-14
 */
public class GroupStructure implements Collection<Employee, Link> {

    private String groupId;     //组织id(组织的顶级员工id)
    private String groupName;   //组织名称
    private Map<String, Employee> employeeMap = new HashMap<>(); //员工id-员工map
    private Map<String, List<Link>> linkMap = new HashMap<>();   //组织结构：linkMap[nodeId]标识id为nodeId的员工的下级链接
    private Map<String, String> invertedMap = new HashMap<>();   //反向链接：invertedMap[nodeId]表示id为nodeId的员工的上级员工id

    public GroupStructure(String groupId, String groupName){
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Override
    public boolean add(Employee employee) {
        return null == employeeMap.put(employee.getuId(), employee);
    }

    @Override
    public boolean remove(Employee employee) {
        return null != employeeMap.remove(employee.getuId());
    }

    @Override
    public boolean addLink(String key, Link link) {
        String from = link.getFrom();
        String to = link.getTo();
        //添加反向链接信息
        invertedMap.put(to, from);
        //判断链接的from节点是否存在
        if(linkMap.get(from) == null){
            List<Link> links = new ArrayList<>();
            links.add(link);
            linkMap.put(from, links);
            return true;
        }else{
            return linkMap.get(from).add(link);
        }
    }

    @Override
    public boolean removeLink(String key) {
        return null != linkMap.remove(key);
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>(){
            //当前遍历的节点id
            private String nodeId = groupId;
            //当前遍历的节点序号
            private int idx = 0;
            //每个节点当前遍历的子节点序号：keyMap[nodeId]表示id为nodeId的节点当前遍历到的子节点序号
            private Map<String, Integer> keyMap = new HashMap<>();

            @Override
            public boolean hasNext() {
                return idx < employeeMap.size();
            }

            @Override
            public Employee next() {
                //获取当前遍历节点的所有链接
                List<Link> links = linkMap.get(nodeId);
                int cursorIdx;

                if(links == null){
                    //不存在链接，说明为叶子节点，寻找同级节点
                    nodeId = invertedMap.get(nodeId);
                    links = linkMap.get(nodeId);
                    cursorIdx = getCursorIdx(nodeId);
                }else{
                    //存在链接，查找当前遍历的子节点
                    cursorIdx = getCursorIdx(nodeId);
                }

                //若子节点都遍历完了，回到上级节点
                while(cursorIdx >= links.size()){
                    nodeId = invertedMap.get(nodeId);
                    links = linkMap.get(nodeId);
                    cursorIdx = getCursorIdx(nodeId);
                }

                // 获取当前节点并返回
                Link link = links.get(cursorIdx);
                nodeId = link.getTo();
                idx++;

                return employeeMap.get(nodeId);
            }

            //获取id为nodeId的节点当前遍历到的子节点序号
            private int getCursorIdx(String nodeId){
                int cursorIdx = 0;
                if(keyMap.containsKey(nodeId)){
                    //存在nodeId，说明子节点被遍历过，序号+1并返回
                    cursorIdx = keyMap.get(nodeId);
                    keyMap.put(nodeId, ++cursorIdx);
                }else{
                    //不存在nodeId, 说明子节点没被遍历过, 初始化0
                    keyMap.put(nodeId, cursorIdx);
                }
                return cursorIdx;
            }

        };
    }
}
