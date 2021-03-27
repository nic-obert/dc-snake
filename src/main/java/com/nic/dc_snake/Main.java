package com.nic.dc_snake;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;


public class Main {
    public static void main(String[] args) throws LoginException {
        final String API_TOKEN = System.getenv("DCSNAKEKEY");
        JDABuilder builder = JDABuilder.createDefault(API_TOKEN);
        JDA jda = builder.build();

        jda.addEventListener(new Listener());
    }


}
