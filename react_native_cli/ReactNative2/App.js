import React from "react";
import { SafeAreaProvider, SafeAreaView } from "react-native-safe-area-context";
import DateHead from './components/DateHead';
import AppTodo from './components/AppTodo';
import Empty from './components/Empty';
import { KeyboardAvoidingView, Platform, StyleSheet } from "react-native";

function App() {
  const today = new Date();
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
}

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
