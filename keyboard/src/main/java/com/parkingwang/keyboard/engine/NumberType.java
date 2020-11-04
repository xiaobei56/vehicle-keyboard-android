package com.parkingwang.keyboard.engine;

import static com.parkingwang.keyboard.engine.VNumberChars.NUMERIC_123;

/**
 * @author 陈哈哈 yoojiachen@gmail.com
 */
public enum NumberType {
    /**
     * 未知类型
     */
    AUTO_DETECT,

    /**
     * 民用
     */
    CIVIL,

    /**
     * 新能源车牌
     */
    NEW_ENERGY,

    /**
     * 新式武警车牌
     */
    WJ2012,

    /**
     * 新式军车车牌
     */
    PLA2012,

    /**
     * 旧式大使馆车牌
     */
    SHI2012,

    /**
     * 新式大使馆车牌
     */
    SHI2017,

    /**
     * 旧式领事馆车牌
     */
    LING2012,

    /**
     * 新式领事馆车牌
     */
    LING2018,

    /**
     * 民航车牌
     */
    AVIATION;

    /**
     * 检测车牌号码所属的车牌号码类型
     *
     * @param number 车牌号码
     * @return 号码类型
     */
    public static NumberType detect(String number) {
        return NEW_ENERGY;
    }

    private static boolean contains(String s, char c) {
        return s.indexOf(c) >= 0;
    }

    public int maxLength() {
        switch (this) {
            case NEW_ENERGY:
                return 8;

            default:
                return 7;
        }
    }

    public boolean isAnyOf(NumberType... types) {
        for (NumberType t : types) {
            if (this.equals(t)) {
                return true;
            }
        }
        return false;
    }
}


