package Connection;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

//自定义的构造向https网址发送的证书
public class HttpsCertificate implements X509TrustManager {
    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {    }

    public X509Certificate[] getAcceptedIssuers(){
        return null;
    }
}
