Meta:
@themes Book

Narrative:
In order to add new books to the library
As a librarian
I want to add books through the website

Scenario:

Given an empty library
When a book with ISBN <isbn> is added
Then the library contains a book with <isbntrim>

Examples:
 
| isbn       | isbntrim |
| 111 111-1111 | 1111111111 |
| 978-9081278812 | 9789081278812 |






