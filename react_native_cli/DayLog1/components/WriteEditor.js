import React, { useRef } from "react";
import { StyleSheet, TextInput, View } from "react-native";

function WriteEditor({title, onChangeTitle, body, onChangeBody}) {
  const bodyRef = useRef();
  return(
    <View style={styles.block}>
      <TextInput 
        placeholder="제목을 입력하세요..."
        style={styles.titleInput}
        value={title}
        onChangeText={onChangeTitle}
        returnKeyType="next"
        onSubmitEditing={() => bodyRef.current.focus()}
      />
      <TextInput 
        placeholder="당신의 오늘을 기록해보세요..."
        style={styles.bodyInput}
        value={body}
        onChangeText={onChangeBody}
        multiline
        textAlignVertical="top"
        ref={bodyRef}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  block: {
    flex: 1,
    padding: 16,
  },
  titleInput: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#263238',
    paddingVertical: 0,
    marginBottom: 16,
  },
  bodyInput: {
    flex: 1,
    fontSize: 16,
    color: '#263238',
    paddingVertical: 0,
  },
});

export default WriteEditor;