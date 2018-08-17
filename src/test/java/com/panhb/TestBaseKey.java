package com.panhb;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.panhb.model.base.BaseKey;
import org.apache.commons.collections.CollectionUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author hongbo.pan
 * @date 2018/8/17
 */
public class TestBaseKey {

    @Test
    public void TestEquals() {
        BaseKey key1 = new BaseKey();
        key1.setKey1("1");
        key1.setKey2("2");
        key1.setKey3("3");
        key1.setKey4("4");
        key1.setKey5("5");

        BaseKey key2 = new BaseKey();
        key2.setKey1("1");
        key2.setKey2("2");
        key2.setKey3("3");
        key2.setKey4("4");
        key2.setKey5("5");

        Map<BaseKey,String> map = Maps.newHashMap();

        map.put(key1,"1");
        map.put(key2,"2");

        System.out.println(map.size());
        System.out.println(map.get(key1));
        System.out.println(map.get(key2));

        Set<BaseKey> set = Sets.newHashSet();
        set.add(key1);
        set.add(key2);
        System.out.println(set.size());

        List<BaseKey> list = Lists.newArrayList(key1,key2);
        System.out.println(list.size());


        Map<BaseKey, List<BaseKey>> keyListMap = Maps.newHashMap();
        for (BaseKey baseKey1 : list) {
            if (keyListMap.containsKey(baseKey1)) {
                keyListMap.get(baseKey1).add(baseKey1);
            } else {
                keyListMap.put(baseKey1, Lists.newArrayList(baseKey1));
            }
        }

        Maps.filterKeys(keyListMap, (@Nullable BaseKey baseKey) -> {
            return baseKey.equals(key1);
        });


        CollectionUtils.filter(list, (Object o) -> {
            BaseKey baseKey1 = (BaseKey)o;
            return baseKey1.equals(key1);
        });


    }
}
