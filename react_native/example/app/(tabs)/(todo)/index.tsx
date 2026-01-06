import { useState } from 'react';
import { StyleSheet, Text, TextInput, View } from 'react-native';

export default function Index() {
  const [text, setText] = useState("");

  const onChangeText = (content: string) => (
    setText(content)
  )
  
  return (
    <View style={ styles.container }>
      <Text style={ styles.titleText }>My Todo List</Text>
      <TextInput value={text} onChangeText={onChangeText}></TextInput>
    </View>
  );
}

const styles = StyleSheet.create({
  container : { flex: 1, backgroundColor: "white", padding: 20, paddingVertical: 70 },
  titleText : { fontSize: 25 },
});