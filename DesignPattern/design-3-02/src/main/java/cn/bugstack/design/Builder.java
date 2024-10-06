package cn.bugstack.design;

import cn.bugstack.design.ceil.LevelOneCeiling;
import cn.bugstack.design.ceil.LevelTwoCeiling;
import cn.bugstack.design.coat.DuluxCoat;
import cn.bugstack.design.coat.LibangCoat;
import cn.bugstack.design.floor.ShengXiangFloor;
import cn.bugstack.design.tile.DongPengTile;
import cn.bugstack.design.tile.MarcoPoloTile;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description: 装修套餐建造者
 * CreateTime: 2024-10-06
 */
public class Builder {

    public IMenu levelOne(BigDecimal area){
        return new DecorationPackageMenu(area,1).appendCeil(new LevelTwoCeiling())
                .appendCoat(new DuluxCoat())
                .appendFloor(new ShengXiangFloor());
    }

    public IMenu levelTwo(BigDecimal area){
        return new DecorationPackageMenu(area,2).appendCeil(new LevelTwoCeiling())
                .appendCoat(new LibangCoat())
                .appendFloor(new MarcoPoloTile());
    }

    public IMenu levelThree(BigDecimal area){
        return new DecorationPackageMenu(area,3).appendCeil(new LevelOneCeiling())
                .appendCoat(new LibangCoat())
                .appendFloor(new DongPengTile());
    }

}
