package org.diego.domain.loanorder.events;

import org.diego.generic.DomainEvent;

public class LoanOrderCreated extends DomainEvent {

    private final String branchId;
    private final String nameBranch;
    private final String streetBranch;
    private final String avenueBranch;
    private final int houseNumberBranch;
    private final String phone;
    private final String city;
    private final String readerId;
    private final String bookId;

    private final String bookCatalogId;

    public LoanOrderCreated(String branchId, String nameBranch, String streetBranch, String avenueBranch, int houseNumberBranch, String phone, String city, String readerId, String bookId, String bookCatalogId) {
        super("org.diego.createleanorder");
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

    public String getBranchId() {
        return branchId;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public String getStreetBranch() {
        return streetBranch;
    }

    public String getAvenueBranch() {
        return avenueBranch;
    }

    public int getHouseNumberBranch() {
        return houseNumberBranch;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getReaderId() {
        return readerId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookCatalogId() {
        return bookCatalogId;
    }
}
