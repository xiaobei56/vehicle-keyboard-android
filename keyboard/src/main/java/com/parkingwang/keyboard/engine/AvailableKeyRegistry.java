package com.parkingwang.keyboard.engine;

import java.util.HashMap;
import java.util.Map;

import static com.parkingwang.keyboard.engine.NumberType.CIVIL;
import static com.parkingwang.keyboard.engine.NumberType.NEW_ENERGY;
import static com.parkingwang.keyboard.engine.Utils.mkEntitiesOf;
import static com.parkingwang.keyboard.engine.VNumberChars.CIVIL_PROVINCES;
import static com.parkingwang.keyboard.engine.VNumberChars.NUMERIC;
import static com.parkingwang.keyboard.engine.VNumberChars.QWERTY_has_O;
import static com.parkingwang.keyboard.engine.VNumberChars.QWERTY_no_O;

/**
 * 键盘布局注册管理器。
 * 根据当前指定车牌号码类型、选中序号，返回当前可用的全部键位数据。
 *
 * @author 陈哈哈 yoojiachen@gmail.com
 */
class AvailableKeyRegistry {

    private final Map<String, RowEntry> mCache = new HashMap<>();

    AvailableKeyRegistry() {
        //// 民用车牌
        final RowEntry lettersNumeric = mkEntitiesOf(QWERTY_no_O + NUMERIC);
        final RowEntry civilProvince = mkEntitiesOf(CIVIL_PROVINCES);
        final RowEntry lettersHasO = mkEntitiesOf(QWERTY_has_O);
        final RowEntry lettersHasONumeric = mkEntitiesOf(NUMERIC + QWERTY_has_O);
        //// 新能源车牌
        final RowEntry numericDF = mkEntitiesOf(NUMERIC + "DF");
        mCache.put(mkKey(NEW_ENERGY, 0), civilProvince);
        mCache.put(mkKey(NEW_ENERGY, 1), lettersHasO);
        mCache.put(mkKey(NEW_ENERGY, 2), lettersNumeric);
        mCache.put(mkKey(NEW_ENERGY, 3), lettersNumeric);
        mCache.put(mkKey(NEW_ENERGY, 4), lettersNumeric);
        mCache.put(mkKey(NEW_ENERGY, 5), lettersNumeric);
        mCache.put(mkKey(NEW_ENERGY, 6), lettersNumeric);
        mCache.put(mkKey(NEW_ENERGY, 7), lettersNumeric);
    }

    /**
     * 根据指定车牌号码类型和位置，返回当前可用的全部键位
     *
     * @param type          车牌类型
     * @param selectedIndex 当前选择的位置
     * @return 全部可用键位
     */
    public RowEntry available(NumberType type, int selectedIndex) {
        final RowEntry found = mCache.get(mkKey(type, selectedIndex));
        if (null != found) {
            return found;
        } else {
            return new RowEntry(0);
        }
    }

    private static String mkKey(NumberType type, int index) {
        return "@" + type.name() + "." + index;
    }

}
