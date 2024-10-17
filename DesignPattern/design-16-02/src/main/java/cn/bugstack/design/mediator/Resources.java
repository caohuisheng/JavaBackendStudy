package cn.bugstack.design.mediator;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-16
 */
public class Resources {

    public static InputStreamReader getResourceAsReader(String resource) throws IOException {
        return new InputStreamReader(getResourceAsStream(resource));
    }

    /**
     * 获取资源并转换成流
     * @param resource 资源文件路径
     * @return 资源文件对应的流
     * @throws IOException
     */
    private static InputStream getResourceAsStream(String resource) throws IOException {
        ClassLoader[] classLoaders = new ClassLoader[]{ClassLoader.getSystemClassLoader(), Thread.currentThread().getContextClassLoader()};
        for(ClassLoader classLoader:classLoaders){
            InputStream inputStream = classLoader.getResourceAsStream(resource);
            if(null != inputStream){
                return inputStream;
            }
        }
        throw new IOException("Could not find resource " + resource);
    }

}
