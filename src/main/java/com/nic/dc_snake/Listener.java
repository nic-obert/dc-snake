package com.nic.dc_snake;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.exceptions.MissingAccessException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listener extends ListenerAdapter {

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        event.getGuild().getTextChannels().forEach((TextChannel channel) -> {
            channel.sendMessage("Halloooo this is DC-Snake!");
        });
    }


    @Override
    public void onDisconnect(@NotNull DisconnectEvent event) {
        System.out.println("Bot is shutting down");
        event.getJDA().getGuilds().forEach((Guild guild) -> {
            guild.getTextChannels().forEach((TextChannel channel) -> {
                System.out.println(channel.getName());
                try {
                    channel.sendMessage("DC-Snake is getting OUT of your HOME!").queue();
                } catch (MissingAccessException e) {
                    System.out.println("Cannot access " + channel.getName());
                }
            });
        });
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("Bot is ready");
        event.getJDA().getGuilds().forEach((Guild guild) -> {
            guild.getTextChannels().forEach((TextChannel channel) -> {
                System.out.println(channel.getName());
                try {
                    channel.sendMessage("Halloooo DC-Snake is READY to COME inside your HOME!").queue();
                } catch (MissingAccessException e) {
                    System.out.println("Cannot access " + channel.getName());
                }
            });
        });
    }
}
