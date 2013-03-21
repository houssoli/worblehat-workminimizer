Narrative:
In order to keep a clean database of books
As a librarian
I want to have my entries validated

Scenario:

Given an empty library

When the librarian tries to add a book with an <attribute> of <value>

Then the library contains a no book with an <attribute> of <value>
And the page contains error message <message>

Examples:
 
| attribute | value      | message               |
| ISBN      | 5234567969 | Falsche ISBN!	     |
| Edition   | 2. Edition | Falsche Edition! 	 |

