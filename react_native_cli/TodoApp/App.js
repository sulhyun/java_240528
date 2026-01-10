import React, {useState,useEffect} from 'react';
import { View, Text, StyleSheet } from 'react-native';
import DateHead from './components/DateHead';
import AddTodo from './components/AddTodo';
import Empty from './components/Empty';
import TodoList from './components/TodoList';
import todosStorage from './storages/todosStorage';

const App = () => {
  const today = new Date();
  const [edit, setEdit] = useState(null);
  const [todos, setTodos] = useState([
    {id: 1, text: '작업환경 설정', done: true},
    {id: 2, text: '리액트 네이티브 기초 공부', done: false},
    {id: 3, text: '투두리스트 만들어 보기', done: false},
  ]);

  useEffect(() => {
    todosStorage
      .get()
      .then(setTodos)
      .catch(console.error);
  }, []);

  useEffect(() => {
    todosStorage
      .set(todos)
      .catch(console.error);
  }, [todos]);
  
  const onInsert = (text) => {
    const trimText = text.trim();
    if(trimText === "") {
      return;
    }
    const nextId = todos.length > 0 ? Math.max(...todos.map(todo => todo.id)) + 1 : 1;
    const todo = {
      id: nextId,
      text: trimText,
      done: false
    };
    setTodos(todos.concat(todo));
  }

  const onToggle = (id) => {
    const nextTodos = todos.map(todo => todo.id === id ? {...todo, done : !todo.done } : todo);
    setTodos(nextTodos);
  }

  const onRemove = (id) => {
    const nextTodos = todos.filter(todo => todo.id !== id);
    setTodos(nextTodos);
  }

  const findTodo = (id) => {
    const todo = todos.find((todo) => todo.id === id);
    setEdit(todo);
  }

  const onUpdate = (id, text) => {
    const trimText = text.trim();
    if(trimText === "") {
      return;
    }
    const nextTodos = todos.map((todo) => todo.id === id ? {...todo, text : trimText} : todo);
    setTodos(nextTodos);
    setEdit(null);
  }

  return (
    <>
      <View style={styles.block}>
        <DateHead date={today} />
        {todos.length === 0 ? <Empty /> : <TodoList todos={todos} onToggle={onToggle} onRemove={onRemove} findTodo={findTodo} />}
        <AddTodo onInsert={onInsert} onUpdate={onUpdate} edit={edit} />
      </View>
    </>
  );
};

const styles = StyleSheet.create({
  block: {
    flex: 1,
    backgroundColor: 'white'
  },
})

export default App;