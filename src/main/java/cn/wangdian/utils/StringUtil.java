package cn.wangdian.utils;

import java.util.Random;

/**
 * Created by 25065 on 2016/9/19.
 */
public class StringUtil {

    public static String random(){
        String base="abcdefghijklmnopqrstuvwxyz0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<6;i++){
            int number=random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String ziMuRandom(){
        String base="abcdefghijklmnopqrstuvwxyz";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<4;i++){
            int number=random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
