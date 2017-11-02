package com.taotao.test;

import org.junit.Test;

import java.util.UUID;

/**
 * Created by Long on 2017/11/1
 */
public class UUIDTest {

    @Test
    public void testUUID(){
        int hashCode = UUID.randomUUID().hashCode();
        String uuid = UUID.randomUUID().toString();
        System.out.println(hashCode);
        System.out.println(uuid);
    }

}
