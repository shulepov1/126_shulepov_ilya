package task;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.io.File;

public class WebAddressParser {
    private URL address;

    public WebAddressParser(String address){
        try {
            this.address = new URL(address);
        } catch (MalformedURLException e) {
            this.address = null;
        }
    }

    public boolean isValid() {
        return address != null;
    }

    public String getLogin(){
        if(isValid()) {
            String[] authority = address.getAuthority().split("@");
            if(authority.length >= 2) {
                String[] lognpass = authority[0].split(":");
                if (lognpass.length >= 2) {
                    return lognpass[0];
                }
            }
        }
        return "";
    }

    public String getPassword(){
        if(isValid()) {
            String[] authority = address.getAuthority().split("@");
            if(authority.length >= 2) {
                String[] lognpass = authority[0].split(":");
                if (lognpass.length >= 2) {
                    return lognpass[1];
                }
            }
        }
        return "";
    }

    public String getScheme(){
        if(isValid() && address.getProtocol() != null) {
            return address.getProtocol();
        }
        return "";
    }



    public String getHost(){
        if(isValid() && address.getHost() != null) {
            return address.getHost();
        }
        return "";
    }

    public String getPort(){
        if(isValid()   && address.getPort() > 0) {
            return Integer.toString(address.getPort());
        }
        return "";
    }

    public String getUrl(){
        if(isValid() && address.getPath() != null) {
            if (address.getPath().contains("/")) return address.getPath().replaceFirst("/", "");
        }
        return "";
    }


    public HashMap<String, String> getParameters(){
        if(isValid() && address.getQuery() != null) {
            String[] query = address.getQuery().split("&");

            HashMap <String, String> params = new HashMap<>();

            String[] param;
            for (String s : query) {
                param = s.split("=");
                params.put(param[0], param[1]);
            }

            return params;
        }
        return new HashMap<>();
    }

    public String getFragment(){
        if(isValid() && address.getRef() != null) {
            return address.getRef();
        }
        return "";
    }
}