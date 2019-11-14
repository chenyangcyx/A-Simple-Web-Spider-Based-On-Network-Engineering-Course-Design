package Connection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class GetHttpContent {
    private String url_address;

    //初始化函数
    public GetHttpContent(String request_url){
        this.url_address=request_url;
    }

    //获取内容的函数
    public String GetContent(){
        StringBuffer buffer=null;
        BufferedReader buffer_reader=null;
        InputStream input_stream=null;
        InputStreamReader input_stream_reader=null;
        HttpsURLConnection connection_https=null;
        HttpURLConnection connection_http=null;
        //建立连接并向网页发送请求
        try {
            if(url_address.contains("https://"))
            {
                HttpsCertificate[] http_certi = {new HttpsCertificate()};
                SSLContext ssl_con = SSLContext.getInstance("SSL", "SunJSSE");
                ssl_con.init(null,http_certi,new java.security.SecureRandom());
                //从上述SLL Context对象中得到SSL SocketFactory对象
                SSLSocketFactory ssf=ssl_con.getSocketFactory();
                //建立URL对象
                URL url=new URL(this.url_address);
                connection_https=(HttpsURLConnection)url.openConnection();
                connection_https.setSSLSocketFactory(ssf);
                connection_https.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36");
                //防止报403错误
                connection_https.setDoOutput(true);
                connection_https.setDoInput(true);
                connection_https.setUseCaches(false);
                //设置请求的类型
                connection_https.setRequestMethod("GET");
                //获取输入流
                input_stream=connection_https.getInputStream();
            }
            else
            {
                URL url=new URL(this.url_address);
                connection_http=(HttpURLConnection)url.openConnection();
                connection_http.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36");
                //防止报403错误
                connection_http.setDoOutput(true);
                connection_http.setDoInput(true);
                connection_http.setUseCaches(false);
                //设置请求的类型
                connection_http.setRequestMethod("GET");
                //获取输入流
                input_stream=connection_http.getInputStream();
            }
            input_stream_reader=new InputStreamReader(input_stream, StandardCharsets.UTF_8);
            buffer_reader=new BufferedReader(input_stream_reader);
            //从输入流读取结果
            buffer=new StringBuffer();
            String str=null;
            while ((str=buffer_reader.readLine())!=null)
                buffer.append(str);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            //释放创建的资源
            if(buffer_reader!=null) {
                try {
                    buffer_reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(input_stream_reader!=null) {
                try {
                    input_stream_reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(input_stream!=null) {
                try {
                    input_stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(connection_https!=null)
                connection_https.disconnect();
            if(connection_http!=null)
                connection_http.disconnect();
            //返回获取到的网页内容
            return buffer.toString();
        }
    }
}
