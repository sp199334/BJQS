package com.home.crm.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
  * 类名：EncryptUtils.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年7月16日
  * @version    1.0
*/
public class EncryptUtils {

    public static String encrypt(String str,String salt, String algorithmName, int hashIterations)
    {
        return new SimpleHash(algorithmName,str, ByteSource.Util.bytes(salt),hashIterations).toString();
    }

}
