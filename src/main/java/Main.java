import java.io.BufferedReader;
import java.io.InputStreamReader;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        port(getHerokuAssignedPort());

        get("/traceroute/:ip", (req,res)->{

            Process p = Runtime.getRuntime().exec("traceroute "+req.params(":ip"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            p.waitFor();

            if (p.exitValue() == 1) return 1;

            StringBuilder Result = new StringBuilder();
            while (reader.readLine() != null) Result.append(reader.readLine()).append("</br>");
            reader.close();

            return Result;});

    }
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
