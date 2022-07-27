package main.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDto {

    private Integer id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 5, max = 255, message = "Количество символов минимум 5, максимум 255")
    private String name;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 0, max = 255, message = "Количество символов максимум 255")
    private String description;

    public ToDoDto(ToDoEntity toDoEntity) {
        setId(toDoEntity.getId());
        setName(toDoEntity.getName());
        setDescription(toDoEntity.getDescription());
    }
}
