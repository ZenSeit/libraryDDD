package org.diego.domain.loanorder.commands;

import org.diego.generic.Command;

public class CreateLoanOrderCommand extends Command {

    private String loanOrderId;
    private String branchId;
    private String nameBranch;
    private String streetBranch;
    private String avenueBranch;
    private int houseNumberBranch;
    private String phone;
    private String city;
    private String readerId;
    private String bookId;
    private String bookCatalogId;

    public CreateLoanOrderCommand(String loanOrderId, String branchId, String nameBranch, String streetBranch, String avenueBranch, int houseNumberBranch, String phone, String city, String readerId, String bookId,String bookCatalogId) {
        this.loanOrderId = loanOrderId;
        this.branchId = branchId;
        this.nameBranch = nameBranch;
        this.streetBranch = streetBranch;
        this.avenueBranch = avenueBranch;
        this.houseNumberBranch = houseNumberBranch;
        this.phone = phone;
        this.city = city;
        this.readerId = readerId;
        this.bookId = bookId;
        this.bookCatalogId = bookCatalogId;
    }

    public String getLoanOrderId() {
        return loanOrderId;
    }

    public void setLoanOrderId(String loanOrderId) {
        this.loanOrderId = loanOrderId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public String getStreetBranch() {
        return streetBranch;
    }

    public void setStreetBranch(String streetBranch) {
        this.streetBranch = streetBranch;
    }

    public String getAvenueBranch() {
        return avenueBranch;
    }

    public void setAvenueBranch(String avenueBranch) {
        this.avenueBranch = avenueBranch;
    }

    public int getHouseNumberBranch() {
        return houseNumberBranch;
    }

    public void setHouseNumberBranch(int houseNumberBranch) {
        this.houseNumberBranch = houseNumberBranch;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookCatalogId() {
        return bookCatalogId;
    }

    public void setBookCatalogId(String bookCatalogId) {
        this.bookCatalogId = bookCatalogId;
    }
}
