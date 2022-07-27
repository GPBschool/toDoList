package main.service;

import lombok.RequiredArgsConstructor;
import main.models.ToDoEntity;
import main.models.ToDoDto;
import main.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public Collection<ToDoDto> findAll() {
        return toDoRepository.findAll()
                .stream()
                .map(ToDoDto::new)
                .collect(Collectors.toList());
    }

    public Optional<ToDoDto> findById(int id) {
        return toDoRepository.findById(id).map(ToDoDto::new);
    }

    public void deleteById(int id) {
        toDoRepository.deleteById(id);
    }

    public void add(ToDoDto toDoDto) {

        toDoRepository.save(new ToDoEntity(toDoDto));
    }

    public void update(ToDoDto toDoDto) {
        if (toDoRepository.existsById(toDoDto.getId())) {
            toDoRepository.save(new ToDoEntity(toDoDto));
        }
    }
}
