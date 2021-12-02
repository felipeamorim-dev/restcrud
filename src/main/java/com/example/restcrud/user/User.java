package com.example.restcrud.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="user")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name="id")
    private Long id;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="createdAt", nullable = false)
    private Date createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(
            name="role_id",
            foreignKey = @ForeignKey(name="fk_user_user_role")
    )
    private UserRole role;

    @Column(name="role_id", insertable = false, updatable = false)
    private Integer roleId;
}
