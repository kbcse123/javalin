package com.javalin;

import com.javalin.controller.UserController;
import io.javalin.Javalin;
import io.javalin.community.ssl.SslPlugin;

/**
 * Hello world!
 *
 */
public class AppStarter
{
    public static void main( String[] args )
    {
        SslPlugin plugin = new SslPlugin(sslConfig -> {
            sslConfig.keystoreFromPath("C:\\Users\\kbcse\\personal\\projects\\javalin\\javalin-demo\\src\\main\\resources\\ssl\\selfsigned-ssl.p12","password");
        });

        var app = Javalin
                .create(javalinConfig -> javalinConfig.registerPlugin(plugin))
                .start(8443);
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/users", UserController.fetchAllUsernames);
        app.get("/users/{id}", UserController.fetchById);
    }

}
