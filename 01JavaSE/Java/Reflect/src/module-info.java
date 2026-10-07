import com.itheima.demo7.MyService;
import com.itheima.demo7.impl.itheima;
import com.itheima.demo7.impl.aiguigu;

module Reflect {
    exports com.itheima.demo6;
    exports com.itheima.demo7;

    provides MyService with aiguigu;
}