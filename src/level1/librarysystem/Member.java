package level1.librarysystem;

import java.util.ArrayList;

public class Member {
    private String name;
    private String memberId;
    private ArrayList<Book> borrowedBooks=new ArrayList<>();

    Member(String name , String memberId ){
        this.name=name;
        this.memberId=memberId;
    }


    public String getInfo() {
        return "Member{" +
                "name='" + name + '\'' +
                ", memberId='" + memberId + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
    void borrowBook(Book book){
        if(borrowedBooks.size() >=3){
            System.out.println("Can not borrow more than 3");
        }else borrowedBooks.add(book);


    }
    void returnBook(Book book){
        borrowedBooks.remove(book);

    }

    public String getName() {
        return name;
    }

}

