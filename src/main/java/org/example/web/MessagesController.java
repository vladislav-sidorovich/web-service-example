package org.example.web;

import org.example.entity.Message;
import org.example.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessagesController {
    @Autowired
    private MessagesService messagesService;

    @GetMapping("/messages")
    public String messages() {
        List<Message> messages = messagesService.allMessages();
        StringBuilder responseBody = new StringBuilder();
        for (Message message : messages) {
            responseBody
                    .append("[")
                    .append("messageText: '").append(message.getText()).append("'")
                    .append(", ")
                    .append("messageDate: '" ).append(message.getCreationDate()).append("'")
                    .append("]");
        }

        return responseBody.toString();
    }

    @PostMapping("/messages")
    public String add(@RequestBody String text) {
        Message message = new Message(text);
        long count = messagesService.addMessage(message);
        return count + "";
    }
}
