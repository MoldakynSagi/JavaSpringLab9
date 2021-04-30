package kz.iitu.lms.demo.model;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
public class Userbooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",updatable = false,insertable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)

    @JsonIgnore
    private User user;
    @Column(name = "user_id")
    private Long userId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id",updatable = false,insertable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)

    @JsonIgnore
    private Book book;
    @Column(name = "book_id")
    private Long bookId;
}
