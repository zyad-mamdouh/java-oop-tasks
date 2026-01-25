package level1.librarysystem;

import java.util.ArrayList;

public class Library {
    private String name;
     ArrayList<Book>  books=new ArrayList<>();
     ArrayList<Member>  members=new ArrayList<>();

    public Library(String name ) {
        this.name=name;
    }
     void addBook(Book book){
        books.add(book);
    }
     void registerMember(Member member){
        members.add(member);
    }
     void lendBook(Member member , String isbn){
        for(Book book: books){
            if (book.getIsbn().equals(isbn) && book.isAvailable()){
                book.borrow();
                member.borrowBook(book);
                System.out.println(member.getName() + " borrowed: " + book.getTitle());
                return;
            }
        }

    }
     void receiveBook(Member member , String isbn){
        for(Book book: books){
            if(book.getIsbn().equals(isbn)){
                book.returnBook();
                member.returnBook(book);
                System.out.println(member.getName() + " returned: " + book.getTitle());
                return;
            }
        }

    }
     void displayAvailableBooks(){
        for (Book book:books){
            if(book.isAvailable()){
                System.out.println(book.getInfo());
            }
        }

    }
    void search(String title){
        for (Book book : books){
            if (book.getTitle().equalsIgnoreCase(title)){
                System.out.println(book.getInfo());
            }
        }

    }
    String getName() {
        return name;
    }

}
