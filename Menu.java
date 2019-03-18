import java.util.ArrayList;

public class Menu {
	static boolean loopMenu = true;
	public static ArrayList<Book> library = new ArrayList<Book>();
	public static void MainMenu() {
		while(loopMenu) {
			switch (Prompt.MenuChoice()) {
			case 1:
				ListAllBooks();
				break;
			case 2:
				Search();
				break;
			case 3:
				CheckoutBook();
				break;
			case 4:
				ReturnBook();
				break;
			case 5:
				AddBook();
				break;
			case 6:
				Quit();
				break;
			}
		}
	}
	static void PrintResults(ArrayList<Book> lib) {
		System.out.println("\nTitle\tAuthor");
		System.out.println("=======================================================================");
		for (Book book : lib) {
			System.out.println(book.Title + "\t" + book.Author);
		}
	}
	static ArrayList<Book> SearchResults() {
		boolean choice = Prompt.ByTitleOrAuthor();
		String userSearch = Prompt.ValidTitle();
		ArrayList<Book> serachResults = new ArrayList<Book>();
		if(choice) {
			for (Book b : library) {
				if (b.Title.toLowerCase().contains(userSearch)) {
					serachResults.add(b);
				}
			}
		}
		else {
			for (Book b : library) {
				if (b.Author.toLowerCase().contains(userSearch)) {
					serachResults.add(b);
				}
			}
		}
		return serachResults;
	}
	static Book getBook() {
		ArrayList<Book> results = SearchResults();
		int choice;
		PrintResults(results);
		if(results.size() == 1) {
			choice = 1;
		}else {
			choice = Prompt.SearchChoice(results.size());
		}
		return results.get(choice-1);
	}
	static void ListAllBooks() {
		PrintResults(library);
	}
	static void Search() {
		PrintResults(SearchResults());
	}
	static void CheckoutBook() {
		getBook().Checkout();
	}
	static void ReturnBook() {
		getBook().Return();
	}
	static void AddBook() {
		System.out.println("\nWhat is the Title of the Book you want to add? ");
        String newTitle = Prompt.TitleCaseString();
        System.out.println("\nWhat is the Author of the book you want to add? ");
        String newAuthor = Prompt.TitleCaseString();

        Book newBook = new Book(newTitle, newAuthor);

        library.add(newBook);
        System.out.println("Book added to list");
	}
	static void Quit() {
		System.out.println("Are you sure you want to quit? (y/n): ");
		if(Prompt.YesOrNo()) {
			loopMenu = false;
		}
	}
}
