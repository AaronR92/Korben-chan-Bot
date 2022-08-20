package com.aaronr92.listeners;

import com.aaronr92.Emote;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MessageListener extends ListenerAdapter {

    Random random = new Random();
    Logger log = LoggerFactory.getLogger(MessageListener.class);

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        if (encodeMessage(message).toLowerCase().contains("��")) {
            event.getChannel().sendMessage(encodeMessage("�������� 3, ��� ����!")).queue();
        }
        if (encodeMessage(message).toLowerCase().equals("!���")) {
            event.getChannel().sendMessage(encodeMessage("���� �����!")).queue();
        }
        if (encodeMessage(message).toLowerCase().contains("��� �����")) {
            event.getChannel().sendMessage(encodeMessage("��� �����!")).queue();
        }
        if (encodeMessage(message).toLowerCase().contains("������") ||
                encodeMessage(message).toLowerCase().contains("������") ||
                encodeMessage(message).toLowerCase().contains("��� �"))  {
            event.getMessage().reply(encodeMessage("� ��� ���?")).queue();
        }
        if (encodeMessage(message).toLowerCase().equals("!����")) {
            event.getMessage().reply(random.nextInt(3, 45) + encodeMessage(" ��!")).queue();
        }
        if (encodeMessage(message).toLowerCase().equals("!�����")) {
            event.getChannel().sendMessage(encodeMessage("��� �������!")).queue();
        }
        if (encodeMessage(message).toLowerCase().equals("!����")) {
            event.getMessage().reply(encodeMessage("�� ����")).queue();
        }
        if (encodeMessage(message).toLowerCase().equals("!������")) {
            event.getChannel().sendMessage(Emote.KORBEN_AHUEL.getCode()).queue();
        }
        if (encodeMessage(message).toLowerCase().startsWith("!��������")) {
            event.getChannel().sendMessage(encodeMessage("����� ���� ������-��")).queue();
        }
        if (encodeMessage(message).toLowerCase().startsWith("!�����")) {
            event.getChannel().sendMessage(encodeMessage("� � ����� ��������")).queue();
        }
        if (encodeMessage(message).toLowerCase().startsWith("!����")) {
            event.getChannel().sendMessage(Emote.JOVE.getCode() + encodeMessage(" ���!")).queue();
        }
        if (encodeMessage(message).toLowerCase().startsWith("!���")) {
            event.getChannel().sendMessage(Emote.THE_BARBARIAN.getCode()).queue();
        }
        if (encodeMessage(message).toLowerCase().equals("!����")) {
            event.getChannel().sendMessage(encodeMessage("https://www.youtube.com/c/KorbenDallasNoMercy")).queue();
        }
        if (encodeMessage(message).toLowerCase().equals("!�����")) {
            event.getChannel().sendMessage(encodeMessage("https://trovo.live/s/KorbenDallas")).queue();
        }
        if (encodeMessage(message).toLowerCase().equals("!�����")) {
            event.getMessage().reply(encodeMessage("https://www.donationalerts.com/r/korbendetka")).queue();
        }
        if (encodeMessage(message).toLowerCase().contains("��� �����")) {
            event.getMessage().reply(encodeMessage("��� ���!")).queue();
        }
        if (encodeMessage(message).toLowerCase().startsWith("!�������")) {
            int count = 0;
            try {
                count = Integer.parseInt(encodeMessage(message).split(" ")[1]);
            } catch (NumberFormatException e) {
                event.getMessage().reply(encodeMessage("�����? ������ ������� ���������� ���!")).queue();
                return;
            }
            if (count > 99) {
                event.getMessage().reply(encodeMessage("�������� - 100 ���������")).queue();
                return;
            } else if (count < 1) {
                event.getMessage().reply(encodeMessage("������� - 1 ���������")).queue();
                return;
            }
            List<Message> history = event.getChannel().getHistoryBefore(event.getMessage(), count).complete().getRetrievedHistory();
            log.warn("Purging {} messages! By {}", history.size(), event.getAuthor());
            for (Message m :
                    history) {
                m.delete().reason("Cleared by command").queueAfter(2, TimeUnit.SECONDS);
            }
            event.getMessage().reply(encodeMessage("��� ��� �������!")).queue();
        }
    }

    private String encodeMessage(String message) {
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
