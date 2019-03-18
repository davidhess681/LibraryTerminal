import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;

public class LoadSave {
	
	public static void InitialStream() {
		Path file = Paths.get("c:/temp/libraryFile.txt");
		try (InputStream in = Files.newInputStream(file);
		    BufferedReader reader =
		      new BufferedReader(new InputStreamReader(in))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		        System.out.println(line);
		        String[] splitLine = line.split(";");
		        String newTitle = splitLine[0];                         // set title author status and date to the respective index
                String newAuthor = splitLine[1];
                boolean newStatus = Boolean.parseBoolean(splitLine[2]);
                Calendar newDueDate = Calendar.getInstance();  // use splitLine[3]
                Book newbook = new Book(newTitle, newAuthor, newStatus, newDueDate);   // create book object with details from file
                Menu.library.add(newbook);
		    }
		} catch (IOException x) {
		    System.err.println(x);
		}
	}
	static void CreateDefaultBooks() {
		Menu.library.add(new Book("In Search of Lost Time", "Marcel Proust"));
		Menu.library.add(new Book("Don Quixote", "Miguel de Cervantes"));
		Menu.library.add(new Book("Ulysses", "James Joyce"));
		Menu.library.add(new Book("The Great Gatsby", "F.Scott Fitzgerald"));
		Menu.library.add(new Book("Moby Dick", "Herman Melville"));
		Menu.library.add(new Book("Hamlet", "William Shakespeare"));
		Menu.library.add(new Book("War and Peace", "Leo Tolstoy"));
		Menu.library.add(new Book("The Odyssey", "Homer"));
		Menu.library.add(new Book("Lolita", "Vladimir Nabokov"));
		Menu.library.add(new Book("On the Road", "Jack Kerouac"));
		Menu.library.add(new Book("Breakfast of champions", "Kurt Vonnegut"));
		Menu.library.add(new Book("The Alchemist", "Paulo Coelho"));
	}
	public static void UpdateLibraryFile() {
		try {
			PrintWriter writer = new PrintWriter("library.txt");
		} catch (Exception e) {
			System.out.println("Something went wrong writing to library file!");
		}
	}
}
