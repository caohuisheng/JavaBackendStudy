package cn.bugstack.design;

import cn.bugstack.design.ceil.LevelOneCeiling;
import cn.bugstack.design.ceil.LevelTwoCeiling;
import cn.bugstack.design.coat.DuluxCoat;
import cn.bugstack.design.coat.LibangCoat;
import cn.bugstack.design.floor.DerFloor;
import cn.bugstack.design.floor.ShengXiangFloor;
import cn.bugstack.design.tile.DongPengTile;
import cn.bugstack.design.tile.MarcoPoloTile;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-05
 */
public class DecorationPackageController {

    public String getDecorationList(BigDecimal area, Integer level){
        List<Matter> list = new ArrayList<>();
        BigDecimal price = BigDecimal.ZERO;

        //豪华款式
        if(1 == level){
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling(); //吊顶（二级顶）
            DuluxCoat duluxCoat = new DuluxCoat();                   //涂料（多乐士）
            ShengXiangFloor shengXiangFloor = new ShengXiangFloor(); //地板（圣象）

            list.add(levelTwoCeiling);
            list.add(duluxCoat);
            list.add(shengXiangFloor);

            price = price.add(area.multiply(new BigDecimal(0.2)).multiply(levelTwoCeiling.price()))
                    .add(area.multiply(new BigDecimal(1.4)).multiply(duluxCoat.price()))
                    .add(area.multiply(shengXiangFloor.price()));
        }else if(2 == level){ //轻奢花园
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling(); //吊顶（二级顶）
            LibangCoat libangCoat = new LibangCoat();                //涂料（立邦）
            MarcoPoloTile marcoPoloTile = new MarcoPoloTile();       //瓷砖（马可波罗）

            list.add(levelTwoCeiling);
            list.add(libangCoat);
            list.add(marcoPoloTile);

            price = price.add(area.multiply(new BigDecimal(0.2)).multiply(levelTwoCeiling.price()))
                    .add(area.multiply(new BigDecimal(1.4)).multiply(libangCoat.price()))
                    .add(area.multiply(marcoPoloTile.price()));
        }else if(3 == level){ //轻奢花园
            LevelOneCeiling levelOneCeiling = new LevelOneCeiling(); //吊顶（一级顶）
            LibangCoat libangCoat = new LibangCoat();                //涂料（立邦）
            DongPengTile dongPengTile = new DongPengTile();          //瓷砖（东鹏）

            list.add(levelOneCeiling);
            list.add(libangCoat);
            list.add(dongPengTile);

            price = price.add(area.multiply(new BigDecimal(0.2)).multiply(levelOneCeiling.price()))
                    .add(area.multiply(new BigDecimal(1.4)).multiply(libangCoat.price()))
                    .add(area.multiply(dongPengTile.price()));
        }

        StringBuilder sb = new StringBuilder("****装修清单****\n" +
                "套餐等级：" + level + "\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\n" +
                "房屋面积：" + area.doubleValue() + " 平米\n" +
                "材料清单：\n");
        for(Matter matter:list){
            sb.append(matter.scene()).append(":").append(matter.brand()+"、").append(matter.model()+"、").append("平米价格：" + matter.price() + "元\n");
        }

        return sb.toString();
    }

}
