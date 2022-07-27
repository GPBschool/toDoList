package main.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "to_do")
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;

    public ToDoEntity(ToDoDto toDoDto){
        setId(toDoDto.getId());
        setName(toDoDto.getName());
        setDescription(toDoDto.getDescription());
    }

}
