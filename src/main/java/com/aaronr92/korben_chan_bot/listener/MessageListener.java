package com.aaronr92.korben_chan_bot.listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class MessageListener extends ListenerAdapter {

    public static Map<String, String> keywords = new HashMap<>();

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        if (keywords.containsKey(encodeMessage(message).toLowerCase())) {
            event.getChannel().sendMessage(encodeMessage(keywords.get(message.toLowerCase()))).queue();
        }
        if (encodeMessage(message).equals(encodeMessage(message).toUpperCase()) && message.length() > 4) {
            event.getMessage().reply("�� ����� �����").queue();
        }
        if (encodeMessage(message).toLowerCase().startsWith("!�������")) {
//            int count = 0;
//            try {
//                count = Integer.parseInt(encodeMessage(message).split(" ")[1]);
//            } catch (NumberFormatException e) {
//                event.getMessage().reply(encodeMessage("�����? ������ ������� ���������� ���!")).queue();
//                return;
//            }
//            if (count > 99) {
//                event.getMessage().reply(encodeMessage("�������� - 100 ���������")).queue();
//                return;
//            } else if (count < 1) {
//                event.getMessage().reply(encodeMessage("������� - 1 ���������")).queue();
//                return;
//            }
//            List<Message> history = event.getChannel().getHistoryBefore(event.getMessage(), count).complete().getRetrievedHistory();
//            log.warn("Purging {} messages! By {}", history.size(), event.getAuthor());
//            for (Message m :
//                    history) {
//                System.out.println(m.toString());
//                m.delete().reason("Cleared by command").queueAfter(2, TimeUnit.SECONDS);
//            }
//            event.getMessage().reply(encodeMessage("��� ��� �������!")).queue();
            event.getMessage().reply(encodeMessage("���� �� ��������!")).queue();
        }
    }

    public static String encodeMessage(String message) {
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
