package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.Book;
public class BookTest {
	Book b = new Book(1, "test", "test", 12.3f);
	b.addAuthor("Khuong");
	String content = "This is content";
	b.setContent(content);
	b.toString();
}
