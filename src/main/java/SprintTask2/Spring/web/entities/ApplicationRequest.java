package SprintTask2.Spring.web.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="t_application")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "app_userName")
    private String userName;
    @Column(name = "app_courseName")
    private String courseName;
    @Column(name = "app_commentary")
    private String commentary;
    @Column(name = "app_phone")
    private String phone;
    @Column(name = "app_handled")
    private boolean handled;
}
