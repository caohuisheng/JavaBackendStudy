package cn.bugstack.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: chs
 * Description: 管理者类（用于操作记录备忘录信息）
 * CreateTime: 2024-10-17
 */
public class Admin {

    private int cursorIdx = 0;
    private List<ConfigFileMemo> memoList = new ArrayList<>();
    private Map<String, ConfigFileMemo> memoMap = new ConcurrentHashMap<>();

    public void append(ConfigFileMemo memo){
        memoList.add(memo);
        memoMap.put(memo.getConfigFile().getVersionNo(), memo);
        cursorIdx++;
    }

    public ConfigFileMemo undo(){
        if(--cursorIdx <= 0) return memoList.get(0);
        return memoList.get(cursorIdx);
    }

    public ConfigFileMemo redo(){
        if(++cursorIdx >= memoList.size()) return memoList.get(memoList.size() - 1);
        return memoList.get(cursorIdx);
    }

    public ConfigFileMemo get(String versionNo){
        return memoMap.get(versionNo);
    }

}
