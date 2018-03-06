package com.chinasoft.system.util;

import java.io.*;
import java.net.URL;
import java.util.Map;

import com.cloud.sdk.http.HttpMethodName;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ApiUtil {
    public ApiUtil() {
    }

    private AccessService accessService = null;


    /**
     * 短信发送get方法
     * @param ak
     * @param sk
     * @param requestUrl
     */
    public HttpResponse get(String serviceName, String region, String ak, String sk, String requestUrl) {
        HttpResponse response=null;
        try {
            accessService = new AccessServiceImpl(serviceName, region, ak, sk);
            URL url = new URL(requestUrl);
            HttpMethodName httpMethod = HttpMethodName.GET;
            response = accessService.access(url, httpMethod);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }




    /**
     * 短信发送post方法
     * @param ak
     * @param sk
     * @param requestUrl
     * @param postbody
     */
    public HttpResponse  post(String serviceName,String region,String ak, String sk, String requestUrl,
                              String postbody,Map header) throws Exception {
        accessService = new AccessServiceImpl(serviceName,
                region, ak, sk);
        URL  url = new URL(requestUrl);
        InputStream content = new ByteArrayInputStream(postbody.getBytes());
        HttpMethodName httpMethod = HttpMethodName.POST;
        HttpResponse  response = accessService.access(url,header, content,
                (long) postbody.getBytes().length, httpMethod);
        return response;
    }

    /**
     * 关闭访问服务链接
     * **/

    public  void close(){
        accessService.close();
    }


    /**
     * @param file
     * @return string
     * */
    public  String translateImageToString(File file) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        int buf_size = 1024;
        byte[] buffer = new byte[buf_size];
        int len = 0;
        while (-1 != (len = in.read(buffer, 0, buf_size))) {
            bos.write(buffer, 0, len);
        }
        byte[] fileData= bos.toByteArray();
        String baseStr=java.util.Base64.getEncoder().encodeToString(fileData);
        in.close();
        bos.close();
        return  baseStr;
    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

}
