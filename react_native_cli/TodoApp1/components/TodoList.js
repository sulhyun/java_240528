import React from "react";
import { FlatList, StyleSheet, View } from "react-native";
import TodoItem from './TodoItem';

function TodoList({todos, onToggle, onRemove, findTodo}) {
  return(
    <FlatList
      style={styles.list}
      data={todos}
      renderItem={({item}) => (
        <TodoItem id={item.id} text={item.text} done={item.done} onToggle={onToggle} onRemove={onRemove} findTodo={findTodo} />
      )}
      keyExtractor={item => item.id.toString()}
      ItemSeparatorComponent={() => <View style={styles.separator} />}   
    />
  );
};

const styles = StyleSheet.create({
  list: {
    flex: 1,
  },
  separator: {
    borderBottomWidth: 2,
    borderColor: '#e0e0e0',
  },
});

export default TodoList;