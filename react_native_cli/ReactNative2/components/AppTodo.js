import React from "react";
import { StyleSheet, TextInput, View } from "react-native";

function AppTodo() {
  return(
    <View style={styles.block}>
      <TextInput style={styles.input} placeholder="할일을 입력하세요..." />
    </View>
  );
};

const styles = StyleSheet.create({
  block: {
    height: 64,
    paddingHorizontal: 16,
    borderColor: '#bdbdbd',
    borderTopWidth: 1,
    borderBottomWidth: 1,
    justifyContent: 'center',
  },
  input: {
    fontSize: 16,
    paddingVertical: 8,
  },
});

export default AppTodo