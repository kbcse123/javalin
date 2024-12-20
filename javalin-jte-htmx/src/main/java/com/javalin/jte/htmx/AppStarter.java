package com.javalin.jte.htmx;

import io.javalin.Javalin;
import io.javalin.community.ssl.SslPlugin;

/**
 * Hello world!
 */
public class AppStarter {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result("Hello World"));

    }

}
