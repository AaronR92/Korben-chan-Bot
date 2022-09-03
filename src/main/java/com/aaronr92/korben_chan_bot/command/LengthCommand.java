package com.aaronr92.korben_chan_bot.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class LengthCommand extends ListenerAdapter {
    Random random = new Random();

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("����")) {
            event.reply(String.format("%d ��!", random.nextInt(3, 45))).queue();
        }
    }
}
