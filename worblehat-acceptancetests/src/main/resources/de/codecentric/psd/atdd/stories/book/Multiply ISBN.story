Meta:
@themes Book

Narrative:
In order to add new/borrow books to/from the library
As a user
I want to have unique isbns for same books

Scenario:

Given an empty library
When a book with ISBN <isbn> is added twice
Then the page contains error message <message>

Examples:
 
| isbn       | message |
| 1111111111 | Die ISBN ist nicht eindeutig! Bitte geben Sie eine eindeutige ISBN ein! |

