package cn.wxniubility.video.utils;

import java.io.IOException;
import java.util.Properties;

public class Constants {
	//用户Session
	public final static String USER_SESSION;
	//分页数量
	public final static int PAGESIZE;
	//轮播图数量
	public final static int CAROUSEL;
	//推荐数量
	public final static int RECOMMEND;
	//发布评论冷却时间
	public final static long COMMENTCD;
	static {
		Properties pop = new Properties();
		try {
			pop.load(Constants.class.getClassLoader().getResourceAsStream("constants.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		USER_SESSION = pop.getProperty("USER_SESSION");
		PAGESIZE = Integer.parseInt(pop.getProperty("PAGESIZE"));
		CAROUSEL = Integer.parseInt(pop.getProperty("CAROUSEL"));
		RECOMMEND = Integer.parseInt(pop.getProperty("RECOMMEND"));
		COMMENTCD = Integer.parseInt(pop.getProperty("COMMENTCD"));
	}
}
