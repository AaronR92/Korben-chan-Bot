package com.aaronr92.korben_chan_bot.command;

import com.aaronr92.korben_chan_bot.Emote;
import com.aaronr92.korben_chan_bot.Flag;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class NewYearBoxesCommand extends ListenerAdapter {

    Random random = new Random();
    private int prevRandNum;

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if (event.getName().equals("����������")) {
            int randNum = random.nextInt(16);
            if (randNum == prevRandNum)
                randNum = random.nextInt(16);
            if (randNum == 0) {
                event.reply(style() + "������� ������� �� "  + Flag.BRITAIN.getCode() +
                        " Super Conqueror.").queue();
            } else if (randNum == 1) {
                event.reply("���� ����� " + Flag.USA.getCode() + " M47 Patton Improved").queue();
            } else if (randNum == 2) {
                event.reply("���� ����� " + Flag.CHINA.getCode() + " BZ-176").queue();
            } else if (randNum == 3) {
                event.reply("���� ����� " + Flag.FRANCE.getCode() + " Char Mle. 75").queue();
            } else if (randNum == 4) {
                event.reply("���� ����� "  + Flag.ITALY.getCode() + " Vipera").queue();
            } else if (randNum == 5) {
                event.reply("���� ����� " + Flag.USA.getCode() + " AMBT").queue();
            } else if (randNum == 6) {
                event.reply("���� ����� " + Flag.USSR.getCode() + " ��-2-122").queue();
            } else if (randNum == 7) {
                event.reply("���� ����� " + Flag.GERMANY.getCode() + " Pz.Kpfw. KW I (r)").queue();
            } else if (randNum == 8) {
                event.reply("���� ����� " + Flag.USA.getCode() + " �3 �����").queue();
            } else if (randNum == 9) {
                event.reply("���� ����� " + Flag.GERMANY.getCode() + " Pz.Kpfw. 38H 735 (f)").queue();
            } else if (randNum == 10) {
                event.reply("���� ����� " + Flag.USSR.getCode() + " ������ �����").queue();
            } else if (randNum == 11) {
                event.reply(style() + "��������� �� "  + Flag.SWEDEN.getCode() +
                        " Strv 103B.").queue();
            } else if (randNum == 12) {
                event.reply(style() + "�������� �� "  + Flag.ITALY.getCode() +
                        " Controcarro 3 Minotauro.").queue();
            } else if (randNum == 13) {
                event.reply(style() + "������������� �� "  + Flag.FRANCE.getCode() +
                        " Bat.-Chatillon 155 58. (���).").queue();
            } else if (randNum == 14) {
                event.reply(style() + "�������� �� "  + Flag.FRANCE.getCode() +
                        " Char Futur 4. (9 ���).").queue();
            } else if (randNum == 15) {
                event.reply("���� ����� ����������� �����").queue();
            }
            prevRandNum = randNum;
        }
    }

    private String style() {
        return "���� ����� 3D-����� ";
    }
}
