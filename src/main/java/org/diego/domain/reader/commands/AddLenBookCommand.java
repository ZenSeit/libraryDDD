package org.diego.domain.reader.commands;

import org.diego.generic.Command;

public class AddLenBookCommand extends Command {

    private String ReaderId;

    public AddLenBookCommand(String readerId) {
        ReaderId = readerId;
    }

    public String getReaderId() {
        return ReaderId;
    }

    public void setReaderId(String readerId) {
        ReaderId = readerId;
    }
}
