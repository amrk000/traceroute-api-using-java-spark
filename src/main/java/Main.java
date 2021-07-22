import spark.utils.SparkUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args){
        
        port(8080);
        get("/", (req,res)->{

//            Process p = Runtime.getRuntime().exec("traceroute "+req.params(":ip"));
//            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            p.waitFor();
//
//            if (p.exitValue() == 1) return 1;
//
//            StringBuilder Result = new StringBuilder();
//            while (reader.readLine() != null) Result.append(reader.readLine()).append("</br>");
//            reader.close();
//
//            return Result;
            return "hello world";
        });

    }

}
