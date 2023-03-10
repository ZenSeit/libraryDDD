# Library DDD

This is an academic project to apply DDD (Domain Drive Design).

In this project we focus on the management of books, when a reader borrows a book and how to modify the status of books in the book catalogs.


# Through my project

Below you can find the process that was carried out starting from the conception of the idea to the execution.

## Big picture

![big picture](https://user-images.githubusercontent.com/95058140/224387978-7efe4e8e-5e08-4e82-aa5c-6acd7b0d90d1.png)

Image above describes in general terms how the business is distributed. Book lending was chosen as the core domain because this is the backbone of the business, this is the reason why the library exists. Additionally we have other support domains such as the reader and the book catalog.

Different bounded context were proposed, but in this case we will focus on **Book check out and return** 

## Bounded context, ubiquitous language and domain model

In the image below you can find the solution that I developed. I have 3 aggregates (Reader, Book Catalog and Loan Order) with 2 entities per each.

![bounded](https://user-images.githubusercontent.com/95058140/224388594-6a40d0ea-3e5f-4d34-a3a6-0b8649ab8a2c.png)

Next image shows domain model, how aggregates, entities and value objects interact and their respective behaviors

![domain model](https://user-images.githubusercontent.com/95058140/224389224-489f2298-ce95-44dd-bbfd-f39cd1304d17.png)

## Command driven use cases

* Reader aggregate
	- **Reader Registered Use Case**:  Create a reader with information as name, address, email, etc.
	- **Address Modified Use Case**: Update address relate to reader.
	- **Rating Changed Use Case**: Calculate rating for a reader, using before rating and making an average.
	- **Email Edited Use Case**: Update email relate to reader.
* Book Catalog aggregate:
	- **Book Catalog Created Use Case**: Create a new book catalog
	- **Book Added Use Case**: Add a new book to a specific book catalog
	- **Book Remove Use Case**: Remove a book that exist in a book catalog
* Loan Order aggregate:
	- **Loan Order Created Use Case**: Create a new loan order storing info from reader, catalog and book.
	- **Librarian Assigned Use Case**: Assign a librarian to loan order
	- **Librarian Rating Changed Use Case**: Calculate rating for a librarian.

## Event driven use cases
* **Reader Account State Updated Use Case**: When a loan order is created, update number of books that reader has loaned.
* **Book State Changed Use Case**: When a loan order is created, change state from a book (is borrow or not)

## Coverage

![Screenshot from 2023-03-10 13-24-47](https://user-images.githubusercontent.com/95058140/224394448-f10ccbcc-1cc8-420e-8140-80674e67278f.png)
