package com.aaronr92.korben_chan_bot;

import com.aaronr92.korben_chan_bot.command.*;
import com.aaronr92.korben_chan_bot.listener.FileReader;
import com.aaronr92.korben_chan_bot.listener.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Bot {

    public static final String path = String.format("%s\\OneDrive\\keywords.txt", System.getProperty("user.home"));

    public static void main(String[] args) throws LoginException {

        final String TOKEN = args[0];

        JDA jda = JDABuilder.createLight(TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MEMBERS)
                .setBulkDeleteSplittingEnabled(false)
                .setActivity(Activity.playing("World of Tanks"))
                .addEventListeners(new MessageListener(), new SayCommand(), new FlipCoinCommand(), new AddKeywordCommand(),
                        new LengthCommand(), new FileReader())
                .build();

        jda.updateCommands().addCommands(
                Commands.slash("�������", "������� ���-��")
                        .addOptions(new OptionData(OptionType.STRING, "�����", "����� ��� ����, ����� �������", true)),
                Commands.slash("��������", "��������� ����� ������ ����� - �����")
                        .addOptions(new OptionData(OptionType.STRING, "�����", "�����, �� ������� ��� �������", true))
                        .addOptions(new OptionData(OptionType.STRING, "�����", "�����, ������� ��� �������", true)),
                Commands.slash("����", "�������� ���� �����"),
                Commands.slash("�������", "�������� ������ ������ �����!")
        ).queue();
    }
}
