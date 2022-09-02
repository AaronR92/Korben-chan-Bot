package com.aaronr92.korben_chan_bot.command;

import com.aaronr92.korben_chan_bot.listener.MessageListener;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.Random;

public class AddKeywordCommand extends ListenerAdapter {
    String[] replies = {"������!", "����!", "������� �..", "�� � ��� ������?"};
    Random r = new Random();
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("��������")) {
            String word = Objects.requireNonNull(event.getOption("�����")).getAsString().toLowerCase();
            String reply = Objects.requireNonNull(event.getOption("�����")).getAsString();
            MessageListener.keywords.put(word, reply);
            event.reply(replies[r.nextInt(replies.length)]).queue();
        }
    }
}