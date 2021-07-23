import static spark.Spark.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        port(getHerokuAssignedPort());

        get("/", (req,res)->{

            return "hello world ";
        });

    }
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
