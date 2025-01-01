// 20230724


public class Book {
    String name = "책";

    void print() {
        System.out.println(name);
    }
}

class Magazin extends Book {
    String name = "매거진";

    @Override
    void print() {
        System.out.println(name + "magazin");
    }

    void special() {
        System.out.println("so special");
    }
}

class Cartoon extends Book {
    String name = "만화";

    @Override
    void print() {
        System.out.println(name + "만화");
    }

    void exciting() {
        System.out.println("so exciting");
    }
}

class Main {
    public static void main(String[] args) {
    //     Book book = new Magazin();
    //     System.out.println(book.name);
    //     book.print();

        Book[] books = new Book[2];
        books[0] = new Magazin();
        books[1] = new Cartoon();
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book instanceof Cartoon) {
                Cartoon cartoon = (Cartoon) book;
                cartoon.exciting(); // 반대는 묵시적으로 내가 쓰고 있었네
            }
        }
    }
}