public class Book {
    // member variables / properties / state
    private String title;
    private String author;
    private boolean isAvailable;
    // static member variables are shared between all instances of the class
    // final modifier makes a value constant
    private static final String genre = "YA Fiction";

    // default constructor
    // initializes member variables to default value
    public Book() {
        this.title = "Harry Potter and the Sorcerer's Stone";
        this.author = "J. K. Rowling";
        this.isAvailable = true;
        // you can also use this as a constructor to reference
        // the overloaded constructor below
        // this("Harry Potter and the Sorcerer's Stone", "J.K. Rowling");
    }

    // overloaded constuctor
    // allows us to pass in values for different member variables
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    // copy constructor
    // allows a developer to make an identical copy of an object
    public Book(Book other) {
        // set all of this object's values
        // to the values of the other object
        // deep vs shallow copy
        // deep is going to have completely new objects as member variables
        // shallow is going to share references with the original 
        this.title = other.title;
        this.author = other.author;
        this.isAvailable = other.isAvailable; 
    }

    // accessors / mutators (getters/setters) 
    // for each member variable
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String newValue) {
        this.title = newValue;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String newValue) {
        this.author = newValue;
    }

    // for booleans you may have a different convention
    public boolean getIsAvailable() { // public boolean available()
        return this.isAvailable;
    }

    public void setIsAvailable(boolean availability) {
        this.isAvailable = availability;
    }

    // equals
    // allows you to define the criteria for two instances 
    // of your class to be considered equivalent

    // take in type Object so we can compare our Book
    // to any other type (DVD, Student, Horse, etc)
    public boolean equals(Object o) {
        // return true if the object is equivalent to this object
        // based on our measure of equality
        // return false if they are not equal or if they are different objects
        // first check if o can become the type Book
        if (!(o instanceof Book)) {
            // o cannot be type-cast to a Book
            return false; // not equal if they are different objects
        } else {
            // o can be type-cast to a Book
            Book otherBook = (Book) o; // type-cast to Book
            // so compare the member variables
            return this.title.equals(otherBook.title) &&
            this.author.equals(otherBook.author);
        }
    }

    // toString
    // define how our Objects get printed to the screen
    public String toString() { // ALWAYS the signature
        return "~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" + 
        "Title: " + this.title + "\n" +
        "Author: " + this.author + "\n" +
        "Genre: " + this.genre + "\n" +
        "~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
    }

    public static void main(String[] args) {
        // test our object by creating an instance of it 
        // inside a main method somewhere
        Book defaultBook = new Book();
        // System.out.println(defaultBook);

        Book colorPurple = new Book("The Color Purple","Alice Walker");
        // System.out.println(colorPurple);
        // compare defaultBook to colorPurple
        // System.out.println(defaultBook.equals(colorPurple));

        // test the copy constructor
        Book copyOfColorPurple = new Book(colorPurple);
        System.out.println(copyOfColorPurple);

        System.out.println("Using equals: " + copyOfColorPurple.equals(colorPurple));
        System.out.println("Using ==: " + (copyOfColorPurple == colorPurple));
    }
}