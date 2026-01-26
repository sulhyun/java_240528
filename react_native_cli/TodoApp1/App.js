import React, { useState } from "react";
import { SafeAreaProvider, SafeAreaView } from "react-native-safe-area-context";
import { KeyboardAvoidingView, Platform, StyleSheet } from "react-native";
import DateHead from './components/DateHead';
import AppTodo from './components/AppTodo';
import Empty from './components/Empty';

function App() {
  const today = new Date();
  const [todos, setTodos] = useState([
    {id: 1, text: 'Test1', done: false},
    {id: 2, text: 'Test2', done: true},
    {id: 3, text: 'Test3', done: true},
  ]);
  return (
    <SafeAreaProvider>
      <SafeAreaView edges={['bottom']} style={styles.block}>
        <KeyboardAvoidingView
          style={styles.avoid}
          behavior={Platform.OS === 'ios' ? 'padding' : undefined}
        >
          <DateHead date={today} />
          <Empty />
          <AppTodo />
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