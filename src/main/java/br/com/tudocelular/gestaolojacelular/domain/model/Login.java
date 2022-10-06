package br.com.tudocelular.gestaolojacelular.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "login")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID loginId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @ColumnTransformer(forColumn = "senha", read = "pgp_sym_decrypt(senha::bytea, 'password')", write = "pgp_sym_encrypt(?, 'password')")
    @Column(name = "senha", columnDefinition = "bytea", nullable = false)
    private String senha;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Login that = (Login) o;
        return loginId != null && Objects.equals(loginId, that.loginId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
