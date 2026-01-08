import React from 'react';
import { View, Text, StyleSheet } from 'react-native';
import DateHead from './components/DateHead';
import AddTodo from './components/AddTodo';
import Empty from './components/Empty';

const App = () => {
  const today = new Date();

  return (
    <>
      <View style={styles.block}>
        <DateHead date={today} />
        <Empty />
        <AddTodo />
      </View>
    </>
  );
};

const styles = StyleSheet.create({
  block: {
    flex: 1,
  },
})

export default App;