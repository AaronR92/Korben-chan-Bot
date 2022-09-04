package com.aaronr92.korben_chan_bot.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class HelpCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("����")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("�������");
            embedBuilder.setDescription("������ ���� ������ ����");
            embedBuilder.addField("`/�������`", "������� ��, ��� ������� � ���������", true);
            embedBuilder.addField("`/��������`", "��������� ����� ������� �����-�����", true);
            embedBuilder.addBlankField(true);
            embedBuilder.addField("`/����`", "�������� ��������� �����", true);
            embedBuilder.addField("`/�������`", "��������� �������, �� ������� ������ �����", true);
            embedBuilder.addBlankField(true);
            embedBuilder.addBlankField(true);
            embedBuilder.addField("`/post`",
                    "��������� ��������� ����� � ����� �����, ���������� ����������� � ����������", true);
            embedBuilder.addField("`/info`", "�������������� ���������, ������������ � ��������� �����", true);
            embedBuilder.setColor(Color.PINK);
            event.replyEmbeds(embedBuilder.build()).queue();
        }
    }
}
