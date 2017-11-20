package autotest.todo.list.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class Property {

   private final String TODO_NAME = "My todo";
   private final String LIST_NAME = "My list";
   private final String TODO_NAME_IN_MY_LIST = "My todo in my list";
   private final String CATEGORY_NAME = "My category";
}
