package ua.nprblm.springboottodoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.nprblm.springboottodoapp.models.TodoItem;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
