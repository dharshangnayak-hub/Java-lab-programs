import java.util.Scanner;

class Book
{
    String name, author;
    double price;
    int num_pages;

    Book(String name, String author, double price, int num_pages)
    {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    public String toString()
    {
        return "Book Name: " + name +
               "\nAuthor: " + author +
               "\nPrice: " + price +
               "\nNumber of pages: " + num_pages;
    }
}

public class bookin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of books:");
        int n = sc.nextInt();
        sc.nextLine(); 

        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter book " + (i + 1) + " details: ");
            System.out.print("Enter book name: ");
            String name = sc.nextLine();
            System.out.print("Enter author name: ");
            String author = sc.nextLine();  
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            System.out.print("Enter no. of pages: ");
            int pages = sc.nextInt();
            sc.nextLine(); 
            books[i] = new Book(name, author, price, pages);
        }

        System.out.println("\n--Book Details--\n");
        for (int i = 0; i < n; i++) {
            System.out.println("Book " + (i + 1) + " details: ");
            System.out.println(books[i].toString());
        }
        sc.close();
    }
}