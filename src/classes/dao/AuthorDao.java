package classes.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import classes.users.Author;

public class AuthorDao implements Dao<Author>{
    
    private List<Author> authors = new ArrayList<>();

    public AuthorDao(){
        authors.add(new Author("Thiago Campos", "Thithi@proton.com", "oNytPeV%St5xtxJr2mKZ5e#z#G3s$Z8", "(XX)XXXXXXXXX", "XXX.XXX.XXX-XX"));
    }

    @Override
    public Optional<Author> get(long id){
        return Optional.ofNullable(authors.get((int) id));
    }

    @Override
    public List<Author> getAll(){
        return authors;
    }

    @Override
    public void save(Author author){
        authors.add(author);
    }

    @Override
    public void update(Author author, String[] params){
        author.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
        author.setEmail(Objects.requireNonNull(params[1], "Email cannot be null"));
        author.setPassword(Objects.requireNonNull(params[2], "Password cannot be null"));
        author.setPhone(Objects.requireNonNull(params[3], "Phone cannot be null"));
        author.setDocument(Objects.requireNonNull(params[4], "Document cannot be null"));
    }

    @Override
    public void delete(Author author){
        authors.remove(author);
    }


}
