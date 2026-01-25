package level1.librarysystem;

public class Book {
   private String title;
   private String  author;
   private String isbn ;
    private  boolean isAvailable=true;
    Book (   String title , String  author , String isbn ){
        this.title=title;
        this.author=author;
        this.isbn=isbn;

    }


    public String getInfo() {
        return  "- "+title + " by "+ author + " (ISBN: "+ isbn +" )";
    }
    void borrow(){
     if(isAvailable){
         isAvailable=false;
     }

    }
    void returnBook(){
        if(!isAvailable){
            isAvailable=true;
        }
    }


    public String getIsbn() {
        return isbn;
    }


    boolean isAvailable(){
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }
}
