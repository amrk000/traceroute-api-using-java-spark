import java.io.BufferedReader;
import java.io.InputStreamReader;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        port(80);
        get("/traceroute/:ip", (req,res)->{

            Process p = Runtime.getRuntime().exec("traceroute -w 2 "+req.params(":ip"));
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));


            StringBuilder Result = new StringBuilder("");
            while (reader.readLine() != null) Result.append(reader.readLine()).append("</br>");
            reader.close();

            return Result;
        });
        
        get("/", (req,res)->{

            return "Linux Traceroute api homepage";
        });
    }
}
