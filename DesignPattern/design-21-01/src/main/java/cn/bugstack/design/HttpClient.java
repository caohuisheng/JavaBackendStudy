package cn.bugstack.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class HttpClient {

    public static String doGet(String httpUrl){
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;

        try {
            //创建远程URL连接对象
            URL url = new URL(httpUrl);
            //通过URL连接对象打开连接
            connection = (HttpURLConnection) url.openConnection();
            //设置连接方式
            connection.setRequestMethod("GET");
            //设置连接主机服务器的超时时间15s
            connection.setConnectTimeout(15000);
            //设置读取远程返回数据的超时时间60s
            connection.setReadTimeout(60000);
            //发送请求
            connection.connect();
            if(connection.getResponseCode() == 200){
                //获取输入流
                is = connection.getInputStream();
                //封装输入流，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                //存放数据
                StringBuilder sb = new StringBuilder();
                String str = null;
                while((str = br.readLine()) != null){
                    sb.append(str).append("\r\n");
                }
                result = sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            //关闭资源
            if(null != br){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //关闭远程连接
            assert connection != null;
            connection.disconnect();
        }

        return result;
    }

}
