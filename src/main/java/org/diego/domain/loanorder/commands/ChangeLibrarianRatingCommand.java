package org.diego.domain.loanorder.commands;

import org.diego.generic.Command;

public class ChangeLibrarianRatingCommand extends Command {

    private String loanOrderId;
    private double validation;

    public ChangeLibrarianRatingCommand(String loanOrderId, double validation) {
        this.loanOrderId = loanOrderId;
        this.validation = validation;
    }

    public String getLoanOrderId() {
        return loanOrderId;
    }

    public void setLoanOrderId(String loanOrderId) {
        this.loanOrderId = loanOrderId;
    }

    public double getValidation() {
        return validation;
    }

    public void setValidation(double validation) {
        this.validation = validation;
    }
}
