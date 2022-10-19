package com.aaronr92.korben_chan_bot.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class SendInfoCommand extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("info")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("����� ����������!");
            embedBuilder.setDescription("�������� ������ �� ����������� �� ���������������!");
            embedBuilder.addField("�������",
                    """
                    1. ��� ����������, �������� nsfw-��������, � ����� ���������
                    2. ��� ����� ������ (�� ����� 3). �� ����� �������� ���
                    3. �����������, � ��� ����� ��������������� ���������
                    4. ����������� ������������� ������ ���������� ������� �� �����
                    5. ���������� - � ����������� ������
                    6. �� �������� ����� �������� ���
                    7. ��������� ��� �����""", true);
            embedBuilder.setFooter("��������, �����!");
            embedBuilder.setColor(Color.PINK);
            event.getOption("�����").getAsChannel().asTextChannel().sendMessageEmbeds(embedBuilder.build()).queue();
        }
    }
}
