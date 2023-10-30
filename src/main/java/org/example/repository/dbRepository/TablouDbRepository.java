package org.example.repository.dbRepository;

import org.example.domain.Tablou;
import org.example.domain.Tablou;
import org.example.domain.Validator;
import org.example.repository.Repository;

import java.sql.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class TablouDbRepository implements Repository<Long, Tablou> {

    private String url;
    private String username;
    private String password;
    private Validator<Tablou> validator;

    public TablouDbRepository(String url, String username, String password, Validator<Tablou> validator) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.validator = validator;
    }

    @Override
    public Optional<Tablou> findOne(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Iterable<Tablou> findAll() {
        Set<Tablou> users = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from tablou");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String titlu = resultSet.getString("titlu");
                String pictor = resultSet.getString("pictor");
                String tematica = resultSet.getString("tematica");
                Double celebritate = resultSet.getDouble("celebritate");

                Tablou utilizator = new Tablou(titlu, pictor , tematica , celebritate);
                utilizator.setId(id);
                users.add(utilizator);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<Tablou> save(Tablou entity) {
        String sql = "insert into tablou (titlu,pictor,tematica , celebritate) values (?, ?, ? ,?)";
        validator.validate(entity);
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, entity.getTitlu());
            ps.setString(2, entity.getPictor());
            ps.setString(3, entity.getTematica());
            ps.setDouble(4, entity.getCelebritate());

            ps.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            return Optional.ofNullable(entity);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Tablou> delete(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Optional<Tablou> update(Tablou entity) {
        return Optional.empty();
    }
}





