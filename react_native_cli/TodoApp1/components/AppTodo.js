import React, { useEffect, useState } from "react";
import { Image, Keyboard, StyleSheet, TextInput, TouchableOpacity, View } from "react-native";

function AppTodo({onInsert, onUpdate, edit}) {
  const [text, setText] = useState('');

  useEffect(() => {
    if(edit) {
      setText(edit.text);
    }
  }, [edit]);

  const onPress = () => {
    if(edit) {
      onUpdate(edit.id, text);
    } else {
      onInsert(text);
    }
    setText('');
    Keyboard.dismiss();
  };
  return(
    <View style={styles.block}>
      <TextInput 
        style={styles.input} 
        placeholder={edit ? '할일을 수정하세요...' : "할일을 입력하세요..."} 
        value={text}
        onChangeText={setText}
        onSubmitEditing={onPress}
        returnKeyType="done"
      />
      <TouchableOpacity activeOpacity={0.5} onPress={onPress}>
        <View style={styles.button}>
          <Image source={require('../assets/icons/add_white/add_white.png')} />
        </View>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  block: {
    backgroundColor: 'white',
    height: 64,
    paddingHorizontal: 16,
    borderColor: '#bdbdbd',
    borderTopWidth: 1,
    borderBottomWidth: 1,
    alignItems: 'center',
    flexDirection: 'row',
  },
  input: {
    fontSize: 16,
    paddingVertical: 8,
    flex: 1,
  },
  button: {
    alignItems: 'center',
    justifyContent: 'center',
    width: 48,
    height: 48,
    backgroundColor: '#26a69a',
    borderRadius: 24,
  },
});

export default AppTodo;