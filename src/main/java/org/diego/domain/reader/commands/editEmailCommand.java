package org.diego.domain.reader.commands;

import org.diego.generic.Command;

public class editEmailCommand extends Command {

    private String readerId;

    private String email;

    public editEmailCommand(String readerId, String email) {
        this.readerId = readerId;
        this.email = email;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
