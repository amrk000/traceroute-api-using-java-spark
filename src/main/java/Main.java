import spark.utils.SparkUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args){
        try{
        Spark.setPort(8080);
        get("/", (req,res)->{

            return "hello world";
        });

    }
     catch(Exception e) {e.printStackTrace;}
}
    }
