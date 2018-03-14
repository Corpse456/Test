package url2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URL2 {
    public static void main (String[] args) {
        String url_get_page = "http://www.pai.pt/search.ds?activeSort=name+-maindocflag|asc&distSort=false&encodedRefinement=namechar1..%3d..^A%24..%26..A&what=Advogados&startingPageNumber=1&stageName=What+search&originalOffset=1&expandWWWSearch=false&myplaces=false&distance=50&searchType=www&phoneNumberSearch=false&advancedSearch=true&alphaRefineable=AN4683|BN317|CN2373|DN696|EN704|FN1549|GN456|HN539|IN670|JN3704|KN8|LN1433|MN4143|NN606|ON318|PN1727|QN9|RN1383|SN1522|TN484|UN14|VN677|WN16|XN8|YN4|ZN23|[0-9]N0&excludeZone=false&restoSearch=false&firstMaxRank=43522&previousPath=search";

        StringBuffer result = new StringBuffer();
        URL url;
        try {
            url = new URL(url_get_page);
            HttpURLConnection connection = null;
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setReadTimeout(10000);
            connection.setRequestProperty("Host", "www.pai.pt");
            connection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 5.1; ru; rv:1.9.2) Gecko/20100115 Firefox/3.6");
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            connection.setRequestProperty("Accept-Language", "ru,en-us;q=0.7,en;q=0.3");
            connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
            // connection.setRequestProperty("Accept-Charset",
            // "windows-1251,utf-8;q=0.7,*;q=0.7");
            connection.setRequestProperty("Keep-Alive", "115");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Referer", "http://www.pai.pt/search.ds");
            connection.setRequestProperty("Cookie",
                    "MfPers=12678646695048a98819027298bf50127329f8c315e8f; vuid=8a98819027298bf50127329f8c315e8f; ptkn=40EAFA18-5758-F374-F570-A0480F306222; WT_FPC=id=174.142.104.57-1456441520.30063880:lv=1267888167073:ss=1267888167073; __utma=76091412.2059393411.1267864686.1267878351.1267891770.4; __utmz=76091412.1267864686.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); BFHost=wd-web04.osl.basefarm.net; JSESSIONID=20C8FD4414F50F3AE361C487D0E3C719; MfTrack=12678917654148a98819027298bf50127329f8c315e8f; BIGipServerwd-web-pt=285284362.20480.0000; __utmb=76091412.1.10.1267891770; __utmc=76091412");
            connection.connect();

            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF8"));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line).append("\n");
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
    }
}
