import spark.Spark;
import spark.utils.SparkUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        port($PORT);

        get("/", (req,res)->{

            return "hello world ";
        });

    }
}
