package cart.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import cart.util.BookException;
import cart.util.IdVerifier;


@Stateful
public class CartBean implements Cart {
    List<String> contents;
    String customerId;
    String customerName;

    public void initialize(String person) throws BookException {
        if (person == null) {
            throw new BookException("Null person not allowed.");
        } else {
            customerName = person;
        }

        customerId = "0";
        contents = new ArrayList<String>();
    }

    public void initialize(
        String person,
        String id) throws BookException {
        if (person == null) {
            throw new BookException("Null person not allowed.");
        } else {
            customerName = person;
        }

        IdVerifier idChecker = new IdVerifier();

        if (idChecker.validate(id)) {
            customerId = id;
        } else {
            throw new BookException("Invalid id: " + id);
        }

        contents = new ArrayList<String>();
    }

    public void addBook(String title) {
        contents.add(title);
    }

    public void removeBook(String title) throws BookException {
        boolean result = contents.remove(title);

        if (result == false) {
            throw new BookException("\"" + title + "\" not in cart.");
        }
    }

    public List<String> getContents() {
        return contents;
    }

    @Remove()
    public void remove() {
        contents = null;
    }
}


