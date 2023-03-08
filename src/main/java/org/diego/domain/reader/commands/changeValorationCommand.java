package org.diego.domain.reader.commands;

import org.diego.generic.Command;

public class changeValorationCommand extends Command {

    private String readerId;
    private double valoration;

    public changeValorationCommand(String readerId, double valoration) {
        this.readerId = readerId;
        this.valoration = valoration;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public double getValoration() {
        return valoration;
    }

    public void setValoration(double valoration) {
        this.valoration = valoration;
    }
}
