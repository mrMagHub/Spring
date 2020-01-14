package ru.otus.work.repositories;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.work.domain.Genre;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("Тест класса GenreDaoJdbc")
@ActiveProfiles("test")
public class GenreJpaImplTest {

    @Autowired
    private GenreJpa genreJpa;

    public static final String NAME = "name";

    @Test
    @DisplayName("Проверка добавления")
    public void insertTest() {
        Genre genre = Genre
                .builder()
                .name(NAME)
                .build();

        Genre genreIns = genreJpa.save(genre);
        Genre genreById = genreJpa.getById(genreIns.getId()).orElse(null);
        assertThat(genreById).isNotNull();
        assertThat(genreById.getId()).isEqualTo(genreIns.getId());
        assertThat(genreById.getName()).isEqualTo(NAME);
    }

    @Test
    @DisplayName("Проверка удаления")
    public void deleteTest() {
        Genre genre = Genre
                .builder()
                .name(NAME)
                .build();

        Genre genreIns = genreJpa.save(genre);
        Genre genreById = genreJpa.getById(genreIns.getId()).orElse(null);
        assertThat(genreById).isNotNull();

        genreJpa.deleteById(genreIns.getId());
        Genre GenreByIdFind = genreJpa.getById(genreIns.getId()).orElse(null);
        assertThat(GenreByIdFind).isNull();
    }

    @Test
    @DisplayName("Проверка обновления")
    public void updateTest() {
        Genre genre = Genre
                .builder()
                .name(NAME)
                .build();

        Genre genreIns = genreJpa.save(genre);
        Genre genreById = genreJpa.getById(genreIns.getId()).orElse(null);
        assertThat(genreById).isNotNull();

        String name = "newName";
        genreById.setName(name);

        genreJpa.save(genreById);

        genreById = genreJpa.getById(genreIns.getId()).orElse(null);
        assertThat(genreById).isNotNull();
        assertThat(genreById.getName()).isEqualTo(name);
    }
}