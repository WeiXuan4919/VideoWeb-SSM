package cn.wxniubility.video.pojo;

/**
 * Created by IntelliJ IDEA.
 * PackageName: cn.wxniubility.video.pojo
 * ClassName: ResultInfo
 *
 * @author: weixuan
 * @Date: 2021/7/3
 * @Time 21:40
 * Description:
 */
public class ResultInfo {
    private boolean flag;
    private String message;
    private Object data;
    private int pages;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
