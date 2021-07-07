package cn.wxniubility.video.utils;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.utils
 * ClassName: BaseUtil
 *
 * @author: weixuan
 * @Date: 2021/7/4
 * @Time 11:28
 * Description:
 */
public class BaseUtil {

    public static int[] getRandom(int count){
        int[] nubs = new int[Constants.RECOMMEND];
        for (int i = 0; i < Constants.RECOMMEND; i++) {
            int ran = new Random().nextInt(count);
            boolean flag = true;
            for (int j = 0; j < nubs.length; j++) {
                if(ran == nubs[j]){
                    flag = false;
                }
            }
            if(flag){
                nubs[i] = ran;
            }else{
                i--;
            }
        }
        return nubs;
    }
}
