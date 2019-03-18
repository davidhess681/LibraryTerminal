import java.util.Calendar;

public class Book {
	public String Title;
	public String Author;
	public boolean CheckedOut;
	public Calendar DueDate;
	
	public void Checkout() {
		if(!CheckedOut) {
			System.out.println();
			String print0 = "Would you like to check out "+Title+" by "+Author+"? (y/n): ";
			System.out.println(print0);
                if (Prompt.YesOrNo())
                {
                    CheckedOut = true;//if y, set as checked out, and set due date to 2 weeks from now
                    DueDate = Calendar.getInstance();
                    DueDate.add(Calendar.DAY_OF_MONTH, 14);
                    String print1 = "\nThe Book "+Title+" has been checked out by you. Due date is "+DueDate+"\n";
                    System.out.println(print1);
                }
                else
                {
                    System.out.println("\nCheckout aborted.");
                }
		}
		else {
			String print1 = "\nThe Book "+Title+" is already checked out. Due date is "+DueDate+"\n";
            System.out.println(print1);
		}
	}
	public void Return() {
		if(CheckedOut) {
			String print0 = "Would you like to return "+Title+" by "+Author+"? (y/n): ";
			System.out.println(print0);
			if (Prompt.YesOrNo())
            {
                CheckedOut = false;
                String print1 = "\nThe Book "+Title+" has been returned. Thank you!";
                System.out.println(print1);
            }
            else
            {
                System.out.println("\nReturn aborted.");
            }
		}
		else {
			String print1 = "\nThe Book "+Title+" is already checked in.";
            System.out.println(print1);
		}
	}
	public Book(String title, String author, boolean checkedOut, Calendar dueDate)
    {
        Title = title;
        Author = author;
        CheckedOut = checkedOut;
        DueDate = dueDate;
    }
	public Book(String title, String author)
    {
        Title = title;
        Author = author;
        CheckedOut = false;
        DueDate = null;
    }
}
