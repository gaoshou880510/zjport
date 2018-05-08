import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.testng.annotations.Test;

import java.io.IOException;

public class Hello {

    public static void main(String[] args) throws IOException {
        Document doc = null;
        //doc = Jsoup.connect("http://www.baidu.com").get();
        doc = jsoupGet("http://www.baidu.com");
        System.out.println(doc.toString());
        System.out.println("HeLLO WORLD");
    }

    @Test
    public static Document jsoupGet(String url)  {
        Document doc;
        try {
            doc = Jsoup.connect(url).get();
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Document jsoupPost(String url,String username,String password){
        Document doc;
        Connection conn = Jsoup.connect(url);
        conn.data("username",username);
        conn.data("password",password);
        try {
            doc = conn.post();
            return doc;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
