package com.example.sudhir_project_phase.Chat;

public class ChatObject {
    String chatId,title;

    public ChatObject(String chatId){
        this.chatId=chatId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }
}
