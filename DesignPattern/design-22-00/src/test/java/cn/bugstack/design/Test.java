package cn.bugstack.design;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Collectors;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class Test {
    static class People implements Cloneable{
        private String name;
        private String sex;
        private String major;

        public People(String name, String sex, String major) {
            this.name = name;
            this.sex = sex;
            this.major = major;
        }

        public String getName() {
            return name;
        }

        public String getSex() {
            return sex;
        }

        public String getMajor() {
            return major;
        }

        @Override
        public String toString() {
            return name;
        }

    }
}
