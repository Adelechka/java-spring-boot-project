package ru.itis.reddit.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@ToString(exclude = "posts")
@EqualsAndHashCode(exclude = "posts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "login", name = "uniqueLoginConstraint")
        }
        )
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    private String login;

    private String hashPassword;

    @Column(nullable = true)
    private String photos;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public enum State {
        ACTIVE, BANNED
    }

    public enum Role {
        USER, ADMIN
    }

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public boolean isBanned() {
        return this.state == State.BANNED;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    @ManyToMany(mappedBy = "likes")
    private List<Post> likedPosts;

}
