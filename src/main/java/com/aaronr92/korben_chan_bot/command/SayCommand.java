package com.aaronr92.korben_chan_bot.command;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SayCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("�������")) {
            event.reply(Objects.requireNonNull(event.getOption("�����")).getAsString()).queue(); // reply immediately
        }
    }
}
