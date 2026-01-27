import React, { useState } from "react";
import { SafeAreaProvider, SafeAreaView } from "react-native-safe-area-context";
import { KeyboardAvoidingView, Platform, StyleSheet } from "react-native";
import DateHead from './components/DateHead';
import AppTodo from './components/AppTodo';
import Empty from './components/Empty';
import TodoList from './components/TodoList';

function App() {
  const today = new Date();
  const [edit, setEdit] = useState(null);
  const [todos, setTodos] = useState([
    {id: 1, text: '작업환경 설정', done: true},
    {id: 2, text: '리액트 네이티브 기초 공부', done: false},
    {id: 3, text: '투두 리스트 만들어보기', done: false},
  ]);
  
  const onInsert = text => {
    // 새로 등록할 항목의 id를 구합니다.
    // 등록된 항목 중에서 가장 큰 id를 구하고, 그 값이 1을 더합니다.
    // 만약 리스트가 비어있다면 1을 id로 사용합니다.
    const nextId = todos.length > 0 ? Math.max(...todos.map(todo => todo.id)) + 1 : 1;
    const todo = {
      id: nextId,
      text,
      done: false,
    };
    setTodos(todos.concat(todo));
  }; // 추가
  
  const onToggle = id => {
    const nextTodos = todos.map(todo => id === todo.id ? {...todo, done: !todo.done} : todo);
    setTodos(nextTodos);
  }; // 토글

  const onRemove = id => {
    const nextTodos = todos.filter(todo => id !== todo.id);
    setTodos(nextTodos);
  }; // 삭제

  const findTodo = id => {
    const todo = todos.find(todo => id === todo.id);
    setEdit(todo);
  }; // 수정할 객체 찾기

  const onUpdate = (id, text) => {
    const nextTodos = todos.map(todo => id === todo.id ? {...todo, text} : todo);
    setTodos(nextTodos);
    setEdit(null);
  }; // 수정
  return (
    <SafeAreaProvider>
      <SafeAreaView edges={['bottom']} style={styles.block}>
        <KeyboardAvoidingView
          style={styles.avoid}
          behavior={Platform.OS === 'ios' ? 'padding' : undefined}
        >
          <DateHead date={today} />
          {todos.length === 0 ? <Empty /> : <TodoList todos={todos} onToggle={onToggle} onRemove={onRemove} findTodo={findTodo} />}
          <AppTodo onInsert={onInsert} onUpdate={onUpdate} edit={edit} />
        </KeyboardAvoidingView>
      </SafeAreaView>
    </SafeAreaProvider>
  );
};

const styles = StyleSheet.create({
  block: {
    flex: 1,
    backgroundColor: 'white',
  },
  avoid: {
    flex: 1,
  },
});

export default App;