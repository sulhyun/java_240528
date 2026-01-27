import React from "react";
import { Alert, Image, StyleSheet, Text, TouchableOpacity, View } from "react-native";
import Icon from 'react-native-vector-icons/MaterialIcons';

function TodoItem({id, text, done, onToggle, onRemove, findTodo}) {
  const remove = () => {
    Alert.alert(
      '삭제',
      '정말로 삭제하시겠어요?',
      [
        {text: '취소', onPress: () => {}, style: 'cancel'},
        {text: '삭제', onPress: () => {onRemove(id);}, style: 'destructive'},
      ],
      {
        cancelable: true,
        onDismiss: () => {},
      },
    );
  }; // 사용자에게 정말 삭제할건지 물어보는 알림창
  return(
    <View style={styles.item}>
      <TouchableOpacity onPress={() => onToggle(id)}>
        <View style={[styles.circle, done && styles.filled]}>
          {done && <Image source={require('../assets/icons/check_white/check_white.png')}/>}
        </View>
      </TouchableOpacity>
      <Text style={[styles.text, done && styles.lineThrough]}>{text}</Text>
      {done ? (
        <TouchableOpacity onPress={remove}>
          <Icon name='delete' size={32} color='red' />
        </TouchableOpacity>
      ) : (
        <TouchableOpacity onPress={() => findTodo(id)}>
            <Icon name='edit' size={32} color='blue' />
        </TouchableOpacity>
      )}
    </View>
  );
};

const styles = StyleSheet.create({
  item: {
    flexDirection: 'row',
    padding: 16,
    alignItems: 'center',
  },
  circle: {
    width: 24,
    height: 24,
    borderRadius: 12,
    borderColor: '#26a69a',
    borderWidth: 1,
    marginRight: 16,
  },
  filled: {
    backgroundColor: '#26a69a',
    alignItems: 'center',
    justifyContent: 'center'
  },
  text: {
    flex: 1,
    fontSize: 16,
    color: '#212121',
  },
  lineThrough: {
    color: '#9e9e9e',
    textDecorationLine: 'line-through',
  },
});

export default TodoItem;