import spark.Spark;
import spark.utils.SparkUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args){
        
        for(int port;port<=8080;port++){
        try{
            Spark.setPort(port);
            get("/", (req,res)->{

                return "hello world "+port;
            });
        
        }
        catch(Exception e) {e.printStackTrace();}
        }
    }
}
